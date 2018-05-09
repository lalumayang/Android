package com;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.gameusingdynamicfragment.R;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {

    private ImageView mImgDice;
    private Button mBtnDice,mBtnResult;
    private int miCountSet = 0,
            miCountPlayerWin = 0,
            miCountComWin = 0,
            miCountDraw = 0;
    public static Context sContext;

    private static class StaticHandler extends Handler {
        private final WeakReference<MainActivity> mActivity;

        public StaticHandler(MainActivity activity) {
            mActivity = new WeakReference<MainActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            MainActivity activity = mActivity.get();
            if (activity == null) return;

            int iRand = (int)(Math.random()*6 + 1);
            activity.miCountSet ++;
            switch (iRand) {
                case 1:
                    activity.mImgDice.setImageResource(R.drawable.dice01);
                    Toast.makeText(activity.sContext, "user win", Toast.LENGTH_LONG).show();
                    activity.miCountPlayerWin++;
                    break;
                case 2:
                    activity.mImgDice.setImageResource(R.drawable.dice02);
                    Toast.makeText(activity.sContext, "user win", Toast.LENGTH_LONG).show();
                    activity.miCountPlayerWin++;
                    break;
                case 3:
                    activity.mImgDice.setImageResource(R.drawable.dice03);
                    Toast.makeText(activity.sContext, "draw", Toast.LENGTH_LONG).show();
                    activity.miCountDraw++;
                    break;
                case 4:
                    activity. mImgDice.setImageResource(R.drawable.dice04);
                    Toast.makeText(activity.sContext, "draw", Toast.LENGTH_LONG).show();
                    activity.miCountDraw++;
                    break;
                case 5:
                    activity.mImgDice.setImageResource(R.drawable.dice05);
                    Toast.makeText(activity.sContext, "computer win", Toast.LENGTH_LONG).show();
                    activity.miCountComWin++;
                    break;
                case 6:
                    activity. mImgDice.setImageResource(R.drawable.dice06);
                    Toast.makeText(activity.sContext, "computer win", Toast.LENGTH_LONG).show();
                    activity.miCountComWin++;
                    break;
            }
        }
    }

    public final MainActivity.StaticHandler mHandler = new MainActivity.StaticHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImgDice = (ImageView)findViewById(R.id.imgRollingDice);
        mBtnDice = (Button)findViewById(R.id.btnDice);
        mBtnResult = (Button)findViewById(R.id.btnResult);
        sContext = MainActivity.this;

        mBtnDice.setOnClickListener(btnDiceOnClick);
        mBtnResult.setOnClickListener(btnResultOnClick);
    }

    private View.OnClickListener btnDiceOnClick = new View.OnClickListener() {
        public void onClick(View v) {
            // Decide computer play.
            Resources res = getResources();
            final AnimationDrawable animDraw = (AnimationDrawable) res.getDrawable(R.drawable.anim_roll_dice);
            mImgDice.setImageDrawable(animDraw);
            animDraw.start();

            new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    animDraw.stop();
                    mHandler.sendMessage(mHandler.obtainMessage());
                }
            }).start();
        }
    };

    private View.OnClickListener btnResultOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent it = new Intent();
            it.setClass(MainActivity.this, ResultActivity.class);

            Bundle bundle = new Bundle();
            bundle.putInt("KeyCountSet", miCountSet);
            bundle.putInt("KeyCountPlayerWin", miCountPlayerWin);
            bundle.putInt("KeyCountComWin", miCountComWin);
            bundle.putInt("KeyCountDraw", miCountDraw);
            it.putExtras(bundle);
            startActivity(it);

        }
    };


}
