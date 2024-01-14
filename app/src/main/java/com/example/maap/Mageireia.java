package com.example.maap;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class Mageireia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mageireia);


        TextView textViewprwino = findViewById(R.id.prwino);
        textViewprwino.setPaintFlags(textViewprwino.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

        TextView textViewdekatiano = findViewById(R.id.dekatiano);
        textViewdekatiano.setPaintFlags(textViewdekatiano.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

        TextView textViewmesimeriano = findViewById(R.id.mesimeriano);
        textViewmesimeriano.setPaintFlags(textViewmesimeriano.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

        TextView textViewvradino = findViewById(R.id.vradino);
        textViewvradino.setPaintFlags(textViewvradino.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getInstance().format(calendar.getWeekYear());







        TextView textViewDate =  findViewById(R.id.date);
        //textViewDate.setText(currentDate);


        statusbarcolor();

    }

    //Gia thn allagh tou xrwmatos sto activity
    private void statusbarcolor()
    {
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            getWindow().setStatusBarColor(getResources().getColor(R.color.kylikeio,this.getTheme()));
        }else if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP)
        {
            getWindow().setStatusBarColor(getResources().getColor(R.color.kylikeio));
        }
    }


}