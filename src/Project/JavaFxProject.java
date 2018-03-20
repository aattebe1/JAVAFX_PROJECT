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
import javafx.animation.FadeTransition;
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
		Text welcomeDisplay = new Text(20, 35, "");
		Text courseDisplay = new Text(20, 150, "");
		
		/* Create Buttons */
		Button btHome0 = NewButton("btHome.png", "btHomeActive.png", 20, 500);
		Button btHome1 = NewButton("btHome.png", "btHomeActive.png", 20, 500);
		Button btHome2 = NewButton("btHome.png", "btHomeActive.png", 20, 500);
		Button btHomeActive = NewActiveButton("btHomeActive.png", 20, 500);
		Button btAuthors0 = NewButton("btAuthors.png", "btAuthorsActive.png", 185, 500);
		Button btAuthors1 = NewButton("btAuthors.png", "btAuthorsActive.png", 185, 500);
		Button btAuthors2 = NewButton("btAuthors.png", "btAuthorsActive.png", 185, 500);
		Button btAuthorsActive = NewActiveButton("btAuthorsActive.png", 185, 500);
		Button btGames0 = NewButton("btGames.png", "btGamesActive.png", 412, 500);
		Button btGames1 = NewButton("btGames.png", "btGamesActive.png", 412, 500);
		Button btGames2 = NewButton("btGames.png", "btGamesActive.png", 412, 500);
		Button btGamesActive = NewActiveButton("btGamesActive.png", 412, 500);
		
		/* Create panes */
		Pane welcomePane = new Pane();
		Pane homePane = new Pane();
		Pane authorsPane = new Pane();
		Pane gamesPane = new Pane();
		
		/* Set stage attributes */
		primaryStage.setHeight(650);
		primaryStage.setWidth(650);
		primaryStage.setResizable(false);
		primaryStage.getIcons().add(new Image("/icon/icon.gif"));
		
		welcomePane.getChildren().addAll(welcomeDisplay, courseDisplay, btHome0, btAuthors0, btGames0);
		homePane.getChildren().addAll(btHomeActive, btAuthors1, btGames1);
		authorsPane.getChildren().addAll(btHome1, btAuthorsActive, btGames2);
		gamesPane.getChildren().addAll(btHome2, btAuthors2, btGamesActive);
		
		/* Create scenes */
		Scene welcomeView = new Scene(welcomePane);
		Scene homeView = new Scene(homePane);
		Scene authorsView = new Scene(authorsPane);
		Scene gamesView = new Scene(gamesPane);
		
		primaryStage.setTitle("JavaFx Project: Welcome");
		primaryStage.setScene(welcomeView);
		primaryStage.show();
		
		/* Display welcome message */
		WelcomeMessage(welcomePane, welcomeMsg, welcomeDisplay, courseMsg, courseDisplay);
		
		
		
		/* Create home button action */
		btHome0.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				/* Call method to create fade */
				FadeToPane(homePane);
				
				/* Set stage attributes */
				primaryStage.setTitle("JavaFx Project: Home");
				primaryStage.setScene(homeView);
			}
		});
		btHome1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				/* Call method to create fade */
				FadeToPane(homePane);
				
				/* Set stage attributes */
				primaryStage.setTitle("JavaFx Project: Home");
				primaryStage.setScene(homeView);
			}
		});
		btHome2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				/* Call method to create fade */
				FadeToPane(homePane);
				
				/* Set stage attributes */
				primaryStage.setTitle("JavaFx Project: Home");
				primaryStage.setScene(homeView);
			}
		});
		
		/* Create authors button action */
		btAuthors0.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				/* Call method to create fade */
				FadeToPane(authorsPane);
				
				/* Set stage attributes */
				primaryStage.setTitle("JavaFx Project: Authors");
				primaryStage.setScene(authorsView);
			}
		});
		btAuthors1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				/* Call method to create fade */
				FadeToPane(authorsPane);
				
				/* Set stage attributes */
				primaryStage.setTitle("JavaFx Project: Authors");
				primaryStage.setScene(authorsView);
			}
		});
		btAuthors2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				/* Call method to create fade */
				FadeToPane(authorsPane);
				
				/* Set stage attributes */
				primaryStage.setTitle("JavaFx Project: Authors");
				primaryStage.setScene(authorsView);
			}
		});
		
		/* Create games button action */
		btGames0.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				/* Call method to create fade */
				FadeToPane(gamesPane);
				
				/* Set stage attributes */
				primaryStage.setTitle("JavaFx Project: Games");
				primaryStage.setScene(gamesView);
			}
		});
		btGames1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				/* Call method to create fade */
				FadeToPane(gamesPane);
				
				/* Set stage attributes */
				primaryStage.setTitle("JavaFx Project: Games");
				primaryStage.setScene(gamesView);
			}
		});
		btGames2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				/* Call method to create fade */
				FadeToPane(gamesPane);
				
				/* Set stage attributes */
				primaryStage.setTitle("JavaFx Project: Games");
				primaryStage.setScene(gamesView);
			}
		});
	}
	
	
	/* WelcomeMessage method
	 * Description: Creates the welcome message animation
	 */
	public void WelcomeMessage(Pane welcomePane, String welcomeMsg, Text welcomeDisplay, String courseMsg, Text courseDisplay) {
		/* Set welcome message font */
		welcomeDisplay.setFont(Font.loadFont(JavaFxProject.class.getResource("/Fonts/arumsansextrabold.ttf").toExternalForm(), 40));
		welcomeDisplay.setFill(Color.ORANGERED);
		
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
				/* Set course information font */
				courseDisplay.setFont(Font.loadFont(JavaFxProject.class.getResource("/Fonts/arumsansextrabold.ttf").toExternalForm(), 20));
				courseDisplay.setFill(Color.ORANGERED);
				
				/* Display course information */
				courseDisplay.setText(courseMsg);
			}
		});
		
		/* Display animation */
		writeMsg.play();
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
	
	
	/* NewActiveButton method
	 * Description: Creates a button for the active pane
	 */
	public Button NewActiveButton(String active, int X, int Y) {
		/* Create button image */
		Image activeButton = new Image(getClass().getResourceAsStream("/Buttons/" + active));
		
		/* Set button properties */
		Button btNew = new Button();
		btNew.setStyle("-fx-border-width: 0; -fx-background-color: transparent;");
		btNew.setGraphic(new ImageView(activeButton));
		btNew.setPrefSize(activeButton.getWidth(), activeButton.getHeight());
		btNew.setLayoutX(X);
		btNew.setLayoutY(Y);
		
		/* Return button */
		return btNew;
	}
	
	
	/* FadeToPane method
	 * Description: Creates a fade transition when loading a new pane
	 */
	public void FadeToPane(Pane pane) {
		/* Create transition */
		FadeTransition paneFade = new FadeTransition(Duration.millis(1000), pane);
		paneFade.setFromValue(0);
		paneFade.setToValue(1);
		paneFade.setCycleCount(1);
		paneFade.setAutoReverse(false);
		paneFade.play();
	}
}