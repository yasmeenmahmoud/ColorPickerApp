package com.example.colorpickerapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.margaritov.preference.colorpicker.ColorPickerDialog;

public class MainActivity extends AppCompatActivity {
ColorPickerDialog colord;
    int color;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView hashcolor=findViewById(R.id.hashcolor);
        final LinearLayout mybackground=findViewById(R.id.linearlayout);
        Button colorpicker=findViewById(R.id.btn_pickcolor);
        colorpicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
color= Color.parseColor("#005500");
                colord=new ColorPickerDialog(MainActivity.this,color);
                colord.setAlphaSliderVisible(true);
                colord.setTitle("color picker");
                colord.setOnColorChangedListener(new ColorPickerDialog.OnColorChangedListener() {
                    @Override
                    public void onColorChanged(int i) {
                        color=i;
                        mybackground.setBackgroundColor(color);
                        hashcolor.setText("#"+Integer.toHexString(color));
                        hashcolor.setTextColor(color);
                    }
                });
                colord.show();
            }
        });
    }
}
