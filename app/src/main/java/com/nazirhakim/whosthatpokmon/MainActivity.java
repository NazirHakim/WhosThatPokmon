package com.nazirhakim.whosthatpokmon;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class MainActivity extends AppCompatActivity {

    ImageView image1, image2, image3, image4, imageMain;
    TextView tv_status;
    Button b_next;

    private AdView mAdView;

    // List of colored images
    Integer[] images = {
            R.drawable.animal_1,
            R.drawable.animal_2,
            R.drawable.animal_3,
            R.drawable.animal_4,
            R.drawable.animal_5,
            R.drawable.animal_6,
            R.drawable.animal_7,
            R.drawable.animal_8,
            R.drawable.animal_9,
            R.drawable.animal_10,
            R.drawable.animal_11,
            R.drawable.animal_12,
            R.drawable.animal_13,
            R.drawable.animal_14,
            R.drawable.animal_15,
            R.drawable.animal_16,
            R.drawable.animal_17,
            R.drawable.animal_18,
            R.drawable.animal_19,
            R.drawable.animal_20,
            R.drawable.animal_21,
            R.drawable.animal_22,


    };

    // List of Shadow images
    Integer[] images_bw = {
            R.drawable.animal_bw_1,
            R.drawable.animal_bw_2,
            R.drawable.animal_bw_3,
            R.drawable.animal_bw_4,
            R.drawable.animal_bw_5,
            R.drawable.animal_bw_6,
            R.drawable.animal_bw_7,
            R.drawable.animal_bw_8,
            R.drawable.animal_bw_9,
            R.drawable.animal_bw_10,
            R.drawable.animal_bw_11,
            R.drawable.animal_bw_12,
            R.drawable.animal_bw_13,
            R.drawable.animal_bw_14,
            R.drawable.animal_bw_15,
            R.drawable.animal_bw_16,
            R.drawable.animal_bw_17,
            R.drawable.animal_bw_18,
            R.drawable.animal_bw_19,
            R.drawable.animal_bw_20,
            R.drawable.animal_bw_21,
            R.drawable.animal_bw_22,

    };

    //List of numbers for all of the images / currently 22 images
    Integer[] images_numbers = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21};

    int turn = 1;
    int correctAnswer = 0;
    int score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        image1 = (ImageView) findViewById(R.id.image1);
        image2 = (ImageView) findViewById(R.id.image2);
        image3 = (ImageView) findViewById(R.id.image3);
        image4 = (ImageView) findViewById(R.id.image4);
        imageMain = (ImageView) findViewById(R.id.imageMain);

        tv_status = (TextView) findViewById(R.id.tv_status);

        b_next = (Button) findViewById(R.id.b_next);

        //random shuffle the images
        Collections.shuffle(Arrays.asList(images_numbers));

        //set image on the screen
        setImages();

        //clicks
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check if correct or wrong
                if(correctAnswer == 1){
                    score++;
                    tv_status.setText("Correct!");
                    b_next.setVisibility(View.VISIBLE);
                } else {
                    tv_status.setText("Wrong!");
                    b_next.setVisibility(View.VISIBLE);
                }

                //disable images
                image1.setEnabled(false);
                image2.setEnabled(false);
                image3.setEnabled(false);
                image4.setEnabled(false);

            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check if correct or wrong
                if(correctAnswer == 2){
                    score++;
                    tv_status.setText("Correct!");
                    b_next.setVisibility(View.VISIBLE);
                } else {
                    tv_status.setText("Wrong!");
                    b_next.setVisibility(View.VISIBLE);
                }

                //disable images
                image1.setEnabled(false);
                image2.setEnabled(false);
                image3.setEnabled(false);
                image4.setEnabled(false);

            }
        });
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check if correct or wrong
                if(correctAnswer == 3){
                    score++;
                    tv_status.setText("Correct!");
                    b_next.setVisibility(View.VISIBLE);
                } else {
                    tv_status.setText("Wrong!");
                    b_next.setVisibility(View.VISIBLE);
                }

                //disable images
                image1.setEnabled(false);
                image2.setEnabled(false);
                image3.setEnabled(false);
                image4.setEnabled(false);

            }
        });
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check if correct or wrong
                if(correctAnswer == 4){
                    score++;
                    tv_status.setText("Correct!");
                    b_next.setVisibility(View.VISIBLE);
                } else {
                    tv_status.setText("Wrong!");
                    b_next.setVisibility(View.VISIBLE);
                }

                //disable images
                image1.setEnabled(false);
                image2.setEnabled(false);
                image3.setEnabled(false);
                image4.setEnabled(false);

            }
        });

        b_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //increase the turn and finish the game if 10 turns are passed
                turn++;
                if (turn == 11){
                    checkEnd();
                } else {
                    setImages();
                }
            }
        });
    }

    private void setImages(){
        // determine which is the correct answer 1-4
        Random r = new Random();
        correctAnswer = r.nextInt(4) + 1;

        //generate randowm wrong answers
        int wrongAnswer1, wrongAnswer2, wrongAnswer3;

        do{
            wrongAnswer1 = r.nextInt(22);

        } while (wrongAnswer1 == images_numbers[turn]);

        do{
            wrongAnswer2 = r.nextInt(22);

        } while (wrongAnswer2 == images_numbers[turn] || wrongAnswer2 == wrongAnswer1);

        do{
            wrongAnswer3 = r.nextInt(22);

        } while (wrongAnswer3 == images_numbers[turn] || wrongAnswer3 == wrongAnswer2 || wrongAnswer3 == wrongAnswer1);

        // set images for all answer
        switch (correctAnswer){
            case 1:
                image1.setImageResource(images[images_numbers[turn]]);
                image2.setImageResource(images[wrongAnswer1]);
                image3.setImageResource(images[wrongAnswer2]);
                image4.setImageResource(images[wrongAnswer3]);
                break;
            case 2:
                image1.setImageResource(images[wrongAnswer1]);
                image2.setImageResource(images[images_numbers[turn]]);
                image3.setImageResource(images[wrongAnswer2]);
                image4.setImageResource(images[wrongAnswer3]);
                break;
            case 3:
                image1.setImageResource(images[wrongAnswer1]);
                image2.setImageResource(images[wrongAnswer2]);
                image3.setImageResource(images[images_numbers[turn]]);
                image4.setImageResource(images[wrongAnswer3]);
                break;
            case 4:
                image1.setImageResource(images[wrongAnswer1]);
                image2.setImageResource(images[wrongAnswer2]);
                image3.setImageResource(images[wrongAnswer3]);
                image4.setImageResource(images[images_numbers[turn]]);
                break;
        }

        //set image for the question
        imageMain.setImageResource(images_bw[images_numbers[turn]]);

        //null stuff
        tv_status.setText("");
        b_next.setVisibility(View.INVISIBLE);

        image1.setEnabled(true);
        image2.setEnabled(true);
        image3.setEnabled(true);
        image4.setEnabled(true);

    }

    private void checkEnd(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setMessage("Game Over! Score: " + score);
        alertDialogBuilder.setPositiveButton("Quit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //exit the game
                finish();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
