package com.example.compass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showSensors (View view) {
        Intent sensorIntent = new Intent(this, SensorActivity.class);
        startActivity(sensorIntent);
    }

    public void showCompass (View view) {
        Intent compassIntent = new Intent(this, CompassActivity.class);
        startActivity(compassIntent);
    }
}
