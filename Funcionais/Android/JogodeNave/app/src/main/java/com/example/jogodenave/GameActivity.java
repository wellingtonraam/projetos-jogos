package com.example.jogodenave;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class GameActivity extends AppCompatActivity implements View.OnTouchListener {


    Impossible view;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //fullscreen mode

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        view = new Impossible(this);
        setContentView(view);
        view.setOnTouchListener(this);



    }

    @Override
    protected void onResume() {
        super.onResume();
        view.resume();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        // restart
        if ( event.getX()<100 && event.getY() >290 && event.getY()<310 ){
            view.init();
        }
        // exit

        if ( event.getX()<100 && event.getY()> 490 && event.getY()<510){
            System.exit(0);
        }
        view.moveDown(10);
        view.addScore(100);

        return true;
    }
}
