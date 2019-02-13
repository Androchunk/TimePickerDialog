package com.androchunk.timepickerdialog;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements TimePickerFragment.TimePickerListener {

    private TextView tvDisplayTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplayTime = findViewById(R.id.tvDisplayTime);

        Button btnShowTimePicker = findViewById(R.id.btnShowTimePicker);
        btnShowTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment timePickerFragment = new TimePickerFragment();
                timePickerFragment.setCancelable(false);
                timePickerFragment.show(getSupportFragmentManager(), "timePicker");
            }
        });
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
        tvDisplayTime.setText("Hour = " + hour + " Minute = " + minute);
    }
}
