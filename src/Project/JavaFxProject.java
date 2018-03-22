/*
* Course: CS 1302
* Section: 09
* Professor: Carlos A. Cepeda
* Name: Austin Atteberry
* Assignment #: JavaFx Project
*/

package Project;

import java.io.File;
import javafx.application.Application;
import MemoryMatchObject.MemoryMatch;
import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.ScrollPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.control.Button;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;
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
		String authorHeader = "About Me";
		String authorContent = "Austin Atteberry is a senior majoring\nin Electrical Engineering Technology at\nKennesaw State University. "
				+ "He enjoys\ncomputer and electronic projects,\nhobbyist level software defined radio,\nand spending time with his amazing\n"
				+ "wife Emilee. He's also a fan of football\nand IndyCar.\n\nAustin is originally from Indianapolis,\nbut now lives in the "
				+ "Atlanta area with\nhis wife and their cat. The couple's\nfirst child is due in May.";
		String gamesHeader = "Memory Match Game";
		String gamesContent = "Please read these instructions carefully as this is one of the more\ncomplicated games you'll ever play. When the "
				+ "game begins, you have a\nfew seconds to look at the cards. Once the cards turn over, click on the\nback of the card to turn it "
				+ "over. Try to click on two cards in a row with\nthe same color match. You lose if you pick two different colors. There is\nno "
				+ "scoing in this game—anything less than a perfect score is a loss.";
		Text welcomeDisplay = new Text(20, 45, "");
		Text courseDisplay = new Text(20, 160, "");
		Text homeDisplay1 = new Text(20, 45, welcomeMsg);
		Text homeDisplay2 = new Text(20, 160, courseMsg);
		Text authorText1 = new Text(20, 45, authorHeader);
		Text authorText2 = new Text(300, 94, authorContent);
		Text gamesText1 = new Text(20, 45, gamesHeader);
		Text gamesText2 = new Text(20, 80, gamesContent);
		//File videoFile = new File("./About.mp4");
		
		String[] location = new String[12];

		for(int i = 0; i < location.length; i++) {
			Integer fghjk = i;
			if(i < 10) {
				location[i] = "/Pictures/Match0" + fghjk.toString() + ".jpg";
			}
	        else {
	            location[i] = "/Pictures/Match" + fghjk.toString() + ".jpg";
	        }
		}
		
		/* Use MemoryMatch class to create game board */
		MemoryMatch memMatch = new MemoryMatch(4, 6, location);
		int[][] memoryMatch = memMatch.getCardPosition();
		String[][] imageString = memMatch.getCardImages();
		
		/* Create a GridPane and set its properties */
		GridPane memoryMatchPane = new GridPane();
		memoryMatchPane.setAlignment(Pos.CENTER);
		memoryMatchPane.setPadding(new Insets(10, 10, 10, 10));
		memoryMatchPane.setVgap(10);
		memoryMatchPane.setHgap(10);
		
		/* Set text attributes */
		homeDisplay1.setFont(Font.loadFont(JavaFxProject.class.getResource("/Fonts/arumsansextrabold.ttf").toExternalForm(), 40));
		homeDisplay1.setFill(Color.WHITE);
		homeDisplay2.setFont(Font.loadFont(JavaFxProject.class.getResource("/Fonts/arumsansextrabold.ttf").toExternalForm(), 20));
		homeDisplay2.setFill(Color.WHITE);
		authorText1.setFont(Font.loadFont(JavaFxProject.class.getResource("/Fonts/arumsansextrabold.ttf").toExternalForm(), 40));
		authorText1.setFill(Color.FIREBRICK);
		authorText2.setFont(Font.loadFont(JavaFxProject.class.getResource("/Fonts/arumsansextrabold.ttf").toExternalForm(), 20));
		authorText2.setFill(Color.FIREBRICK);
		gamesText1.setFont(Font.loadFont(JavaFxProject.class.getResource("/Fonts/arumsansextrabold.ttf").toExternalForm(), 40));
		gamesText1.setFill(Color.LIGHTCORAL);
		gamesText2.setFont(Font.loadFont(JavaFxProject.class.getResource("/Fonts/arumsansextrabold.ttf").toExternalForm(), 20));
		gamesText2.setFill(Color.LIGHTCORAL);
		
		/* Create sphere animations */
		Sphere displaySphere0 = CreateSphere(100, 100, 360, Color.LAWNGREEN, Color.BLUE);
		AnimateSphere(displaySphere0);
		Sphere displaySphere1 = CreateSphere(100, 100, 360, Color.DARKGREY, Color.AZURE);
		AnimateSphere(displaySphere1);
		
		/* Create Image objects */
		Image austin = new Image("/Pictures/Selfie.jpg");
		Image screenShot1 = new Image("/Pictures/MemoryMatch1.jpg");
		Image screenShot2 = new Image("/Pictures/MemoryMatch2.jpg");
		Image[][] cardImages = new Image[4][6];
		Image[][] cardBackImages = new Image[4][6];
		
		/* Assign image locations */
		cardBackImages[0][0] = new Image("/Pictures/CardBack00.jpg");
		cardBackImages[0][1] = new Image("/Pictures/CardBack01.jpg");
		cardBackImages[0][2] = new Image("/Pictures/CardBack02.jpg");
		cardBackImages[0][3] = new Image("/Pictures/CardBack03.jpg");
		cardBackImages[0][4] = new Image("/Pictures/CardBack04.jpg");
		cardBackImages[0][5] = new Image("/Pictures/CardBack05.jpg");
		cardBackImages[1][0] = new Image("/Pictures/CardBack06.jpg");
		cardBackImages[1][1] = new Image("/Pictures/CardBack07.jpg");
		cardBackImages[1][2] = new Image("/Pictures/CardBack08.jpg");
		cardBackImages[1][3] = new Image("/Pictures/CardBack09.jpg");
		cardBackImages[1][4] = new Image("/Pictures/CardBack10.jpg");
		cardBackImages[1][5] = new Image("/Pictures/CardBack11.jpg");
		cardBackImages[2][0] = new Image("/Pictures/CardBack00.jpg");
		cardBackImages[2][1] = new Image("/Pictures/CardBack01.jpg");
		cardBackImages[2][2] = new Image("/Pictures/CardBack02.jpg");
		cardBackImages[2][3] = new Image("/Pictures/CardBack03.jpg");
		cardBackImages[2][4] = new Image("/Pictures/CardBack04.jpg");
		cardBackImages[2][5] = new Image("/Pictures/CardBack05.jpg");
		cardBackImages[3][0] = new Image("/Pictures/CardBack06.jpg");
		cardBackImages[3][1] = new Image("/Pictures/CardBack07.jpg");
		cardBackImages[3][2] = new Image("/Pictures/CardBack08.jpg");
		cardBackImages[3][3] = new Image("/Pictures/CardBack09.jpg");
		cardBackImages[3][4] = new Image("/Pictures/CardBack10.jpg");
		cardBackImages[3][5] = new Image("/Pictures/CardBack11.jpg");

		/* Create ImageView objects */
		ImageView author = new ImageView(austin);
		ImageView ssMemMatch1 = new ImageView(screenShot1);
		ImageView ssMemMatch2 = new ImageView(screenShot2);
		ImageView[][] cardImageView = new ImageView[4][6];
		ImageView[][] cardBackImageView = new ImageView[4][6];
		
		/* Create RotateTransition objects */
		RotateTransition[][] preRotatedCard = new RotateTransition[4][6];
		RotateTransition[][] rotateCard = new RotateTransition[4][6];
		RotateTransition[][] rotateCardReverse = new RotateTransition[4][6];
		RotateTransition[][] flipCardToFront1 = new RotateTransition[4][6];
		RotateTransition[][] flipCardToFront2 = new RotateTransition[4][6];
		//RotateTransition[][] flipCardToBack1 = new RotateTransition[4][6];
		//RotateTransition[][] flipCardToBack2 = new RotateTransition[4][6];

		/* Set image attributes */
		author.setFitHeight(austin.getHeight() * 0.45);
		author.setPreserveRatio(true);
		author.setLayoutX(20);
		author.setLayoutY(80);
		ssMemMatch1.setFitHeight(screenShot1.getHeight() * 0.4);
		ssMemMatch1.setPreserveRatio(true);
		ssMemMatch1.setLayoutX(80);
		ssMemMatch1.setLayoutY(210);
		ssMemMatch2.setFitHeight(screenShot2.getHeight() * 0.4);
		ssMemMatch2.setPreserveRatio(true);
		ssMemMatch2.setLayoutX(345);
		ssMemMatch2.setLayoutY(210);
		
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
		Button btVideo = new Button("Watch Video");
		Button btLaunchGame = new Button("Play Game");
		
		/* Set button attributes */
		btVideo.setStyle("-fx-background-color: linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\r\n"
				+ "linear-gradient(#020b02, #3a3a3a),\r\n"
				+ "linear-gradient(#9d9e9d 0%, #6b6a6b 20%, #343534 80%, #242424 100%),\r\n"
				+ "linear-gradient(#8a8a8a 0%, #6b6a6b 20%, #343534 80%, #262626 100%),\r\n"
				+ "linear-gradient(#777777 0%, #606060 50%, #505250 51%, #2a2b2a 100%);"
				+ "-fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);"
				+ "-fx-text-fill: white; -fx-font-size: 15px;");
		btVideo.setPrefSize(120, 30);
		btVideo.setLayoutX(390);
		btVideo.setLayoutY(370);
		btLaunchGame.setStyle("-fx-background-color: linear-gradient(#f2f2f2, #d6d6d6), linear-gradient(#fcfcfc 0%, #d9d9d9 20%, #d6d6d6 100%),"
				+"linear-gradient(#dddddd 0%, #f6f6f6 50%); -fx-background-radius: 8,7,6; -fx-background-insets: 0,1,2; -fx-text-fill: black;"
				+ "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
		btLaunchGame.setPrefSize(120, 30);
		btLaunchGame.setLayoutX(255);
		btLaunchGame.setLayoutY(440);
		
		/* Create panes */
		Pane welcomePane = new Pane();
		Pane homePane = new Pane();
		Pane authorsPane = new Pane();
		Pane gamesPane = new Pane();
		
		/* Create StackPane */
		StackPane[][] rotationPane = new StackPane[4][6];
		
		/* Set stage attributes */
		primaryStage.setHeight(650);
		primaryStage.setWidth(650);
		primaryStage.setResizable(false);
		primaryStage.getIcons().add(new Image("/icon/icon.gif"));
		
		/* Add nodes to panes */
		welcomePane.getChildren().addAll(welcomeDisplay, courseDisplay, displaySphere0, btHome0, btAuthors0, btGames0);
		homePane.getChildren().addAll(homeDisplay1, homeDisplay2, displaySphere1, btHomeActive, btAuthors1, btGames1);
		authorsPane.getChildren().addAll(authorText1, authorText2, author, btVideo, btHome1, btAuthorsActive, btGames2);
		gamesPane.getChildren().addAll(gamesText1, gamesText2, ssMemMatch1, ssMemMatch2, btLaunchGame, btHome2, btAuthors2, btGamesActive);
		
		/* Set background colors */
		welcomePane.setStyle("-fx-background-color: #f85113;");
		homePane.setStyle("-fx-background-color: #f85113;");
		authorsPane.setStyle("-fx-background-color: #ffd700;");
		gamesPane.setStyle("-fx-background-color: #006400;");
		
		/* Create scenes */
		Scene welcomeView = new Scene(welcomePane);
		Scene homeView = new Scene(homePane);
		Scene authorsView = new Scene(authorsPane);
		Scene gamesView = new Scene(gamesPane);
		
		/* Set welcome screen stage */
		primaryStage.setTitle("JavaFx Project: Welcome");
		primaryStage.setScene(welcomeView);
		primaryStage.show();
		
		/* Display welcome message */
		WelcomeMessage(welcomePane, welcomeMsg, welcomeDisplay, courseMsg, courseDisplay);
		
		/* Create ScrollPane for game */
		ScrollPane memoryMatchScroll = new ScrollPane();
		memoryMatchScroll.setContent(memoryMatchPane);
		
		/* Create a Group for video */
		Group videoGroup = new Group();
		
		/* Create a game stage */
		Stage gameStage = new Stage();
		
		/* Create a video stage */
		Stage videoStage = new Stage();
		
		/* Create a new Scene and place it on the game stage */
		Scene memMatchScene = new Scene(memoryMatchScroll);
		gameStage.setTitle("Memory Match");
		gameStage.getIcons().add(new Image("/icon/matchbook.gif"));
		gameStage.setScene(memMatchScene);
		
		
		
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
		btVideo.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				try {
					/* Create a new Scene and place it on the video stage */
					Scene aboutScene = new Scene(videoGroup, 1280, 720);
					videoStage.setTitle("About Me");
					videoStage.setScene(aboutScene);
					
					/* Set up MediaPlayer */
					Media authorsVideo = new Media(new File("bin/Video/About.mp4").toURI().toString());
					MediaPlayer player = new MediaPlayer(authorsVideo);
					player.setAutoPlay(true);
					
					/* Set up MediaView */
					MediaView videoView = new MediaView(player);
					((Group)aboutScene.getRoot()).getChildren().add(videoView);
					
					/* Open the video stage */
					videoStage.show();
				}
				catch(java.lang.IllegalArgumentException ex) {}
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
		btLaunchGame.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				/* Reset animation */
				Reset(imageString, cardImages, cardBackImages, cardImageView, cardBackImageView, rotationPane,
						preRotatedCard, rotateCard, rotateCardReverse, memoryMatchPane, memoryMatch);
				
				/* Open the game stage */
				gameStage.show();
				
				/* Animate cards */
				StartRotation(preRotatedCard);
				CreateGameplayAnimation(flipCardToFront1, flipCardToFront2, cardBackImageView,  cardImageView);
				EnableFlip(flipCardToFront1, cardBackImageView);
				
				/*for(int i = 0; i < cardBackImageView.length; i++) {
					for(int j = 0; j < cardBackImageView[i].length; j++) {
						SetMouseClickedEvent(cardBackImageView[i][j], cardBackImageView, memoryMatch);
					}
				}*/
			}
		});
	}
	
	
	/* WelcomeMessage method
	 * Description: Creates the welcome message animation
	 */
	public void WelcomeMessage(Pane welcomePane, String welcomeMsg, Text welcomeDisplay, String courseMsg, Text courseDisplay) {
		/* Set welcome message font */
		welcomeDisplay.setFont(Font.loadFont(JavaFxProject.class.getResource("/Fonts/arumsansextrabold.ttf").toExternalForm(), 40));
		welcomeDisplay.setFill(Color.WHITE);
		
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
				courseDisplay.setFill(Color.WHITE);
				
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
	
	
	/* CreateSphere method
	 * Description: Creates a sphere with the given coordinates
	 */
	public Sphere CreateSphere(double radius, double X, double Y, Color dColor, Color sColor) {
		/* Create sphere with the given coordinates */
		Sphere sphere = new Sphere(radius);
		sphere.setTranslateX(X);
		sphere.setTranslateY(Y);
		
		/* Color the sphere */
		PhongMaterial sphereColor = new PhongMaterial();
		sphereColor.setDiffuseColor(dColor);
		sphereColor.setSpecularColor(sColor);
		sphere.setMaterial(sphereColor);
		
		/* Return sphere */
		return sphere;
	}
	
	
	/* AnimateSphere method
	 * Description: Animates the sphere
	 */
	public void AnimateSphere(Sphere sphere) {
		/* Create timeline and set attributes */
		Timeline moveBall = new Timeline();
		moveBall.setCycleCount(Timeline.INDEFINITE);
		moveBall.setAutoReverse(true);
		
		/* Add keyframes */
		moveBall.getKeyFrames().addAll(
				new KeyFrame(Duration.millis(2000),
						new KeyValue(sphere.translateXProperty(), 535), new KeyValue(sphere.translateYProperty(), 360))
				);
		
		/* Play animation */
		moveBall.play();
	}
	
	
	/* Reset method
	 * Description: Resets or initializes the game
	 */
	private void Reset(String[][] imageString, Image[][] cardImages, Image[][] cardBackImages, ImageView[][] cardImageView,
			ImageView[][] cardBackImageView, StackPane[][] rotationPane, RotateTransition[][] preRotatedCard,
			RotateTransition[][] rotateCard, RotateTransition[][] rotateCardReverse, GridPane memoryMatchPane, int[][] memoryMatch) {
		
		/* Set card images */
		for(int i = 0; i < cardImages.length; i++) {
			for(int j = 0; j < cardImages[i].length; j++) {
				cardImages[i][j] = new Image(imageString[i][j]);
			}
		}
		
		/* Create ImageView objects from images and place in StackPane */
		for(int i = 0; i < cardImages.length; i++) {
			for(int j = 0; j < cardImages[i].length; j++) {
				cardImageView[i][j] = new ImageView(cardImages[i][j]);
				cardImageView[i][j].setFitHeight(cardImages[i][j].getHeight() * 0.5);
				cardImageView[i][j].setPreserveRatio(true);
				cardBackImageView[i][j] = new ImageView(cardBackImages[i][j]);
				cardBackImageView[i][j].setFitHeight(cardBackImages[i][j].getHeight() * 0.5);
				cardBackImageView[i][j].setPreserveRatio(true);
				cardBackImageView[i][j].setId(String.valueOf(memoryMatch[i][j]));
				rotationPane[i][j] = new StackPane();
				rotationPane[i][j].getChildren().addAll(cardBackImageView[i][j], cardImageView[i][j]);
			}
		}
		
		/* Create rotation and set attributes */
		for(int i = 0; i < cardImages.length; i++) {
			for(int j = 0; j < cardImages[i].length; j++) {
				preRotatedCard[i][j] = StartRotated(cardBackImageView[i][j], 3000);
				rotateCard[i][j] = RotateCardFtoS(cardImageView[i][j], 500);
				rotateCardReverse[i][j] = RotateCardStoB(cardBackImageView[i][j], 500);
				
				RotateTransition rotateCardmemoryMatch = rotateCard[i][j];
				RotateTransition rotateCardTemp2 = rotateCardReverse[i][j];
				
				preRotatedCard[i][j].setOnFinished(e -> rotateCardmemoryMatch.play());
				rotateCard[i][j].setOnFinished(e -> rotateCardTemp2.play());
			}
		}
		
		/* Add StackPanes to GridPane */
		for(int i = 0; i < cardImages.length; i++) {
			for(int j = 0; j < cardImages[i].length; j++) {
				memoryMatchPane.add(rotationPane[i][j], j, i);
			}
		}
	}
	
	
	/* RotateCardFtoS method
	 * Description: Returns a RotateTransition object to handle the first part of the animation
	 */
	private RotateTransition RotateCardFtoS(ImageView cardImageView, double time) {
		/* Create a RotateTransition */
		RotateTransition rotateCard = new RotateTransition(Duration.millis(time), cardImageView);
		
		/* Create the rotation from front to side */
		rotateCard.setFromAngle(0);
		rotateCard.setToAngle(90);
		rotateCard.setCycleCount(1);
		rotateCard.setInterpolator(Interpolator.LINEAR);
		rotateCard.setAxis(Rotate.Y_AXIS);
		rotateCard.setAutoReverse(false);
		
		/* Return RotateTransition */
		return rotateCard;
	}
	
	
	/* RotateCardStoB method
	 * Description: Returns a RotateTransition object to handle the second part of the animation
	 */
	private RotateTransition RotateCardStoB(ImageView cardBackImageView, double time) {
		/* Create a RotateTransition */
		RotateTransition rotateCard = new RotateTransition(Duration.millis(time), cardBackImageView);
		
		/* Create the rotation from side to back */
		rotateCard.setFromAngle(90);
		rotateCard.setToAngle(0);
		rotateCard.setCycleCount(1);
		rotateCard.setInterpolator(Interpolator.LINEAR);
		rotateCard.setAxis(Rotate.Y_AXIS);
		rotateCard.setAutoReverse(false);
		
		/* Return RotateTransition */
		return rotateCard;
	}
	
	
	/* StartRotated method
	 * Description: Returns a RotateTransition object that turns and stops at 90 degrees
	 */
	private RotateTransition StartRotated(ImageView cardBackImageView, double time) {
		/* Create a RotateTransition */
		RotateTransition rotateCard = new RotateTransition(Duration.millis(time), cardBackImageView);
		
		/* Rotate to 90 degrees */
		rotateCard.setFromAngle(0);
		rotateCard.setToAngle(90);
		rotateCard.setCycleCount(1);
		rotateCard.setInterpolator(Interpolator.LINEAR);
		rotateCard.setAxis(Rotate.Y_AXIS);
		rotateCard.setAutoReverse(false);
		
		/* Return RotateTransition */
		return rotateCard;
	}
	
	
	/* CreateGameplayAnimation method
	 * Description: Creates the dual-image card flip
	 */
	private void CreateGameplayAnimation(RotateTransition[][] flipCardToFront1, RotateTransition[][] flipCardToFront2,
			ImageView[][] cardBackImageView, ImageView[][] cardImageView) {
		
		/* Turn card around when clicked */
		for(int i = 0; i < flipCardToFront1.length; i++) {
			for(int j = 0; j < flipCardToFront1[i].length; j++) {
				
				flipCardToFront1[i][j] = RotateCardFtoS(cardBackImageView[i][j], 100);
				flipCardToFront2[i][j] = RotateCardStoB(cardImageView[i][j], 100);
				
				RotateTransition flipCardToFrontTemp = flipCardToFront2[i][j];
				
				flipCardToFront1[i][j].setOnFinished(e -> flipCardToFrontTemp.play());
			}
		}
	}
	
	
	/* EnableFlip method
	 * Description: Enables the card flip animation
	 */
	private void EnableFlip(RotateTransition[][] flipCardToFront, ImageView[][] cardBackImageView) {
		/*  */
		for(int i = 0; i < cardBackImageView.length; i++) {
			for(int j = 0; j < cardBackImageView[i].length; j++) {
				RotateTransition flipCardToFrontTemp = flipCardToFront[i][j];
				cardBackImageView[i][j].setOnMouseClicked(e -> {
					flipCardToFrontTemp.play();
				});
			}
		}
	}
	
	
	/* DisableFlip method
	 * Description: Disables the card flip action
	 */
	/*private void DisableFlip(ImageView[][] cardBackImageView) {
		for(int i = 0; i < cardBackImageView.length; i++) {
			for(int j = 0; j < cardBackImageView.length; j++) {
				cardBackImageView[i][j].setOnMouseClicked(null);
			}
		}
	}*/
	
	
	/* SetMouseClickedEvent method
	 * Description: Creates an event when one of the cards is clicked
	 */
	/*private void SetMouseClickedEvent(ImageView cardBackImageView, ImageView[][] cardBackImageViewArray, int[][] memoryMatch) {
		cardBackImageView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
			
				}
					
		});
	}*/
	
	
	/* StartRotation method
	 * Description: Starts the card rotation
	 */
	private void StartRotation(RotateTransition[][] rotateCard) {
		int i, j;
		
		/* Rotate all of cards */
		for(i = 0; i < rotateCard.length; i++) {
			for(j = 0; j < rotateCard[i].length; j++) {
				rotateCard[i][j].play();
			}
		}
	}
}