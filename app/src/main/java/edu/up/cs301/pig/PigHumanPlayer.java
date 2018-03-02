package edu.up.cs301.pig;

import edu.up.cs301.game.GameHumanPlayer;
import edu.up.cs301.game.GameMainActivity;
import edu.up.cs301.game.R;
import edu.up.cs301.game.infoMsg.GameInfo;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View.OnClickListener;

/**
 * A GUI for a human to play Pig. This default version displays the GUI but is incomplete
 *
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigHumanPlayer extends GameHumanPlayer implements OnClickListener {

	/* instance variables */

    // These variables will reference widgets that will be modified during play
    private TextView    playerScoreTextView = null;
    private TextView    oppScoreTextView    = null;
    private TextView    turnTotalTextView   = null;
    private TextView    messageTextView     = null;
    private ImageButton dieImageButton      = null;
    private Button      holdButton          = null;


    // the android activity that we are running
    private GameMainActivity myActivity;

    /**
     * constructor does nothing extra
     */
    public PigHumanPlayer(String name) {
        super(name);
    }

    /**
     * Returns the GUI's top view object
     *
     * @return
     * 		the top object in the GUI's view heirarchy
     */
    public View getTopView() {
        return myActivity.findViewById(R.id.top_gui_layout);
    }

    /**
     * callback method when we get a message (e.g., from the game)
     *
     * @param info
     * 		the message
     */
    @Override
    public void receiveInfo(GameInfo info) {
        PigGameState gameState = (PigGameState) info;
        if(info instanceof PigGameState && gameState.getCurrentPlayer() == this.playerNum) {
           switch (gameState.getCurrentPlayer())
           {
               case 0:
                   this.playerScoreTextView.setText("" + gameState.getPlayer0Score());
                   this.oppScoreTextView.setText("" + gameState.getPlayer1Score());
                   this.turnTotalTextView.setText("" + gameState.getCurrentRunningScore());
                   break;
               case 1:
                   this.playerScoreTextView.setText("" + gameState.getPlayer1Score());
                   this.oppScoreTextView.setText("" + gameState.getPlayer0Score());
                   this.turnTotalTextView.setText("" + gameState.getCurrentRunningScore());
                   break;
           }
           switch (gameState.getCurrentDieValue())
           {
               case 1:dieImageButton.setImageResource(R.drawable.face1);
               case 2:dieImageButton.setImageResource(R.drawable.face2);
               case 3:dieImageButton.setImageResource(R.drawable.face3);
               case 4:dieImageButton.setImageResource(R.drawable.face4);
               case 5:dieImageButton.setImageResource(R.drawable.face5);
               case 6:dieImageButton.setImageResource(R.drawable.face6);

           }
            return;
        }
        this.flash(Color.BLUE,10);

    }//receiveInfo

    /**
     * this method gets called when the user clicks the die or hold button. It
     * creates a new PigRollAction or PigHoldAction and sends it to the game.
     *
     * @param button
     * 		the button that was clicked
     */
    public void onClick(View button) {
        if(button.getId() == R.id.holdButton)
       {
           PigHoldAction hold = new PigHoldAction(this);
           this.game.sendAction(hold);

       }
       else if(button.getId() == R.id.dieButton)
        {
            PigRollAction roll = new PigRollAction(this);
            this.game.sendAction(roll);
        }
    }// onClick

    /**
     * callback method--our game has been chosen/rechosen to be the GUI,
     * called from the GUI thread
     *
     * @param activity
     * 		the activity under which we are running
     */
    public void setAsGui(GameMainActivity activity) {

        // remember the activity
        myActivity = activity;

        // Load the layout resource for our GUI
        activity.setContentView(R.layout.pig_layout);

        //Initialize the widget reference member variables
        this.playerScoreTextView = (TextView)activity.findViewById(R.id.yourScoreValue);
        this.oppScoreTextView    = (TextView)activity.findViewById(R.id.oppScoreValue);
        this.turnTotalTextView   = (TextView)activity.findViewById(R.id.turnTotalValue);
        this.messageTextView     = (TextView)activity.findViewById(R.id.messageTextView);
        this.dieImageButton      = (ImageButton)activity.findViewById(R.id.dieButton);
        this.holdButton          = (Button)activity.findViewById(R.id.holdButton);

        //Listen for button presses
        dieImageButton.setOnClickListener(this);
        holdButton.setOnClickListener(this);

    }//setAsGui

}// class PigHumanPlayer
