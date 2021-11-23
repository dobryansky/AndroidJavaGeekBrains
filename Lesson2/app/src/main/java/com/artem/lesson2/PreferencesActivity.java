package com.artem.lesson2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;

public class PreferencesActivity extends AppCompatActivity {
    private SwitchCompat switchCompat;
    private int theme=0;
    private TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState!=null){
           if( savedInstanceState.getInt("theme")==1){
               setTheme(R.style.Theme_pink);
           }else {
               setTheme(R.style.Theme_Lesson2);
           }
        }
        setContentView(R.layout.activity_preferences);
        initViews();
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Intent resultIntent= new  Intent();
                Intent intent=getIntent();
                if(intent.getIntExtra("theme",0)==0) {
                    theme = 1;
                    resultIntent.putExtra("theme",theme);
                    setResult(RESULT_OK,resultIntent);
                }else {
                    theme = 0;
                    resultIntent.putExtra("theme",theme);
                    setResult(RESULT_OK,resultIntent);
                }
                finish();

            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("theme",theme);
    }

    private void initViews() {
        switchCompat=findViewById(R.id.switch1);
        text=findViewById(R.id.text_id_pref);
    }
}