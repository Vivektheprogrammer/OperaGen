package com.example.operagen;

//import static android.opengl.Matrix.length;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.operagen.R;

//import java.util.Date;


public class MainActivity3 extends AppCompatActivity {
    Button button;
    TextView textView6,textView2;
    EditText editTextDate,editTextDate2;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        button=findViewById(R.id.button);
        textView6=findViewById(R.id.textView6);
        textView2=findViewById(R.id.textView2);
        editTextDate2=findViewById(R.id.editTextDate2);
        editTextDate=findViewById(R.id.editTextDate);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view)
            {
                double date=((Double.parseDouble(editTextDate.getText().toString())*100) / Double.parseDouble(editTextDate2.getText().toString()));
                int date1= (int) Math.round(date);
                textView6.setText("Percentage\n" +date);
                textView2.setText("Rounded off:" +date1);









            }
        });


    }
}