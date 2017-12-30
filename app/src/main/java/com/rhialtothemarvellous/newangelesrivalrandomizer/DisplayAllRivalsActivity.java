package com.rhialtothemarvellous.newangelesrivalrandomizer;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DisplayAllRivalsActivity
        extends AppCompatActivity
        implements DisplayAllRivalsInitialFragment.OnFragmentInteractionListener,
                    DisplayRivalFragment.OnFragmentInteractionListener {
    
    private Game mGame;
    private int mNextPlayer = 0;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_all_rivals);
        
        // If we're being restored from a previous state, we should nothing
        if (savedInstanceState != null) {
            return;
        }
    
        Intent intent = getIntent();
        mGame = (Game) intent.getSerializableExtra(SelectCorpsActivity.GAME);
        
        // Create a new Fragment to be placed in the Activity's layout
        DisplayAllRivalsInitialFragment initialFragment = new DisplayAllRivalsInitialFragment();
        
        // Add the fragment to the layout
        getSupportFragmentManager().beginTransaction()
                .add(R.id.display_all_rivals_fragment_container, initialFragment).commit();
    }
    
    @Override
    public void onDisplayAllRivalsInitialFragmentButtonPressed() {
        displayNextRival();
    }
    
    @Override
    public void onFinishedDisplayRival() {
        mNextPlayer++;
        
        if (mNextPlayer < mGame.getPlayers().size()) {
            displayNextRival();
        }
        else {
            new AlertDialog.Builder(this)
                    .setMessage("Finished.")
                    .show();
        }
    }
    
    private void displayNextRival() {
        Corp player = mGame.getPlayers().get(mNextPlayer);
        
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        
        builder.setMessage("Pass the device to " + getString(player.getStringID()) + ".")
                .setPositiveButton(R.string.button_ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
        
            }
        })
                .show();
        
        CorpOrFederalist rival = mGame.getRival(player);
        DisplayRivalFragment rivalFragment = DisplayRivalFragment.newInstance(player, rival);
    
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    
        transaction.replace(R.id.display_all_rivals_fragment_container, rivalFragment);
    
        transaction.commit();
    }
}
