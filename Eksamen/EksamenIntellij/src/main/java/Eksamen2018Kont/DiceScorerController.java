/*
package Eksamen2018Kont;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Collection;

public class DiceScorerController {
    private DiceScorer singleValue, straight, nothing;

    @FXML
    public void initialize() {
        singleValue = new SingleValue();
        straight = new Straight();
        nothing = new Nothing();
    }

    @FXML private TextField dieValuesInput;
    @FXML
    private Label scoreOutput;
    @FXML private Label diceOutput;

    // helper method for parsing die values input
    private Dice getDiceInput() {
        Collection<Integer> dieValues = new ArrayList<>();
        for (String dieValue : dieValuesInput.getText().split(" ")) {
            ??? parse and add die value
        }
        ??? return new Dice instances
    }

    // helper method for
    private void runDiceScorer(DiceScorer scorer) {
        ??? get Eksamen2018Kont.DiceScore object by calling scorer's getScore method
        if (score != null) {
            ??? show output
        } else {
            ??? show output
        }
    }

    @FXML
    public void testSingleValue() {
        ??? use SingleValue implementation
    }

    @FXML
    public void testStraight() {
        ??? use Straight implementation
    }

    @FXML
    public void testNothing() {
        ??? use Nothing implementation
    }
}*/