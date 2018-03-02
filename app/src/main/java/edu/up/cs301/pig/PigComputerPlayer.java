package edu.up.cs301.pig;

import java.util.Random;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.util.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        if(info instanceof PigGameState) {
            PigGameState gameState = (PigGameState) info;
            if(gameState.getCurrentPlayer() == this.playerNum)
            {
                Random rand = new Random();
                switch (rand.nextInt(1))
                {
                    case 0:
                        PigHoldAction hold = new PigHoldAction(this);
                        this.game.sendAction(hold);
                        break;
                    case 1:
                        PigRollAction roll = new PigRollAction(this);
                        this.game.sendAction(roll);
                        break;
                }

            }
        }
        return;


    }//receiveInfo

}
