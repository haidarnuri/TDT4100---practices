package TicTacToe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController extends ButtonAction{
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

    @FXML private Label numberOfRounds;
   // @FXML private Label showName;


    @FXML private Button[] buttonList = new Button[9];

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

    public void addSignToButton(){
        for(int i = 0; i<buttonList.length;i++) {
            int finalI = i;
            buttonList[i].setOnMouseClicked(e -> {
                buttonList[finalI].setText(changeButtonText(buttonList[finalI], counter));
                this.counter +=1;
                showCounter();
                if(checkIfWin()){
                    for(int j = 0; j<buttonList.length;j++) {
                        buttonList[j].setOnMouseClicked(null);
                    }
                    this.numberOfRounds.setText(buttonList[finalI].getText() + " won on " + this.counter + " rounds!");

                }
            });


        }
    }

    public void newGame(ActionEvent event) throws IOException {
        openNewScreen();
    }

    public void exitGame(ActionEvent event) throws IOException {
        exitScreen();
    }




    private boolean checkIfWin(){
        //counting all the rows
        for(int i = 0; i<8;i = i + 3) {
            if(buttonList[i].getText().equals(buttonList[i+1].getText()) && buttonList[i].getText().equals(buttonList[i+2].getText()) && !buttonList[i].getText().isEmpty()){
                return true;
            }
        }
        //Counting columns
        for(int i = 0; i<3;i++) {
            if(buttonList[i].getText().equals(buttonList[i+3].getText()) && buttonList[i].getText().equals(buttonList[i+6].getText()) && !buttonList[i].getText().isEmpty()){
                return true;

            }

        }
        //checking one diagonal
        if(buttonList[0].getText().equals(buttonList[4].getText()) && buttonList[0].getText().equals(buttonList[8].getText()) && !buttonList[0].getText().isEmpty()){
            return true;

        }
        else if(buttonList[2].getText().equals(buttonList[4].getText()) && buttonList[2].getText().equals(buttonList[6].getText()) && !buttonList[2].getText().isEmpty()){
            return true;

        }
        else{return false;}
    }

    private String changeButtonText(Button button, int counter){
        String setX = "X";
        String setO = "O";
        if(counter%2==0){
            button.setText(setX);
        }
        else{
            button.setText(setO);
        }
        return button.getText();
    }


    private void showCounter(){
        numberOfRounds.setText("Total number of clicks is " + this.counter);
    }

    private int counter = 0;


}







