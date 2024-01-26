package edu.gorilas;

public class Frame {
    private int pin1;
    private int pin2;
    static int score = 0;
    
    public Frame() {
    }

    // Pin 2 va vacio sin pin 1 es X
    public Frame(int pin1,int bonus1, int bonus2) {
        this.pin1 = pin1;
        this.score += pin1 + bonus1 + bonus2;
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
