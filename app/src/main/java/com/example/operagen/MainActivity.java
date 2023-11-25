package com.example.operagen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
        public void MainActivity2(View v)
        {
            Intent  intent=new Intent(this,MainActivity2.class);
            startActivity(intent);

        }
    public void MainActivity3(View v)
    {
        Intent  intent=new Intent(this,MainActivity3.class);
        startActivity(intent);

    }


}