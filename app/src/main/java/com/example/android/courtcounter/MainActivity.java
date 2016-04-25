package com.example.android.courtcounter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int teamApoints = 0;
    int teamBpoints = 0;

    /*
        Below is the onCreate method which is just what an app needs to be started
        It is similar to a constructor in that it creates the app instance
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Dont worry about this line of code or the function signature, typically it is always this
        super.onCreate(savedInstanceState);
        //This function just means we want to use the layout in our xml file that was created
        // 'R' is like a resource manager
        // when needing to access resources from other file, use R.foldername.filename
        //
        setContentView(R.layout.activity_main);
        displayForTeamA(0);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        //To access text from xml such as the score below
        //You need to create an object of that widget type
        //Then find that widget by the id created in the xml file
        //then type cast it, necessary because return type is of type View, but need TextView
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        //sets text for that textview which changes it onscreen
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Adds 3 points for Team A
     */
    public void addThreeForTeamA(View v)
    {
        teamApoints += 3;
        displayForTeamA(teamApoints);
    }
    public void addTwoForTeamA(View v)
    {
        teamApoints += 2;
        displayForTeamA(teamApoints);
    }
    public void addOneForTeamA(View v)
    {
        teamApoints++;
        displayForTeamA(teamApoints);
    }
    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Adds 3 points for Team B
     */
    public void addThreeForTeamB(View v)
    {
        teamBpoints += 3;
        displayForTeamB(teamBpoints);
    }
    public void addTwoForTeamB(View v)
    {
        teamBpoints += 2;
        displayForTeamB(teamBpoints);
    }
    public void addOneForTeamB(View v)
    {
        teamBpoints++;
        displayForTeamB(teamBpoints);
    }
    public void resetAllScores(View v)
    {
        teamApoints = 0;
        teamBpoints = 0;
        displayForTeamA(teamApoints);
        displayForTeamB(teamBpoints);
    }
}
