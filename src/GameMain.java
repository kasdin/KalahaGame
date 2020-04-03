import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.LinkedList;

/***
 * This is a Kalaha game for 2 players.
 */

public class GameMain extends Application {

    private Pane pane = new Pane();
    private Scene scene;
    private GameBoard gameBoard = new GameBoard(pane);
    //private LinkedList list;
    private int player = 1;
    private int value;
    private int houseIDS;
    private int houseID;
    private Pane paneStart;
    private TextField player1, player2;
    private Button btnStartGame;
    private ImageView bgkTable;
    private Label labelHeadline;
    private int endHouse;
    private Label labelTurn;

    private int numberOfMoves = 0;


    @Override
    public void start(Stage primaryStage) throws Exception {
        scene = new Scene(pane, 1250, 1000);


        paneStart = new Pane();
        labelHeadline = new Label("KALAHA GAME");
        labelHeadline.setStyle("-fx-font-size: 40");
        labelHeadline.setLayoutX(500);
        labelHeadline.setLayoutY(200);
        player1 = new TextField("Write player 1 name");
        player1.setLayoutY(300);
        player1.setLayoutX(500);
        player1.setStyle("-fx-font-size: 20");

        player2 = new TextField("Write player 2 name");
        player2.setLayoutY(350);
        player2.setLayoutX(500);
        player2.setStyle("-fx-font-size: 20");

        btnStartGame = new Button("Start Game");
        btnStartGame.setLayoutX(550);
        btnStartGame.setLayoutY(400);
        btnStartGame.setStyle("-fx-font-size: 20");
        btnStartGame.setOnAction(event -> startGame());

        Image table = new Image("file:src/table.jpg");
        bgkTable = new ImageView(table);
        bgkTable.setPreserveRatio(true);
        bgkTable.setFitHeight(1000);


        paneStart.getChildren().addAll(bgkTable, labelHeadline, player1, player2, btnStartGame);
        pane.getChildren().add(paneStart);


        primaryStage.setTitle("Kalaha Game");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void startGame() {

        pane.getChildren().clear();

        Image wood = new Image("file:src/wood-texture.jpg");
        ImageView woodBoard = new ImageView(wood);
        woodBoard.setFitWidth(1250);
        woodBoard.setFitHeight(400);
        woodBoard.setLayoutY(250);

        labelTurn = new Label(player1.getText() + " It is your turn");
        labelTurn.setLayoutY(100);
        labelTurn.setLayoutX(400);
        labelTurn.setStyle("-fx-font-size: 40");



        pane.getChildren().addAll(bgkTable, woodBoard, labelTurn);
        gameBoard.placeAll();
        step1();

    }


    public void step3(int houseID) {
        this.houseID = houseID;
        houseIDS = houseID + 1;

        House test = GameBoard.list.get(houseID);
        value = test.getValue();

        if (value > 0) {
            for (int i = value; i > 0; i--) {
                //House test2 = GameBoard.list.get(houseIDS);
                if (houseIDS == 14) {
                    houseIDS = 0;

                } else {
                    House test2 = GameBoard.list.get(houseIDS);
                    test2.setValue(test2.getValue() + 1);
                    test2.requestFocus();
                    houseIDS++;
                    test.setValue(test.getValue() - 1);
                    System.out.println(houseIDS);
                    endHouse = houseID;
                    System.out.println("Endhouse" + houseIDS);
                }
            }
            GameBoard.list.get(houseIDS).activateButton();
            numberOfMoves++;
            checkNumberOfMoves(value);
            shiftTurn();

        }
    }

    private void step1() {
        if (player == 1 && numberOfMoves == 0) {
            for (int i = 0; i < 6; i++) {
                GameBoard.list.get(i).activateButton();
            }
        } else if (player == 2 && numberOfMoves == 0){
            for (int i = 8; i < 14; i++) {
                GameBoard.list.get(i).activateButton();

            }
        }
    }


    public void checkNumberOfMoves(int value){
        if (numberOfMoves > 0 && value > 0) {
            for (int i = 0; i < 14; i++) {
                GameBoard.list.get(i).disableButton();
            }
            GameBoard.list.get(houseIDS).activateButton();
        }
    }

    public void shiftTurn() {
        if (player == 1 && endHouse > 7) {
            player = 2;
            labelTurn.setText(player2.getText() + " it is your turn!");
            step3(houseIDS);

        } else if(player == 2 && endHouse < 8){
            player = 1;
            labelTurn.setText(player1.getText() + " It is your turn");
            step3(houseIDS);

        }


    }





}
