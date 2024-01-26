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
        int pinCount = 0;
        for (int i = 0; i < frame.length; i++) {
            if (Character.isDigit(scoreCard.charAt(pinCount)) && Character.isDigit(scoreCard.charAt(pinCount + 1))) {
                int pin1 = Character.getNumericValue(scoreCard.charAt(pinCount));
                int pin2 = Character.getNumericValue(scoreCard.charAt(pinCount + 1));
                frame[i] = new Frame(pin1, pin2);
                pinCount += 2;
            }
            if (!Character.isDigit(scoreCard.charAt(pinCount)) || !Character.isDigit(scoreCard.charAt(pinCount + 1))) {
                if (!Character.isDigit(scoreCard.charAt(pinCount)) && scoreCard.charAt(pinCount) == 'X'){
                    
                }

            }
        }
        return frame;
    }
}
