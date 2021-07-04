package com.internshala.javafxapp;

import javafx.application.Application;
import javafx.application.Platform;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
//import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {
	public static void main(String[]args)
	{
		launch(args);

	}

	@Override
	public void init() throws Exception {
		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new
				FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();
		 MenuBar menuBar=createMenu();
		 rootNode.getChildren().add(0,menuBar);

		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter Tool");
		primaryStage.show();

	}

	//create menu

	private MenuBar createMenu()
	{
		//File Menu
		Menu fileMenu=new Menu("File");
		MenuItem newMenuItem=new MenuItem("new");
		newMenuItem.setOnAction(event -> System.out.println("New Menu Item Clicked"));
		SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();
		MenuItem quitMenuItem=new MenuItem("Quit");
		quitMenuItem.setOnAction(event -> {
			Platform.exit();
			System.exit(0);
		});
		fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);
		//Help Menu
		Menu helpMenu=new Menu("Help");
		MenuItem aboutApp=new MenuItem("about");
		aboutApp.setOnAction(event -> aboutApp());
		helpMenu.getItems().addAll(aboutApp);

		//Menu Bar
		MenuBar menuBar=new MenuBar();
		menuBar.getMenus().addAll(fileMenu,helpMenu);
		return menuBar;
	}

	private void aboutApp()
	{
		Alert alertDialog=new Alert(Alert.AlertType.CONFIRMATION);
		alertDialog.setTitle("My First Desktop App");
		alertDialog.setHeaderText("Learning JavaFX");
		alertDialog.setContentText("I am just a beginner but soon i will be pro and developed awesome game");
		alertDialog.show();
		//Customise Dialog Button
		ButtonType yesBtn=new ButtonType("Yes");
		ButtonType noBtn=new ButtonType("No");
		//add this two button into alert dialog
		alertDialog.getButtonTypes().setAll(yesBtn,noBtn);
		Optional<ButtonType>clickedBtn=alertDialog.showAndWait();
		if(clickedBtn.isPresent() && clickedBtn.get()==yesBtn)
		{
			System.out.println("Yes Button Clicked!");
		}
		if(clickedBtn.isPresent() && clickedBtn.get()==noBtn)
		{
			System.out.println("No Button Clicked");
		}

	}

	@Override
	public void stop() throws Exception {
		System.out.println("STOP");

		super.stop();
	}
}
