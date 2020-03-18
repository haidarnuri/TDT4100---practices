package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class GameController{
    @FXML private Button[] buttonList = new Button[9];
    @FXML private Button A1;
    @FXML private Button A2;
    @FXML private Button A3;
    @FXML private Button B1;
    @FXML private Button B2;
    @FXML private Button B3;
    @FXML private Button C1;
    @FXML private Button C2;
    @FXML private Button C3;

    @FXML private Button exitGame;
    @FXML private Button newGame;

    @FXML private Label playerName;

    @FXML private Label numberOfRounds;

    //private int counter = 0;
    GameData gameData = new GameData();
    SaveAndLoadGame saveAndLoadGame = new SaveAndLoadGame();

    public GameController() {
    }

    @FXML
    public void initialize(){
        buttonList[0] = this.A1;
        buttonList[1] = this.A2;
        buttonList[2] = this.A3;
        buttonList[3] = this.B1;
        buttonList[4] = this.B2;
        buttonList[5] = this.B3;
        buttonList[6] = this.C1;
        buttonList[7] = this.C2;
        buttonList[8] = this.C3;
    }

    public void initData(String playername) {
        playerName.setText(playername);
    }

    public void addSignToButton(){
        for(int i = 0; i<gameData.getBoard().length;i++) {
            int finalI = i;
            buttonList[i].setOnMouseClicked(e -> {
                gameData.getBoard()[finalI] = changeButtonText(gameData.getBoard(),gameData.getCount(),finalI);
                updateUI();
                gameData.increaseCountByOne();
                showCounter();
                if(checkIfWin()){
                    for(int j = 0; j<buttonList.length;j++) {
                        buttonList[j].setOnMouseClicked(null);
                    }
                    this.numberOfRounds.setText(buttonList[finalI].getText() + " won on " + gameData.getCount() + " rounds!");
                }
            });
        }
    }

    private void updateUI() {
        for(int i = 0; i < 9; i++ ){
            String buttonState = gameData.getBoard()[i];
            if(buttonState==null ){
                continue;
            }
            else{
                buttonList[i].setText(buttonState);
            }
        }
    }

    public void saveGame(ActionEvent event){
        saveAndLoadGame.saveGame(gameData.getBoard());
    }
    public void loadGame(ActionEvent event){
        String[] tempLoadBoard = saveAndLoadGame.loadGame(gameData.getBoard());
        gameData.setBoard(tempLoadBoard);
        updateUI();
    }


    public void newGame(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        FXMLLoader root = FXMLLoader.load(getClass().getClassLoader().getResource("../../resources/GameWindow.fxml"));
        GameController controller = root.<GameController>getController();
        controller.initData(playerName.getText());
        primaryStage.setTitle("Game!");
        primaryStage.setScene(new Scene(root.load()));
        primaryStage.show();
    }

    public void exitGame(ActionEvent event) throws IOException {
        System.exit(0);
    }

    private boolean checkIfWin(){
        //counting all the rows
        for(int i = 0; i<8;i = i + 3) {
            if(buttonList[i].getText().equals(buttonList[i+1].getText()) && buttonList[i].getText().equals(buttonList[i+2].getText()) && !(buttonList[i].getText().isEmpty())){
                return true;
            }
        }
        //Counting columns
        for(int i = 0; i<3;i++) {
            if(buttonList[i].getText().equals(buttonList[i+3].getText()) && buttonList[i].getText().equals(buttonList[i+6].getText()) && !(buttonList[i].getText().isEmpty())){
                return true;
            }
        }

        //checking one diagonal
        if(buttonList[0].getText().equals(buttonList[4].getText()) && buttonList[0].getText().equals(buttonList[8].getText()) && !(buttonList[0].getText().isEmpty())){
            return true;
        }
        if(buttonList[2].getText().equals(buttonList[4].getText()) && buttonList[2].getText().equals(buttonList[6].getText()) && !(buttonList[2].getText().isEmpty())){
            return true;
        }
        else{return false;}
    }

    private String changeButtonText(String[] board, int counter, int positionInBoard){
        String setX = "X";
        String setO = "O";
        if(counter%2==0){
            board[positionInBoard] = setX;
        }
        else{
            board[positionInBoard]=setO;
        }
        return board[positionInBoard];
    }


    private void showCounter(){
        numberOfRounds.setText("Total number of clicks is " + gameData.getCount());
    }

}







