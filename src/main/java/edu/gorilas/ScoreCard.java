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
            if (Character.isDigit(scoreCard.charAt(pinCount)) && Character.isDigit(scoreCard.charAt(pinCount + 1))) {
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
            if (isStrike) {
                if (scoreCard.charAt(pinCount) == 'X')
                    frame[i].setScore(10);
                if (scoreCard.charAt(pinCount + 1) == 'X')
                    frame[i].setScore(10);
                if (Character.isDigit(scoreCard.charAt(pinCount))
                        && Character.isDigit(scoreCard.charAt(pinCount + 1))) {
                    frame[i].setScore(Character.getNumericValue(scoreCard.charAt(pinCount))
                            + Character.getNumericValue(scoreCard.charAt(pinCount + 1)));
                } else if (scoreCard.charAt(pinCount + 1) == '/') {
                    frame[i].setScore(Character.getNumericValue(scoreCard.charAt(pinCount)));
                    frame[i].setScore(10 - Character.getNumericValue(scoreCard.charAt(pinCount)));
                }
                isStrike = false;
            } else if (isSpare) {
                if (scoreCard.charAt(pinCount) == 'X')
                    frame[i].setScore(10);
                if (Character.isDigit(scoreCard.charAt(pinCount))) {
                    frame[i].setScore(Character.getNumericValue(scoreCard.charAt(pinCount)));
                }
                isSpare = false;
            }
        }
        if (isStrike) {
            if (scoreCard.charAt(pinCount) == 'X')
                frame[0].setScore(10);
            if (scoreCard.charAt(pinCount + 1) == 'X')
                frame[0].setScore(10);
            if (Character.isDigit(scoreCard.charAt(pinCount))
                    && Character.isDigit(scoreCard.charAt(pinCount + 1))) {
                frame[0].setScore(Character.getNumericValue(scoreCard.charAt(pinCount))
                        + Character.getNumericValue(scoreCard.charAt(pinCount + 1)));
            } else if (scoreCard.charAt(pinCount + 1) == '/') {
                frame[0].setScore(Character.getNumericValue(scoreCard.charAt(pinCount)));
                frame[0].setScore(10 - Character.getNumericValue(scoreCard.charAt(pinCount)));
            }
            isStrike = false;
        } else if (isSpare) {
            if (scoreCard.charAt(pinCount) == 'X')
                frame[0].setScore(10);
            if (Character.isDigit(scoreCard.charAt(pinCount))) {
                frame[0].setScore(Character.getNumericValue(scoreCard.charAt(pinCount)));
            }
            isSpare = false;
        }
        return frame;
    }
}