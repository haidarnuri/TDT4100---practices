public class DiceScore{
	
	private int score;
    private Dice scoringDice;

    public DiceScore(final int score, final Dice scoringDice) {
        this.score = score;
        this.scoringDice = scoringDice;
    }
	
	public int getScore(){
		return this.score;
	}
	
	
}