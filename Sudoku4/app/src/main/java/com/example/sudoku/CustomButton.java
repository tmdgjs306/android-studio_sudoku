package com.example.sudoku;

import android.content.Context;
import android.graphics.Color;
import android.text.Layout;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class CustomButton extends FrameLayout {
    int i;
    int j;
    int value;
    TextView textView;
    public CustomButton(@NonNull Context context,int i, int j) {
        super(context);
        this.i = i;
        this.j = j;
        textView = new TextView(context);
        textView.setTextSize(35);
        textView.setGravity(Gravity.CENTER_HORIZONTAL);
        textView.setPadding(5,15,5,15);

        setClickable(true);
        setBackgroundResource(R.drawable.button_selector);
        addView(textView);

    }
    public void set(int a)
    {
        if(a!=0)
        {
            textView.setText(Integer.toString(a));
            value = a;
        }
        else
        {
            textView.setText(null);
            value =a;
        }
    }
    public String get() {
        String temp =  textView.getText().toString();
        value =0;
        return temp;
    }
}
