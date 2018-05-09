package com;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gameusingdynamicfragment.R;

public class ResultActivity extends AppCompatActivity {
    private EditText mEdtCountSet,
                     mEdtCountPlayerWin,
                     mEdtCountComWin,
                     mEdtCountDraw;
    private Button mBtnClose;
    private int miCountSet = 0,
            miCountPlayerWin = 0,
            miCountComWin = 0,
            miCountDraw = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_result);


        mEdtCountSet = (EditText)findViewById(R.id.edtCountSet);
        mEdtCountPlayerWin = (EditText)findViewById(R.id.edtCountPlayerWin);
        mEdtCountComWin = (EditText)findViewById(R.id.edtCountComWin);
        mEdtCountDraw = (EditText)findViewById(R.id.edtCountDraw);
        mBtnClose=(Button)findViewById(R.id.btnClose);

        mBtnClose.setOnClickListener(btnCallBackOnClick);

        showResult();
    }

    private View.OnClickListener btnCallBackOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };

    private void showResult(){
        Bundle bundle = this.getIntent().getExtras();

        miCountSet = bundle.getInt("KeyCountSet");
        miCountPlayerWin = bundle.getInt("KeyCountPlayerWin");
        miCountComWin = bundle.getInt("KeyCountComWin");
        miCountDraw = bundle.getInt("KeyCountDraw");

        mEdtCountSet.setText(Integer.toString(miCountSet));
        mEdtCountPlayerWin.setText(Integer.toString(miCountPlayerWin));
        mEdtCountComWin.setText(Integer.toString(miCountComWin));
        mEdtCountDraw.setText(Integer.toString(miCountDraw));
    }
}