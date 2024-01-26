package edu.gorilas;

import java.util.List;

public class ScoreCard {
    private List<Frame> frames;
    private String scoreCard = "";

    public ScoreCard() {
        this.scoreCard = "";
    }

    public ScoreCard(String scoreCard) {
        this.scoreCard = scoreCard;
    }

    public int calculateScore(String scoreCard) {
        Frame[] frame = separeNumbers(scoreCard);
        return frame[0].getScore();
    }
    
    private Frame[] separeNumbers(String scoreCard) {
        Frame[] frame = new Frame[10];
        int j = 0;
        for (int i = 0; i < scoreCard.length(); i += 2) {
            frame[j] = new Frame(Character.getNumericValue(scoreCard.charAt(i)), Character.getNumericValue(scoreCard.charAt(i+1)));
            j++;
        }
        return frame;
    }
}
