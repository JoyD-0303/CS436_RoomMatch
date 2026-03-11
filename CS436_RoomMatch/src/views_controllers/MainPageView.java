package views_controllers;

import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import model.Observer;
import model.UserProfile;

public class MainPageView extends BorderPane implements Observer {
	UserProfile userProfile;
	
	public void initializePanel(UserProfile user) {
		userProfile = user;
		MenuItem option1 = new MenuItem("option1");
		MenuItem option2 = new MenuItem("option2");
		MenuItem option3 = new MenuItem("option3");
		Menu options = new Menu("Options");
		options.getItems().addAll(option1, option2, option3);
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(options);
		this.setTop(menuBar);
		
		Label displayInfo = new Label("Welcome " + userProfile.getUser());
		this.setCenter(displayInfo);
	}

	@Override
	public void update(Object theObserved) {
		
	}
}
