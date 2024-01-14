package com.example.maap;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

//gia to refresh
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


public class MainActivity extends AppCompatActivity {
    private Button btn_mageireia, btn_kylikeio;


    //Gia to Refresh
    SwipeRefreshLayout refreshLayout;
    Handler h = new Handler();
    ImageView logo_refresh;
    //Telos gia to Refresh

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_mageireia = findViewById(R.id.button_mageireia);
        btn_kylikeio = findViewById(R.id.button_kylikeio);

        btn_mageireia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMageireia_Activity();

            }
        });

        btn_kylikeio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openKylikeio_Activity();

            }
        });

        statusbarcolor();




    }

    private void openKylikeio_Activity() {
        Intent intent_kylikeio = new Intent(this, Kylikeio.class);
        startActivity(intent_kylikeio);
    }

    private void openMageireia_Activity() {
        Intent intent_mageireia = new Intent(this, Mageireia.class);
        startActivity(intent_mageireia);
    }



    //Gia logo turning
    public void startAnimation(View view)
    {
        ObjectAnimator animator = ObjectAnimator.ofFloat(logo_refresh, "rotation", 0f, 360f);
        animator.setDuration(3000);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator);
        animatorSet.start();
    }
    //Telos gia logo turning

    //Gia thn allagh tou xrwmatos sto activity
    private void statusbarcolor()
    {
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            getWindow().setStatusBarColor(getResources().getColor(R.color.main,this.getTheme()));
        }else if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP)
        {
            getWindow().setStatusBarColor(getResources().getColor(R.color.main));
        }
    }

}