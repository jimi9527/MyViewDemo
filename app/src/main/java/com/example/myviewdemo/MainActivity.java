package com.example.myviewdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*

        FrameLayout layout = (FrameLayout)findViewById(R.id.linearlayout);
        final Button btn = new Button(this);
        btn.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        btn.setLayoutParams(new LinearLayout.LayoutParams(300, 100));
        btn.setText("onmyclick");
        layout.addView(btn);
        btn.setOnClickListener(new MyLoadingView.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d("test", "i am onCkick");
            }
        });
*/
    }

}
