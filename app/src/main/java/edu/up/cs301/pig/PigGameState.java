package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

/**
 * Created by fredenbe20 on 3/1/2018.
 */

public class PigGameState extends GameState {

    private int currentPlayer;
    private int player0Score;
    private int player1Score;
    private int currentRunningScore;
    private int currentDieValue;

    public PigGameState()
    {
        this.currentPlayer = 0;
        this.player0Score = 0;
        this.player1Score = 0;
        this.currentRunningScore = 0;
        this.currentDieValue = 0;
    }

    public PigGameState(PigGameState copy)
    {
        this.currentPlayer = copy.currentPlayer;
        this.player0Score = copy.player0Score;
        this.player1Score = copy.player1Score;
        this.currentRunningScore = copy.currentRunningScore;
        this.currentDieValue = copy.currentDieValue;

    }

}
