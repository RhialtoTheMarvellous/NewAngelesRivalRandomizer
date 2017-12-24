package com.rhialtothemarvellous.newangelesrivalrandomizer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class DisplayAllRivalsActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_all_rivals);
    
        Intent intent = getIntent();
        Game game = (Game) intent.getSerializableExtra(SelectCorpsActivity.GAME);
    
        List<Corp> players = game.getPlayers();
    
        StringBuilder builder = new StringBuilder();

        for (Corp player: players) {
            builder.append(getString(player.getStringID()))
                    .append(" : ")
                    .append(getString(game.getRival(player).getStringID()))
                    .append("\n");
        }
        builder.append(getString(Unused.UNUSED.getStringID()))
                .append(" : ")
                .append(getString(game.getUnusedCard().getStringID()));
        
        TextView textView = findViewById(R.id.textView_List);
        
        textView.setText(builder.toString());
    }
}
