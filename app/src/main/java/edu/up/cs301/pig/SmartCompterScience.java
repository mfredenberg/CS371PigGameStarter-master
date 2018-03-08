package edu.up.cs301.pig;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.infoMsg.GameInfo;

/**
 * Created by steli on 3/8/2018.
 */

public class SmartCompterScience extends GameComputerPlayer {

   public SmartCompterScience(String name) {
   super(name);
   }


    /**
     * An AI for Pig
     *
     * @author Andrew M. Nuxoll
     * @version August 2015
     */


        /**
         * ctor does nothing extra
         */


        /**
         * callback method--game's state has changed
         *
         * @param info
         * 		the information (presumably containing the game's state)
         */
        @Override
        protected void receiveInfo(GameInfo info) {

            if(info instanceof PigGameState) {
                PigGameState gameState =  (PigGameState) info;
                /// Log.i("player 1 score: " + gameState.getPlayer1Score(), "dsd");
                if(gameState.getCurrentPlayer() == this.playerNum)
                {
                    if(Math.abs(gameState.getPlayer1Score() - gameState.getPlayer0Score()) < 5
                            || gameState.getCurrentRunningScore() < 10 ||
                            50 - gameState.getPlayer1Score() < 5)
                        this.game.sendAction(new PigRollAction(this));
                    else
                        this.game.sendAction(new PigHoldAction(this));


            }



        }//receiveInfo

    }

}
