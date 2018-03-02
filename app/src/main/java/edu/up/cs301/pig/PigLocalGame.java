package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

import java.util.Random;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {
    private PigGameState pig;

    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        this.pig = new PigGameState();

    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        return playerIdx == pig.getCurrentPlayer();
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        if (action instanceof PigHoldAction) {
            int player = pig.getCurrentPlayer();
            if (player == 0) {
                pig.setPlayer0Score(pig.getCurrentRunningScore() + pig.getPlayer0Score());
                pig.setCurrentRunningScore(0);
                pig.setCurrentPlayer(1);
            } else if (player == 1) {
                pig.setPlayer0Score(pig.getCurrentRunningScore() + pig.getPlayer1Score());
                pig.setCurrentRunningScore(0);
                pig.setCurrentPlayer(0);
            }
            return true;
        } else if (action instanceof PigRollAction) {
            Random rand = new Random();
            pig.setCurrentDieValue(rand.nextInt(6) + 1);
            if (pig.getCurrentDieValue() != 1) {
                pig.setCurrentRunningScore(pig.getCurrentRunningScore() + pig.getCurrentDieValue());
            } else if (pig.getCurrentDieValue() == 1) {
                pig.setCurrentRunningScore(0);
                switch (pig.getCurrentPlayer()) {
                    case 0:
                        pig.setCurrentPlayer(1);
                        break;
                    case 1:
                        pig.setCurrentPlayer(0);
                        break;

                }
            }
            return true;
        }
        return false;
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        PigGameState playerPigGameState = new PigGameState(pig);
        p.sendInfo(playerPigGameState);

    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return a message that tells who has won the game, or null if the
     * game is not over
     */
    @Override
    protected String checkIfGameOver() {
        if(pig.getPlayer0Score() >= 50){
            return "Player 0 Wins with a score of " + pig.getPlayer0Score();
        }
        else if(pig.getPlayer1Score() >= 50){
            return "Player 1 Wins with a score of " + pig.getPlayer1Score();
        }

        return null;
    }

}// class PigLocalGame
