package views_controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import model.UserProfile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AddPreference implements Page {
	private RoomMatchGUI controller;
	private UserProfile userProfile;
	
	@FXML
	private ScrollPane scrollPane;
	@FXML 
	private VBox vb;
	@FXML
	private TextArea pDescription;
	@FXML
	private TextArea pOptions;
	@FXML
	private Button savePreferences;
	@FXML
	private Button goBack;
	
	@Override
	public void setMainController(RoomMatchGUI source, UserProfile user) {
		controller = source;
		userProfile = user;
		
		try {
			setInfo();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void setInfo() throws IOException {
		Scanner file1, file2;
		String line2;
		
		file1 = readFile("/txt/descriptions.txt");
		file2 = readFile("/txt/preferences.txt");
		while( file1.hasNextLine() ) {
			vb.getChildren().add(new Label(file1.nextLine()));
			line2 = "Options: ";
			String[] split = file2.nextLine().split(" ");
			for(int i=0; i<split.length; i++) {
				line2 += split[i] + (i==split.length-1 ? "" : ", ");
			}
			vb.getChildren().add(new Label(line2));
			vb.getChildren().add(new Label());
		}
		file1.close();
		file2.close();
		
		scrollPane.setContent(vb);
	}
	
	private Scanner readFile(String path) {
		Scanner file = null;
		String workingDir = System.getProperty("user.dir");

		workingDir += path;
		try {
			file = new Scanner(new File(workingDir));
		} catch (FileNotFoundException e) {
			System.err.println("Failed to read from file " + workingDir);
			e.printStackTrace();
		}

		return file;
	}
	
	@FXML
	private void savePreference(ActionEvent event) {
		System.out.println("Not yet implemented");
	}
	
	@FXML
	private void returnToMainPage(ActionEvent event) throws IOException {
		controller.setToPage(View.MAIN, "Welcome");
	}
	
}
