package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

/**
 * Created by fredenbe20 on 3/1/2018.
 */

public class PigGameState extends GameState {

    int currentPlayer;
    int player0Score;
    int player1Score;
    int currentRunningScore;
    int currentDieValue;

    public PigGameState() {

    }

    public PigGameState(PigGameState original){

    }
    //getters for all variables
    public int getCurrentPlayer(){return currentPlayer;}
    public int getPlayer0Score(){return player0Score;}
    public int getPlayer1Score(){return player1Score;}
    public int getCurrentRunningScore(){return currentRunningScore;}
    public int getCurrentDieValue(){return currentDieValue;}

    public void setCurrentPlayer(int newPlayer){this.currentPlayer = newPlayer;}

    public void setPlayer0Score(int player0Score){this.player0Score = player0Score;}

    public void setPlayer1Score(int player1Score){this.player1Score = player1Score;}

    public void setCurrentRunningScore(int currentRunningScore){this.currentRunningScore = currentRunningScore;}

    public void setCurrentDieValue(int currentDieValue){this.currentDieValue = currentDieValue;}
}
