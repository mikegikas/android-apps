package com.example.android.footballcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int foulForTeamA = 0;
    int foulForTeamB = 0;
    int penaltyForTeamA = 0;
    int penaltyForTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Increase the score for Team A by 3.
     */
    public void addGoalForTeamA (View view){
        scoreTeamA += 1;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Increase the score for Team B by 3.
     */
    public void addGoalForTeamB (View view){
        scoreTeamB += 1;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Increase the foul for Team A by 1.
     */
    public void addFoulForTeamA (View view){
        foulForTeamA += 1;
        displayFoulForTeamA(foulForTeamA);
    }

    /**
     * Displays the given foul for Team A
     */
    public void displayFoulForTeamA (int foul) {
        TextView foulView = (TextView) findViewById(R.id.team_a_foul);
        foulView.setText(String.valueOf(foul));
    }

    /**
     * Increase the foul for Team B by 1.
     */
    public void addFoulForTeamB (View view){
        foulForTeamB += 1;
        displayFoulForTeamB(foulForTeamB);
    }

    /**
     * Displays the given foul for Team B
     */
    public void displayFoulForTeamB (int foul) {
        TextView foulView = (TextView) findViewById(R.id.team_b_foul);
        foulView.setText(String.valueOf(foul));
    }

    /**
     * Increase the penalty for Team A by 1.
     */
    public void addPenaltyForTeamA (View view){
        penaltyForTeamA += 1;
        displayPenaltyForTeamA(penaltyForTeamA);
    }

    /**
     * Displays the given penalty for Team A
     */
    public void displayPenaltyForTeamA (int penalty) {
        TextView penaltyView = (TextView) findViewById(R.id.team_a_penalty);
        penaltyView.setText(String.valueOf(penalty));
    }

    /**
     * Increase the penalty for Team B by 1.
     */
    public void addPenaltyForTeamB (View view){
        penaltyForTeamB += 1;
        displayPenaltyForTeamB(penaltyForTeamB);
    }

    /**
     * Displays the given penalty for Team A
     */
    public void displayPenaltyForTeamB (int penalty) {
        TextView penaltyView = (TextView) findViewById(R.id.team_b_penalty);
        penaltyView.setText(String.valueOf(penalty));
    }

    public void resetScore(View view){
        scoreTeamA = 0;
        scoreTeamB = 0;
        foulForTeamA = 0;
        foulForTeamB = 0;
        penaltyForTeamA = 0;
        penaltyForTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayFoulForTeamA(foulForTeamA);
        displayFoulForTeamB(foulForTeamB);
        displayPenaltyForTeamA(penaltyForTeamA);
        displayPenaltyForTeamB(penaltyForTeamB);
    }
}
