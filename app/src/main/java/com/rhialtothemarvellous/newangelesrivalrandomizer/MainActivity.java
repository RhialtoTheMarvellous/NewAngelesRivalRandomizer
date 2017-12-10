package com.rhialtothemarvellous.newangelesrivalrandomizer;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_CORP_LIST
            = "com.rhialtothemarvellous.newangelesrivalrandomizer.CORP_LIST";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void submitList(View view) {
        ArrayList<Corp> list = new ArrayList<>();
    
        // Put the selected corps into the list ...
        // ... In a nicer way than this
        if (((CheckBox) findViewById(R.id.checkBox_Globalsec)).isChecked()) {
            list.add(Corp.GLOBALSEC);
        }
        if (((CheckBox) findViewById(R.id.checkBox_HaasBioroid)).isChecked()) {
            list.add(Corp.HAASBIOROID);
        }
        if (((CheckBox) findViewById(R.id.checkBox_Jinteki)).isChecked()) {
            list.add(Corp.JINTEKI);
        }
        if (((CheckBox) findViewById(R.id.checkBox_Melange)).isChecked()) {
            list.add(Corp.MELANGE);
        }
        if (((CheckBox) findViewById(R.id.checkBox_Nbn)).isChecked()) {
            list.add(Corp.NBN);
        }
        if (((CheckBox) findViewById(R.id.checkBox_Weyland)).isChecked()) {
            list.add(Corp.WEYLAND);
        }
    
        // If fewer than four selected, don't go
        if (list.size() < 4) {
            DialogFragment fourCorpsWarning = new FourCorpsDialogFragment();
            fourCorpsWarning.show(getFragmentManager(), "four corps warning");
            return;
        }
    
        Intent intent = new Intent(this, DisplayRivalsActivity.class);
    
        // TODO: This works because enums are Serliazable, but apparently Parcelable classes give better performance
        intent.putExtra(EXTRA_CORP_LIST, list);
    
        startActivity(intent);
    }
}
