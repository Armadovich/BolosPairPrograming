package edu.gorilas;

import java.util.Arrays;

public class ScoreCard {
    private String scoreCard = "";

    private final char STRIKE_VAL = 'X';
    private final char SPARE_VAL = '/';
    private final char ZERO_VAL = '-';

    public ScoreCard() {
        this.scoreCard = "";
    }

    public ScoreCard(String scoreCard) {
        this.scoreCard = scoreCard;
    }

    public int calculateScore(String scoreCard) {
        Frame[] frame = calculateFrame(scoreCard);
        int score = Arrays.stream(frame).mapToInt(Frame::getScore).sum();
        return score;
    }

    private Frame[] calculateFrame(String scoreCard) {
        Frame[] frame = new Frame[10];
        int pinCount = 0;
        boolean isStrike = false;
        boolean isSpare = false;

        for (int i = 0; i < frame.length; i++) {
            if ((Character.isDigit(scoreCard.charAt(pinCount)) || scoreCard.charAt(pinCount) == ZERO_VAL) && (Character.isDigit(scoreCard.charAt(pinCount + 1)) || scoreCard.charAt(pinCount + 1) == ZERO_VAL)) {
                char pin1 = scoreCard.charAt(pinCount);
                char pin2 = scoreCard.charAt(pinCount + 1);
                frame[i] = new Frame(pin1, pin2);
                pinCount += 2;
            } else if (scoreCard.charAt(pinCount) == STRIKE_VAL) {
                char pin1 = STRIKE_VAL;
                char pin2 = ZERO_VAL;
                frame[i] = new Frame(pin1, pin2);
                isStrike = true;
                pinCount++;
            } else if (Character.isDigit(scoreCard.charAt(pinCount)) && scoreCard.charAt(pinCount + 1) == SPARE_VAL) {
                char pin1 = scoreCard.charAt(pinCount);
                char pin2 = SPARE_VAL;
                frame[i] = new Frame(pin1, pin2);
                isSpare = true;
                pinCount += 2;
            }
            if (isStrike)
                frame[i].setScore(Strike(pinCount, scoreCard));
            else if (isSpare)
                frame[i].setScore(Spare(pinCount, scoreCard));
            isStrike = false;
            isSpare = false;
        }
        if (isStrike)
            frame[9].setScore(Strike(pinCount, scoreCard));
        else if (isSpare)
            frame[9].setScore(Spare(pinCount, scoreCard));
        return frame;
    }
    
    private int Strike(int pinCount, String scoreCard) {
        if (scoreCard.charAt(pinCount) == STRIKE_VAL
                && (scoreCard.charAt(pinCount + 1) == STRIKE_VAL || scoreCard.charAt(pinCount + 1) == SPARE_VAL))
            return 20;
        if (scoreCard.charAt(pinCount) == STRIKE_VAL && Character.isDigit(scoreCard.charAt(pinCount + 1)))
            return 10 + Character.getNumericValue(scoreCard.charAt(pinCount + 1));
        if (Character.isDigit(scoreCard.charAt(pinCount)) && Character.isDigit(scoreCard.charAt(pinCount + 1))) {
            return Character.getNumericValue(scoreCard.charAt(pinCount))
                    + Character.getNumericValue(scoreCard.charAt(pinCount + 1));
        } else if (scoreCard.charAt(pinCount + 1) == SPARE_VAL) {
            return 10;
        }
        return 0;
    }
    
    private int Spare(int pinCount, String scoreCard) {
        if (scoreCard.charAt(pinCount) == STRIKE_VAL)
            return 10;
        if (Character.isDigit(scoreCard.charAt(pinCount))) {
            return Character.getNumericValue(scoreCard.charAt(pinCount));
        }
        return 0;
    }
}