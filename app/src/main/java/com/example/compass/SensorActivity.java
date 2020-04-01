package com.example.compass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.widget.TextView;

import java.text.DecimalFormat;

public class SensorActivity extends CompassActivity implements SensorEventListener{

    private static DecimalFormat df = new DecimalFormat("0.00");

    TextView accelerometer;
    TextView orientation;

    private String orientationString = "";
    private float[] orientationVector = new float[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        accelerometer = findViewById(R.id.txt_accelerometer);
        orientation = findViewById(R.id.txt_tiltDirection);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        super.onSensorChanged(event);

        String valueString = "Accelerometer x: " + df.format(super.mLastAccelerometer[0]) + "\n" +
                "Accelerometer y: " + df.format(super.mLastAccelerometer[1]) + "\n" +
                "Accelerometer z: " + df.format(super.mLastAccelerometer[2]);

        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            accelerometer.setText(valueString);

            super.mSensorManager.getOrientation(super.rMat, orientationVector);

            if (orientationVector[2] > (Math.PI/18) && orientationVector[2] <= (Math.PI/2)) {
                orientationString = "Right";
                orientation.setText(orientationString);
            } else if (orientationVector[2] < -(Math.PI/18) && orientationVector[2] >= -(Math.PI/2)) {
                orientationString = "Left";
                orientation.setText(orientationString);
            } else if (orientationVector[2] <= (Math.PI/18) && orientationVector[2] >= -(Math.PI/18)) {
                orientationString = "Face up";
                orientation.setText(orientationString);
            }
        }
    }
}
