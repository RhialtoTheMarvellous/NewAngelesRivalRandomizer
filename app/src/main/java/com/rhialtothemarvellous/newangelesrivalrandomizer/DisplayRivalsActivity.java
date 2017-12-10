package com.rhialtothemarvellous.newangelesrivalrandomizer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DisplayRivalsActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_rivals);
    
        Intent intent = getIntent();
        List<Corp> players = (ArrayList<Corp>) intent.getSerializableExtra(MainActivity.EXTRA_CORP_LIST);
    
        RivalShuffler shuffler = new RivalShuffler();
    
        Map<CorpOrUnused, CorpOrFederalist> rivals = shuffler.shuffle(players);
    
        StringBuilder builder = new StringBuilder();
    
        for (CorpOrFederalist player: players) {
            builder.append(getString(player.getStringID()))
                    .append(" : ")
                    .append(getString(rivals.get(player).getStringID()))
                    .append(rivals.get(player) != player ? "" : " ---ERROR!---")
                    .append("\n");
        }
        builder.append(getString(Unused.UNUSED.getStringID()))
                .append(" : ")
                .append(getString(rivals.get(Unused.UNUSED).getStringID()));
        
        TextView textView = findViewById(R.id.textView_List);
        
        textView.setText(builder.toString());
    }
}
