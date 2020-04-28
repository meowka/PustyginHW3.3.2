package com.example.hw332;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    String [] language = {" ", "ru", "en"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        final Spinner spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, language);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setPrompt(getString(R.string.language));


       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if (spinner.getSelectedItem().toString().equals("ru")){
                           Locale locale = new Locale("ru");
                           Configuration config = new Configuration();
                           config.setLocale(locale);
                           getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                           recreate();
           }
               else if (spinner.getSelectedItem().toString().equals("en")){
                   Locale locale = new Locale("en");
                   Configuration config = new Configuration();
                   config.setLocale(locale);
                   getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                   recreate();
               }
           }
       });
    }
}
