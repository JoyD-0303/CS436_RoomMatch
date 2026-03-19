package views_controllers;

import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import model.Observer;
import model.UserProfile;

public class MainPageView extends BorderPane implements Observer {
	UserProfile userProfile;
	
	public void initializePanel(UserProfile user) {
		this.setTop(null);
		this.setCenter(null);

		userProfile = user;

		MenuItem option1 = new MenuItem("option1");
		MenuItem option2 = new MenuItem("option2");
		MenuItem option3 = new MenuItem("option3");
		Menu options = new Menu("Options");
		options.getItems().addAll(option1, option2, option3);

		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(options);
		this.setTop(menuBar);
		
		Label welcomeLabel = new Label("Welcome " + userProfile.getUser());
		Label sleepLabel = new Label("Sleep Schedule: " + userProfile.getSleepSchedule());
		Label cleanlinessLabel = new Label("Cleanliness: " + userProfile.getCleanliness());
		Label guestsLabel = new Label("Guest Frequency: " + userProfile.getGuests());

		VBox infoBox = new VBox(10);
		infoBox.getChildren().addAll(welcomeLabel, sleepLabel, cleanlinessLabel, guestsLabel);

		this.setCenter(infoBox);
	}

	@Override
	public void update(Object theObserved) {
		
	}
}