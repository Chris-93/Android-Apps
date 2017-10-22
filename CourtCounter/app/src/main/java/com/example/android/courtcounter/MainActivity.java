package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int pointsTeamA = 0;
    int pointsTeamB =0;

    //TeamA score system
    public void addThreePointsForTeamA(View v){
        pointsTeamA = pointsTeamA + 3;
        displayForTeamA(pointsTeamA);
    }

    public void addTwoPointsForTeamA(View v){
        pointsTeamA = pointsTeamA + 2;
        displayForTeamA(pointsTeamA);
    }

    public void addFreeThrowPointForTeamA(View v){
        pointsTeamA = pointsTeamA + 1;
        displayForTeamA(pointsTeamA);
    }

    //TeamB score system
    public void addThreePointsForTeamB(View v){
        pointsTeamB = pointsTeamB + 3;
        displayForTeamB(pointsTeamB);
    }

    public void addTwoPointsForTeamB(View v){
        pointsTeamB = pointsTeamB + 2;
        displayForTeamB(pointsTeamB);
    }

    public void addFreeThrowPointForTeamB(View v){
        pointsTeamB = pointsTeamB + 1;
        displayForTeamB(pointsTeamB);
    }



    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    //Reset Button after the end of the game
    public void displayReset(View v){

        pointsTeamA = 0;
        pointsTeamB =0;
        displayForTeamA(pointsTeamA);
        displayForTeamB(pointsTeamB);


    }
}
