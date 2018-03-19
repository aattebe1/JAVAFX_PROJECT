/*
* Course: CS 1302
* Section: 09
* Professor: Carlos A. Cepeda
* Name: Austin Atteberry
* Assignment #: JavaFx Project
*/

package Project;

import javafx.application.Application;
import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.Button;

import javafx.util.Duration;

public class JavaFxProject extends Application {
	
	
	/* Main method
	 * Description: The program's entry point
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	
	/* Start method
	 * Description: Displays the JavaFx stage
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		/* Object declaration section */
		String welcomeMsg = "Welcome To\nAustin Atteberry's JavaFx Project";
		String courseMsg = "CS 1302\nSection 09\nInstructor Carlos A. Cepeda";
		Text welcomeDisplay = new Text(10, 35, "");
		Text courseDisplay = new Text(10, 150, "");
		
		/* Create a pane */
		Pane homePane = new Pane();
		
		/* Display welcome message */
		WelcomeMessage(homePane, welcomeMsg, welcomeDisplay, courseMsg, courseDisplay);
		
		/* Create Buttons */
		Button btHome = NewButton("btHome.png", "btHomeActive.png", 10, 450);
		Button btAuthors = NewButton("btAuthors.png", "btAuthorsActive.png", 165, 450);
		Button btGames = NewButton("btGames.png", "btGamesActive.png", 382, 450);
		
		/* Create home button action */
		btHome.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				WelcomeMessage(homePane, welcomeMsg, welcomeDisplay, courseMsg, courseDisplay);
			}
		});
		
		/* Add objects to home page */
		homePane.getChildren().add(btHome);
		homePane.getChildren().add(btAuthors);
		homePane.getChildren().add(btGames);
		homePane.getChildren().add(welcomeDisplay);
		
		/* Set stage attributes */
		Scene homeView = new Scene(homePane);
		primaryStage.setTitle("JavaFx Project");
		primaryStage.setScene(homeView);
		primaryStage.setHeight(600);
		primaryStage.setWidth(600);
		primaryStage.setResizable(false);
		primaryStage.getIcons().add(new Image("/icon/icon.gif"));
		primaryStage.show();
	}
	
	
	/* WelcomeMessage method
	 * Description: Creates the welcome message animation
	 */
	public void WelcomeMessage(Pane homePane, String welcomeMsg, Text welcomeDisplay, String courseMsg, Text courseDisplay) {
		/* Set welcome message font */
		welcomeDisplay.setFont(Font.loadFont(JavaFxProject.class.getResource("/Fonts/arumsansextrabold.ttf").toExternalForm(), 40));
		welcomeDisplay.setFill(Color.ORANGERED);
		
		/* Remove courseDisplay from Pane */
		homePane.getChildren().remove(courseDisplay);
		
		/* Declare animation */
		Animation writeMsg = new Transition() {
			{
				/* Set delay between letters */
				setCycleDuration(Duration.millis(3000));
			}
			
			/* Write letter to window */
			protected void interpolate(double letter) {
				welcomeDisplay.setText(welcomeMsg.substring(0, Math.round(welcomeMsg.length() * (float) letter)));
			}
		};
		
		/* Display course information after animation */
		writeMsg.setOnFinished(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				homePane.getChildren().add(courseDisplay);
				CourseMessage(courseMsg, courseDisplay);
			}
		});
		
		/* Display animation */
		writeMsg.play();
	}
	
	
	/* CourseMessage method
	 * Description: Displays the course information
	 */
	public void CourseMessage(String courseMsg, Text courseDisplay) {
		/* Set course information font */
		courseDisplay.setFont(Font.loadFont(JavaFxProject.class.getResource("/Fonts/arumsansextrabold.ttf").toExternalForm(), 20));
		courseDisplay.setFill(Color.ORANGERED);
		
		/* Display course information */
		courseDisplay.setText(courseMsg);
	}
	
	
	/* NewButton method
	 * Description: Creates a button with the supplied parameters
	 */
	public Button NewButton(String normal, String active, int X, int Y) {
		/* Create button image */
		Image normalButton = new Image(getClass().getResourceAsStream("/Buttons/" + normal));
		Image activeButton = new Image(getClass().getResourceAsStream("/Buttons/" + active));
		
		/* Create DropShadow object */
		DropShadow shadow = new DropShadow();
		
		/* Set button properties */
		Button btNew = new Button();
		btNew.setStyle("-fx-border-width: 0; -fx-background-color: transparent;");
		btNew.setGraphic(new ImageView(normalButton));
		btNew.setPrefSize(normalButton.getWidth(), normalButton.getHeight());
		btNew.setLayoutX(X);
		btNew.setLayoutY(Y);
		
		/* Create shadow effect when cursor is over button */
		btNew.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				btNew.setEffect(shadow);
			}
		});
		
		/* Remove shadow effect when cursor is not over button */
		btNew.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				btNew.setEffect(null);
			}
		});
		
		/* Change image when clicked */
		btNew.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				btNew.setGraphic(new ImageView(activeButton));
			}
		});
		
		/* Change image to original when click is released */
		btNew.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				btNew.setGraphic(new ImageView(normalButton));
			}
		});
		
		/* Return button */
		return btNew;
	}
}