package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class viewController implements Initializable{

	@FXML
	private MenuItem menuItemSeller;
	
	@FXML 
	private MenuItem menuItemDepartment;
	
	@FXML
	private MenuItem menuAbout;
	
	@FXML
	public void actionSeller () {
		System.out.println("Seller");
	}
	
	@FXML
	public void actionDepartment () {
		
		loadView("/gui/DepartmentList.fxml");
	
	}
	
	@FXML 
	public void actionAbout () {
		loadView("/gui/About.fxml");
	}
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	//Carregando a view.
	@FXML
	public void loadView (String absoluteName) {
		try {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
		VBox newVbox = loader.load();
		
		Scene mainScene = Main.getMainScene();
		VBox mainVbox = (VBox) ((ScrollPane)mainScene.getRoot()).getContent(); 
		
		Node mainMenu = mainVbox.getChildren().get(0);
		mainVbox.getChildren().clear();
		mainVbox.getChildren().add(mainMenu);
		mainVbox.getChildren().addAll(newVbox.getChildren());
		
		
		
		} catch (IOException e) {
			Alerts.showAlert("IoException", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}
	  
}