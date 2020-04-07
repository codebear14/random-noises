package com.example.randomnoises;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner sSpinner;
    String soundFile;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sSpinner = (Spinner)findViewById(R.id.soundSpinner);
        //final MediaPlayer mp = MediaPlayer.create(this, R.raw.applause8);
        mp = new MediaPlayer();

        List<String> soundList = new ArrayList<String>();
        soundList.add("Whip");
        soundList.add("Horn");
        soundList.add("Drum");
        soundList.add("Clap");
        soundList.add("Duck");

        ArrayAdapter<String> soundListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, soundList);
        soundListAdapter .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sSpinner.setAdapter(soundListAdapter );

        sSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                soundFile = sSpinner.getItemAtPosition(position).toString().toLowerCase();
                //Toast.makeText(getApplicationContext(), soundFile, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void playSound(View view) throws IOException {
        if(soundFile.equals("clap")){
            mp = MediaPlayer.create(this,R.raw.clap);
        }

        else if(soundFile.equals("drum")){
            mp = MediaPlayer.create(this,R.raw.drum);
        }

        else if(soundFile.equals("duck")){
            mp = MediaPlayer.create(this,R.raw.duck);
        }

        else if(soundFile.equals("horn")){
            mp = MediaPlayer.create(this,R.raw.horn);
        }

        else if(soundFile.equals("whip")){
            mp = MediaPlayer.create(this,R.raw.whip);
        }

        mp.start();
    }
}
