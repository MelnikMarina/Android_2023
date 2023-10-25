package com.example.melnikmarina_lab1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText color_t;
    private Button be;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        color_t = findViewById(R.id.text_color);
        be = findViewById(R.id.button_1);
        be.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String color = color_t.getText().toString();
                if (color.equalsIgnoreCase("red")){
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("color", "red");
                    startActivity(intent);
                }
                else if (color.equalsIgnoreCase("green")){
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("color", "green");
                    startActivity(intent);
                }
                else if (color.equalsIgnoreCase("blue")){
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("color", "blue");
                    startActivity(intent);
                }
                else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Ошибочное значение введено");
                    builder.setMessage("Введите валидные значения (red, blue, green)");
                    builder.setCancelable(false);
                    builder.setPositiveButton("Хорошо", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    AlertDialog alertdialog = builder.create();
                    alertdialog.show();
                }
            }
        });
    }

    public void toColorActivity(View view, String color){
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("color", color);
        startActivity(intent);
    }
}