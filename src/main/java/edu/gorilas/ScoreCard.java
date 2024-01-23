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

    public List<Frame> getFrames() {
        return frames;
    }

    public void calculateScore(String scoreCard){
        System.out.println(scoreCard);
    }
}
