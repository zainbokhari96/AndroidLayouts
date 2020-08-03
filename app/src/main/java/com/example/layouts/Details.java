package com.example.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    TextView myText,myText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        myText = findViewById(R.id.DetailsText);
        myText2 = findViewById(R.id.DescText);
        Intent i = getIntent();

        String title = i.getStringExtra("title");
        String desc = i.getStringExtra("desc");
        myText.setText(title);
        myText2.setText(desc);
    }
}