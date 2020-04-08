
package Eksamen2018Kont;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.ResourceBundle;

public class DiceScorerController implements Initializable {
    private DiceScorer singleValue, straight, nothing;
    private DiceScore diceScore = null;
    private Collection<DiceScorer> diceScorers = new ArrayList<>();

    @FXML private TextField dieValuesInput;
    @FXML private Label scoreOutput;
    @FXML private Label diceOutput;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
         Collections.addAll(diceScorers,singleValue,straight);
    }

    // helper method for parsing die values input
    private Dice getDiceInput() {
        Collection<Integer> dieValues = new ArrayList<>();
        for (String dieValue : dieValuesInput.getText().split(" ")) {
           dieValues.add(Integer.valueOf(dieValue));
        }
        if(dieValuesInput.getText().trim().length()==0){
            return null;
        }else {
            return new Dice(dieValues);
        }
    }

    // helper method for
    private void runDiceScorer(DiceScorer scorer) {
        DiceScore score = scorer.getScore(getDiceInput());
        if (score != null) {
            scoreOutput.setText("Your score is 0");
        } else {
            scoreOutput.setText("Your score is " + score.getScore());
        }
    }

    @FXML
    public void testSingleValue() {
            int randomValue = 5;
            int randomScore = 10;
            singleValue = new SingleValue(randomValue, randomScore);
            this.diceScore = singleValue.getScore(getDiceInput());

    }

    @FXML
    public void testStraight() {
        int randomScore = 10;
        straight = new Straight(randomScore);
        this.diceScore = straight.getScore(getDiceInput());
    }

    @FXML
    public void testNothing() {
            int randomScore = 10;
        nothing = new Nothing(1,randomScore,diceScorers);
        this.diceScore = nothing.getScore(getDiceInput());
    }
    private DiceScore getDiceScore(){
        return this.diceScore;
    }

}