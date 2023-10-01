package com.yusufsenturk.simpletimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button buttonStart;
    Button buttonStop;
    Button buttonReset;
    Button buttonContinue;

    Runnable runnable;
    Handler handler;

    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number=0;

        textView=findViewById(R.id.textView);
        buttonStart=findViewById(R.id.buttonStart);
        buttonStop=findViewById(R.id.buttonStop);
        buttonReset=findViewById(R.id.buttonReset);
        buttonContinue=findViewById(R.id.buttonContinue);

    }
    public void Start(View view){
        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(runnable,1000);
                number++;
                textView.setText("Time : "+number);
            }
        };
        handler.post(runnable);
        buttonStart.setEnabled(false);
        buttonStop.setEnabled(true);
    }
    public void Stop(View view){

        handler.removeCallbacks(runnable);

        buttonReset.setEnabled(true);
        buttonContinue.setEnabled(true);
        buttonStop.setEnabled(false);
    }
    public void Reset(View view){
        number=0;
        textView.setText("Time : "+number);

        buttonStart.setEnabled(true);
        buttonReset.setEnabled(false);
        buttonContinue.setEnabled(false);
    }
    public void Continue(View view){

        handler.post(runnable);

        buttonReset.setEnabled(false);
        buttonContinue.setEnabled(false);
        buttonStop.setEnabled(true);
    }
}