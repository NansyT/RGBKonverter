package com.example.rgbkonverter;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ColourPresenter.View {

    SeekBar redBar, greenBar, blueBar;
    Integer redVal = 0;
    Integer blueVal = 0;
    Integer greenVal = 0;
    TextView hexValue;
    ImageView imageView;
    ColourPresenter presenter = new ColourPresenter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        redBar = (SeekBar) findViewById(R.id.red);
        greenBar = (SeekBar) findViewById(R.id.green);
        blueBar = (SeekBar) findViewById(R.id.blue);

        hexValue = (TextView) findViewById(R.id.hexColor);

        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setBackgroundColor(Color.rgb(redVal, greenVal, blueVal));

        redBar.setOnSeekBarChangeListener(seekBarChangeListener);
        greenBar.setOnSeekBarChangeListener(seekBarChangeListener);
        blueBar.setOnSeekBarChangeListener(seekBarChangeListener);
    }

    SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            switch (seekBar.getId()) {
                case R.id.red:
                    presenter.setRedValue(seekBar.getProgress());
                    break;
                case R.id.green:
                    presenter.setGreenValue(seekBar.getProgress());
                    break;
                case R.id.blue:
                    presenter.setBlueValue(seekBar.getProgress());
                    break;
            }
            hexValue.setText(String.format("#%02x%02x%02x", redVal, greenVal, blueVal));
            imageView.setBackgroundColor(Color.rgb(redVal,greenVal,blueVal));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    @Override
    public void redValueAdded(Integer value) {
        redVal = value;
    }

    @Override
    public void greenValueAdded(Integer value) {
        greenVal = value;
    }

    @Override
    public void blueValueAdded(Integer value) {
        blueVal = value;
    }
}