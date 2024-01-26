package edu.gorilas;

public class Frame {
    private int pin1;
    private int pin2;
    static int score = 0;
    
    public Frame() {
    }

    public Frame(int pin1, int pin2) {
        this.pin1 = pin1;
        this.pin2 = pin2;
        this.score += pin1 + pin2;
    }

    public int getScore() {
        return score;
    }

}
