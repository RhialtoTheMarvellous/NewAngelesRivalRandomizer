package com.rhialtothemarvellous.newangelesrivalrandomizer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
    }

    public void newGame(View view) {
        Intent intent = new Intent(this, SelectCorpsActivity.class);

        startActivity(intent);
    }
}
