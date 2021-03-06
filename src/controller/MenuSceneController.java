package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class MenuSceneController {
	

	/**
	 * Manages the pressure of the continue button, continuing the game
	 * @param event is the event generated
	 * @throws IOException
	 */
	public void continuaPressed(ActionEvent e) {
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		window.close();
	}
	

	/**
	 * Manages the pressure of the Esci button, exiting the game
	 * @param event is the event generated
	 * @throws IOException
	 */
	public void esciPressed(ActionEvent e) {
		System.exit(0);
	}
	

	/**
	 * Manages the pressure of the Nuova button, starting a new game
	 * @param event is the event generated
	 * @throws IOException
	 */
	public void nuovaPressed(ActionEvent e) throws IOException {
		GameSceneController.getInstance().newGame();
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		window.close();
	}
	
	
}
