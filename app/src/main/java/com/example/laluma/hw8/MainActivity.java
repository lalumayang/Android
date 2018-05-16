package com.example.laluma.hw8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

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
    }

    private final DatePicker.OnDateChangedListener DateOnchange = new DatePicker.OnDateChangedListener() {
        @Override
        public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            String date = year + "/" + (monthOfYear + 1) + "/" + dayOfMonth;
            mEdtDate.setText(date);
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

}

