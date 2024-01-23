package edu.gorilas;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        //int totalScore = scoreCard.calculateScore(score);
        //assertEquals(60, totalScore);
    }
}
