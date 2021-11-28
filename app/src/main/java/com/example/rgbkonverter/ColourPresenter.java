package com.example.rgbkonverter;

import android.view.View;

public class ColourPresenter {
    Colour colour;
    View view;

    public ColourPresenter(View view) {
        colour = new Colour();
        this.view = view;
    }

    public void setRedValue(Integer value) {
        colour.setRedValue(value);
        view.redValueAdded(colour.getRedValue());
    }
    public void setGreenValue(Integer value) {
        colour.setGreenValue(value);
        view.greenValueAdded(colour.getGreenValue());
    }
    public void setBlueValue(Integer value) {
        colour.setBlueValue(value);
        view.blueValueAdded(colour.getBlueValue());
    }

    public interface View {
        public void redValueAdded(Integer newRedValue);
        public void greenValueAdded(Integer newGreenValue);
        public void blueValueAdded(Integer newblueValue);
    }
}
