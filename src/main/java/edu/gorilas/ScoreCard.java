package edu.gorilas;

import java.util.Arrays;

public class ScoreCard {
    private String scoreCard = "";

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
            if ((Character.isDigit(scoreCard.charAt(pinCount)) || scoreCard.charAt(pinCount) == '-') && (Character.isDigit(scoreCard.charAt(pinCount + 1)) || scoreCard.charAt(pinCount + 1) == '-')) {
                char pin1 = scoreCard.charAt(pinCount);
                char pin2 = scoreCard.charAt(pinCount + 1);
                frame[i] = new Frame(pin1, pin2);
                pinCount += 2;
            } else if (scoreCard.charAt(pinCount) == 'X') {
                char pin1 = 'X';
                char pin2 = '-';
                frame[i] = new Frame(pin1, pin2);
                isStrike = true;
                pinCount++;
            } else if (Character.isDigit(scoreCard.charAt(pinCount)) && scoreCard.charAt(pinCount + 1) == '/') {
                char pin1 = scoreCard.charAt(pinCount - 1);
                char pin2 = '/';
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
        if (scoreCard.charAt(pinCount) == 'X'
                && (scoreCard.charAt(pinCount + 1) == 'X' || scoreCard.charAt(pinCount + 1) == '/'))
            return 20;
        if (scoreCard.charAt(pinCount) == 'X' && Character.isDigit(scoreCard.charAt(pinCount + 1)))
            return 10 + Character.getNumericValue(scoreCard.charAt(pinCount + 1));
        if (Character.isDigit(scoreCard.charAt(pinCount)) && Character.isDigit(scoreCard.charAt(pinCount + 1))) {
            return Character.getNumericValue(scoreCard.charAt(pinCount))
                    + Character.getNumericValue(scoreCard.charAt(pinCount + 1));
        } else if (scoreCard.charAt(pinCount + 1) == '/') {
            return 10;
        }
        return 0;
    }
    
    private int Spare(int pinCount, String scoreCard) {
        if (scoreCard.charAt(pinCount) == 'X')
            return 10;
        if (Character.isDigit(scoreCard.charAt(pinCount))) {
            return Character.getNumericValue(scoreCard.charAt(pinCount));
        }
        return 0;
    }
}