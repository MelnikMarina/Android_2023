package com.example.melnikmarina_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class SecondActivity extends AppCompatActivity {

    private Button bb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        bb = findViewById(R.id.button_2);
        Bundle extras = getIntent().getExtras();
        LinearLayout back_color = findViewById(R.id.color_view);
        if (extras != null){
            String color = extras.get("color").toString();
            if (color.equals("red")){
                back_color.setBackgroundColor(Color.rgb(255, 0, 0));
            }
            else if (color.equals("green")){
                back_color.setBackgroundColor(Color.rgb(0, 255, 0));
            }
            else if (color.equals("blue")){
                back_color.setBackgroundColor(Color.rgb(0, 0, 255));
            }
        }
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}