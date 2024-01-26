package edu.gorilas;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Unit test for simple App.
 */
public class ScoreCardTest {
    private ScoreCard scoreCard = null;


    /* -------------- TESTING BEHAVIOURS -------------------*/

    @BeforeEach
    public void init() {
        scoreCard = new ScoreCard();
    }

    @Test
    public void TotalScoreHittingPinsTest() {
        String score = "12345123451234512345";
        int totalScore = scoreCard.calculateScore(score);
        assertEquals(60, totalScore);
    }
    
    public void PrefectGameTest() {
        String score = "XXXXXXXXXXXX";
        int totalScore = scoreCard.calculateScore(score);
        assertEquals(300, totalScore);
    }
}
