package com.rhialtothemarvellous.newangelesrivalrandomizer;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DisplayAllRivalsActivity
        extends AppCompatActivity
        implements DisplayAllRivalsInitialFragment.OnFragmentInteractionListener {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_all_rivals);
        
        // If we're being restored from a previous state, we should nothing
        if (savedInstanceState != null) {
            return;
        }
        
        // Create a new Fragment to be placed in the Activity's layout
        DisplayAllRivalsInitialFragment initialFragment = new DisplayAllRivalsInitialFragment();
        
        // Add the fragment to the layout
        getSupportFragmentManager().beginTransaction()
                .add(R.id.display_all_rivals_fragment_container, initialFragment).commit();
    }
    
    @Override
    public void onFragmentButtonPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
    
        builder.setMessage("Hail Eris!")
                .setPositiveButton(R.string.button_ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    
                    }
                });
    
        builder.show();
    }
}
