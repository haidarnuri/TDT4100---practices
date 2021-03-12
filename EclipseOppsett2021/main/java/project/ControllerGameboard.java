package project;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import com.google.common.collect.Multiset.Entry;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class ControllerGameboard implements Initializable, EventHandler<MouseEvent>{

	@FXML private GridPane visualGameboard;
	private HashMap<Integer, Button> integerButtonIdMap = new HashMap<>();
	@FXML private Label yourName;
	String name = "dd";

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		createChildrenOnBoard();	
	}
	
	
	public void passOnParamter(String name) {
		yourName.setText(name);
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	private void createChildrenOnBoard() {
		int btnIdCounter=0;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				Button button = new Button();
				button.setTranslateX(j*180);
				button.setTranslateY(i*180+100);
				button.setPrefHeight(180);
				button.setPrefWidth(180);
				button.setStyle("-fx-border-color:black");
				button.setText(this.name);
				button.setId("btn"+btnIdCounter);
				integerButtonIdMap.put(btnIdCounter, button);
				btnIdCounter++;
				visualGameboard.getChildren().add(button);
			}			
		}
		integerButtonIdMap.forEach((key, value) 
                -> System.out.println(key + " = " + value.getId())); 
	}
	
	@Override
	public void handle(MouseEvent event) {
		 
	}
	
	
	
	

}
