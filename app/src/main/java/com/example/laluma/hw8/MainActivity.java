package com.example.laluma.hw8;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private Spinner mSpiItem;
    private EditText mEdtDate;
    private DatePicker mDate;
    private EditText mEdtMoney;
    private Button mBtnInput;
    private Button mBtnRecode;
    private Intent it;

    public ArrayList<HashMap<String,String>> dataList = new ArrayList<>();

    private int number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSpiItem = (Spinner)findViewById(R.id.spi_item);
        mEdtDate = (EditText)findViewById(R.id.edt_date);
        mDate = (DatePicker)findViewById(R.id.date);
        mEdtMoney = (EditText)findViewById(R.id.edt_money);
        mBtnInput = (Button)findViewById(R.id.btn_input);
        mBtnRecode = (Button)findViewById(R.id.btn_record);

        mBtnInput.setOnClickListener(btnInputOnClick);
        mBtnRecode.setOnClickListener(btnRecodeOnClick);
        mDate.setOnDateChangedListener(DateOnchange);
        it = new Intent(this,MediaPlayerService.class);
    }

    private static final int MENU_MUSIC = Menu.FIRST,
            MENU_PLAY_MUSIC = Menu.FIRST + 1,
            MENU_STOP_PLAYING_MUSIC = Menu.FIRST + 2,
            ABOUT = Menu.FIRST + 3,
            EXIT = Menu.FIRST + 4;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SubMenu subMenu = menu.addSubMenu(0,MENU_MUSIC,0,"背景音樂");
        menu.add(0,ABOUT,1,"關於這個程式");
        menu.add(0,EXIT,2,"結束");
        subMenu.add(0,MENU_PLAY_MUSIC,0,"播放背景音樂");
        subMenu.add(0,MENU_STOP_PLAYING_MUSIC,1,"停止播放背景音樂");
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case MENU_PLAY_MUSIC:
                startService(it);
                return true;
            case MENU_STOP_PLAYING_MUSIC:
                stopService(it);
                return true;
            case ABOUT:
                createAlertDialog();
                return true;
            case EXIT:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private final DatePicker.OnDateChangedListener DateOnchange = new DatePicker.OnDateChangedListener() {
        @Override
        public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            String date = year + "/" + (monthOfYear + 1) + "/" + dayOfMonth;
            mEdtDate.setText(date);
        }
    };

    private View.OnClickListener btnInputOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String itemName,date,money,scount;
            number ++;
            scount = String.valueOf(number);
            itemName = mSpiItem.getSelectedItem().toString();
            date = String.valueOf(mDate.getYear()) + "/" + String.valueOf(mDate.getMonth()+1) + "/" + String.valueOf(mDate.getDayOfMonth());
            money = mEdtMoney.getText().toString();
            Toast.makeText(MainActivity.this,money,Toast.LENGTH_SHORT).show();
            HashMap<String,String> hashMap = new HashMap<>();
            hashMap.put("ORDER","項目"+scount);
            hashMap.put("DATE",date);
            hashMap.put("ITEM",itemName);
            hashMap.put("MONEY",money);
            dataList.add(hashMap);
        }
    };
    private View.OnClickListener btnRecodeOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,ItemActivity.class);
            intent.putExtra("LIST",dataList);
            startActivity(intent);
        }
    };
    private void createAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("關於這個程式");
        builder.setMessage("選單範例程式");
        builder.setIcon(R.drawable.picture);
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}

