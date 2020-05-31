package controller;

import java.io.IOException;
import java.util.ArrayList;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.entities.COLOR;
import model.entities.Player;

public class PlayerSceneController {
	
	@FXML
	private Button startGameButton;
	@FXML
	private Button addPlayerButton;
	@FXML
	private ListView<String> playerList;
	@FXML
	private TextField nameInput;
	@FXML
	private MenuButton colorInput;
	@FXML
	private MenuItem colorRosso;
	@FXML
	private MenuItem colorVerde;
	@FXML
	private MenuItem colorGiallo;
	@FXML
	private MenuItem colorRosa;
	@FXML
	private MenuItem colorNero;
	@FXML
	private MenuItem colorBlu;
	
	
	private COLOR tempColor;
	private ArrayList<Player> list;
	private boolean colorChosen;
	
	
	
	public void initialize() {
		startGameButton.setDisable(true);
		addPlayerButton.setDisable(true);
		list = new ArrayList<Player>();
		colorChosen = false;
		
		colorRosso.setOnAction(e -> {
			tempColor = COLOR.RED;
			colorChosen = true;
			enableAddButton();
		});
		colorNero.setOnAction(e -> {
			tempColor = COLOR.BLACK;
			colorChosen = true;
			enableAddButton();
		});
		colorVerde.setOnAction(e -> {
			tempColor = COLOR.GREEN;
			colorChosen = true;
			enableAddButton();
		});
		colorRosa.setOnAction(e -> {
			tempColor = COLOR.PINK;
			colorChosen = true;
			enableAddButton();
		});
		colorBlu.setOnAction(e -> {
			tempColor = COLOR.BLUE;
			colorChosen = true;
			enableAddButton();
		});
		colorGiallo.setOnAction(e -> {
			tempColor = COLOR.YELLOW;
			colorChosen = true;
			enableAddButton();
		});
	}
	
	public void keyReleasedProperty() {
		enableAddButton();
	}
	
	
	public void backPressed(ActionEvent event) throws IOException {
		Parent playerSceneParent = FXMLLoader.load(getClass().getClassLoader().getResource("view/fxmls/view.fxml"));
		Scene playerScene = new Scene(playerSceneParent);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(playerScene);
		window.show();
	}
	
	public void addPlayerPressed(ActionEvent event) throws IOException {
		list.add(new Player(nameInput.getText(), tempColor));
		displayPlayer(new Player(nameInput.getText(), tempColor));
		addPlayerButton.setDisable(true);
		colorChosen = false;
		disableColor();
		if(list.size() > 2) {
			startGameButton.setDisable(false);
		}
		
		
	}
	

	public void restorePressed() {
		initialize();
		playerList.getItems().clear();
		enableColors();
	}
	
	
	
	
	
	
	
	
	
	
	
	private void displayPlayer(Player p) {
		playerList.getItems().add(p.getName() + "      " + p.getColor());
		
	}
	
	private boolean nameExists(String name) {
		for(Player p : list) {
			if(p.getName().equals(name)) {
				return true;
			}
		} 
		return false;
	}
	
	private void disableColor() {
		switch(tempColor) {
		case RED:
			colorRosso.setDisable(true);
			break;
		case YELLOW:
			colorGiallo.setDisable(true);
			break;
		case BLACK:
			colorNero.setDisable(true);
			break;
		case BLUE:
			colorBlu.setDisable(true);
			break;
		case GREEN:
			colorVerde.setDisable(true);
			break;
		case PINK:
			colorRosa.setDisable(true);
			break;
		
		}
	}
	
	private void enableColors() {
		colorRosa.setDisable(false);
		colorBlu.setDisable(false);
		colorNero.setDisable(false);
		colorVerde.setDisable(false);
		colorRosso.setDisable(false);
		colorGiallo.setDisable(false);
	}
	
	private void enableAddButton() {
		if((list.size() == 0)) {
			if(colorChosen && !nameInput.getText().equals(""))
				addPlayerButton.setDisable(false);
			else
				addPlayerButton.setDisable(true);
		}else if(nameExists(nameInput.getText())) {
			addPlayerButton.setDisable(true);
		}else if(colorChosen && !nameInput.getText().equals("")) {
			addPlayerButton.setDisable(false);
		}else
			addPlayerButton.setDisable(true);
	}

}