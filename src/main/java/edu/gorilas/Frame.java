package edu.gorilas;

public class Frame {
    private char pin1;
    private char pin2;
    private char pinExtra;
    private int score = 0;
    
    public Frame() {
    }

    public Frame(char pin1, char pin2) {
        this.pin1 = CheckZero(pin1);
        this.pin2 = CheckZero(pin2);
        this.score += charToInt(pin1, 0) + charToInt(pin2, charToInt(pin1, 0));
    }

    public Frame(char pin1, char pin2, char pinExtra) {
        this.pin1 = CheckZero(pin1);
        this.pin2 = CheckZero(pin2);
        this.pinExtra = CheckZero(pinExtra);
        this.score += charToInt(pin1, 0) + charToInt(pin2, charToInt(pin1, 0) + charToInt(pinExtra, 0) );
    }

    public int getScore() {
        return score;
    }
    
    public void setScore(int score) {
        this.score += score;
    }

    private int charToInt(char pin, int pin2) {
        if (pin == 'X')
            return 10;
        if (pin == '-')
            return 0;
        if (pin == '/')
            return 10 - pin2;
        return pin - '0';
    }

    private char CheckZero(char pin) {
        return (pin == '0') ? '-' : pin;
    }

}
