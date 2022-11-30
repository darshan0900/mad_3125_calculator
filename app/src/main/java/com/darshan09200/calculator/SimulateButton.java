package com.darshan09200.calculator;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;

public class SimulateButton {

    private static int RIPPLE_COLOR = com.google.android.material.R.color.mtrl_btn_ripple_color;

    public static void apply(View view){
        view.setBackground(getBackgroundDrawable(RIPPLE_COLOR, view.getBackground()));
    }

    private static RippleDrawable getBackgroundDrawable(int pressedColor, Drawable backgroundDrawable) {
        return new RippleDrawable(getPressedState(pressedColor), backgroundDrawable, null);
    }

    private static ColorStateList getPressedState(int pressedColor) {
        return new ColorStateList(new int[][]{new int[]{}}, new int[]{pressedColor});
    }
}
