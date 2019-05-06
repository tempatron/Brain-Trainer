package com.example.braintrainer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button goButton;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button playAgain;
    TextView scoreTextView;
    TextView sumText;
    TextView timerTextView;
    TextView resultTextView;
    int result;
    int scoreU = 0;
    int scoreD = 0;
    Random rand;
    int numberBetweenZeroToThree;


    CountDownTimer countDownTimer;

    public void resetTimer() {
        timerTextView.setText("30");
        countDownTimer.cancel();
        goButton.setText("GO!");
    }

    public int randomSum(){

        Random rand = new Random();
        int tempResult;
        int a = rand.nextInt(21);
        int b = rand.nextInt(21);
        tempResult = a+b;
        sumText.setText(Integer.toString(a) + " + " + Integer.toString(b));
        return tempResult;


    }



    public void buttons(int result){

        numberBetweenZeroToThree = rand.nextInt(3);

        switch (numberBetweenZeroToThree) {
            case 0:
                button0.setText(Integer.toString(result));
                button1.setText(Integer.toString(rand.nextInt(21)));
                button2.setText(Integer.toString(rand.nextInt(21)));
                button3.setText(Integer.toString(rand.nextInt(21)));

            break;
            case 1:
                button1.setText(Integer.toString(result));
                button0.setText(Integer.toString(rand.nextInt(21)));
                button2.setText(Integer.toString(rand.nextInt(21)));
                button3.setText(Integer.toString(rand.nextInt(21)));


            break;
            case 2:
                button2.setText(Integer.toString(result));
                button0.setText(Integer.toString(rand.nextInt(21)));
                button1.setText(Integer.toString(rand.nextInt(21)));
                button3.setText(Integer.toString(rand.nextInt(21)));
            break;
            case 3:

                button3.setText(Integer.toString(result));

                button1.setText(Integer.toString(rand.nextInt(21)));
                button2.setText(Integer.toString(rand.nextInt(21)));
                button0.setText(Integer.toString(rand.nextInt(21)));
                break;

            }

        }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goButton = findViewById(R.id.goButton);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        playAgain = findViewById(R.id.playAgain);


        rand = new Random();

        Toast.makeText(this,"Solved at least 15",Toast.LENGTH_LONG).show();



        scoreTextView =findViewById(R.id.scoreTextView);
        sumText = findViewById(R.id.sumText);
        timerTextView = findViewById(R.id.timerTextView);
        resultTextView = findViewById(R.id.resultTextView);



        countDownTimer = new CountDownTimer(30000+200, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                    if(millisUntilFinished != 1) {
                        long temp = millisUntilFinished/1000;
                        temp = temp - 1;
                        timerTextView.setText(Long.toString(temp));
                    }

            }

            @Override
            public void onFinish() {
                    MediaPlayer mplayer = MediaPlayer.create(getApplicationContext(), R.raw.airhorn);
                    mplayer.start();
                    resetTimer();
                    playAgain.setVisibility(View.VISIBLE);
                    button0.setClickable(false);
                    button1.setClickable(false);
                    button2.setClickable(false);
                    button3.setClickable(false);
                    if(scoreD >= 15){
                        float temp1 = scoreU;
                        float temp2 = scoreD;
                        float accuracy = (temp1/temp2) * 100;
                        resultTextView.setText("Accuracy "+ String.format("%.2f", accuracy)+"%");
                    }

            }
        };




        final View.OnClickListener goButtonListener= new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                button0.setVisibility(View.VISIBLE);
                button1.setVisibility(View.VISIBLE);
                button2.setVisibility(View.VISIBLE);
                button3.setVisibility(View.VISIBLE);
                goButton.setVisibility(View.INVISIBLE);
                result = randomSum();
                buttons(result);
                countDownTimer.start();
            }
        };


        goButton.setOnClickListener(goButtonListener);


        View.OnClickListener playAgainButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAgain.setVisibility(View.INVISIBLE);
                button0.setClickable(true);
                button1.setClickable(true);
                button2.setClickable(true);
                button3.setClickable(true);
                scoreU = 0;
                scoreD = 0;
                result = randomSum();
                buttons(result);
                scoreTextView.setText(scoreU + "/" +scoreD);
                countDownTimer.start();
                resultTextView.setVisibility(View.INVISIBLE);
            }
        };

        playAgain.setOnClickListener(playAgainButtonListener);






        View.OnClickListener button0Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String temp =  String.valueOf(result);

                if(button0.getText().toString().equalsIgnoreCase(temp)){
                    scoreU++;
                    scoreD++;
                    resultTextView.setText("Right :)");
                    resultTextView.setVisibility(View.VISIBLE);

                }else {
                    resultTextView.setVisibility(View.VISIBLE);
                    resultTextView.setText("Wrong :(");
                    scoreD++;
                }

                scoreTextView.setText(scoreU + "/" +scoreD);
                result = randomSum();
                buttons(result);

            }
        };

        View.OnClickListener button1Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp =  String.valueOf(result);

                if(button1.getText().toString().equalsIgnoreCase(temp)){
                    scoreU++;
                    scoreD++;
                    resultTextView.setText("Right :)");
                    resultTextView.setVisibility(View.VISIBLE);

                }else {
                    resultTextView.setVisibility(View.VISIBLE);
                    resultTextView.setText("Wrong :(");
                    scoreD++;
                }

                scoreTextView.setText(scoreU + "/" +scoreD);
                result = randomSum();
                buttons(result);

            }
        };

        View.OnClickListener button2Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp =  String.valueOf(result);

                if(button2.getText().toString().equalsIgnoreCase(temp)){
                    scoreU++;
                    scoreD++;
                    resultTextView.setText("Right :)");
                    resultTextView.setVisibility(View.VISIBLE);

                }else {
                    resultTextView.setVisibility(View.VISIBLE);
                    resultTextView.setText("Wrong :(");
                    scoreD++;
                }

                scoreTextView.setText(scoreU + "/" +scoreD);
                result = randomSum();
                buttons(result);

            }
        };

        View.OnClickListener button3Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp =  String.valueOf(result);

                if(button3.getText().toString().equalsIgnoreCase(temp)){
                    scoreU++;
                    scoreD++;
                    resultTextView.setText("Right :)");
                    resultTextView.setVisibility(View.VISIBLE);

                }else {
                    resultTextView.setVisibility(View.VISIBLE);
                    resultTextView.setText("Wrong :(");
                    scoreD++;
                }

                scoreTextView.setText(scoreU + "/" +scoreD);
                result = randomSum();
                buttons(result);

            }
        };

        button0.setOnClickListener(button0Listener);
        button1.setOnClickListener(button1Listener);
        button2.setOnClickListener(button2Listener);
        button3.setOnClickListener(button3Listener);









    }
}
