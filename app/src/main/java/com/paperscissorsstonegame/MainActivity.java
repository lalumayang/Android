package com.paperscissorsstonegame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTxtComPlay, mTxtResult;
    private Button mBtnScissors, mBtnStone, mBtnPaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTxtComPlay = (TextView)findViewById(R.id.txtComPlay);
        mTxtResult = (TextView)findViewById(R.id.txtResult);
        mBtnScissors = (Button)findViewById(R.id.btnScissors);
        mBtnStone = (Button)findViewById(R.id.btnStone);
        mBtnPaper = (Button)findViewById(R.id.btnPaper);

        mBtnScissors.setOnClickListener(btnOnClick);
        mBtnStone.setOnClickListener(btnOnClick);
        mBtnPaper.setOnClickListener(btnOnClick);
    }

    private View.OnClickListener btnOnClick = new View.OnClickListener() {
        public void onClick(View v) {
            int playerChoice;
            int computerChoice;
            int result;
            if (v.getId() == R.id.btnScissors) {
                playerChoice = 1;
            } else if (v.getId() == R.id.btnStone) {
                playerChoice = 2;
            } else if (v.getId() == R.id.btnPaper) {
                playerChoice = 3;
            } else {
                playerChoice = 0;
            }
            computerChoice=ComputerHandle.getComputerChoice();
            result=ComputerHandle.getResult(playerChoice, computerChoice);
            if(computerChoice == 1){
                mTxtComPlay.setText(getString(R.string.play_scissors));
            }
            else if(computerChoice == 2){
                mTxtComPlay.setText(getString(R.string.play_stone));
            }
            else if(computerChoice == 3){
                mTxtComPlay.setText(getString(R.string.play_paper));
            }
            else{
                mTxtComPlay.setText("");
            }
            if(result == 1 ){
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_win));
            }
            else if(result == 2 ){
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_lose));
            }
            else if(result == 3 ){
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_draw));
            }
            else{
                mTxtResult.setText("");
            }
        }

    };

}
