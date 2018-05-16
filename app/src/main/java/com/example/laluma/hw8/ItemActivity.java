package com.example.laluma.hw8;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;



public class ItemActivity extends AppCompatActivity {

    ListView mLsvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        Intent intent = getIntent();
        ArrayList<HashMap<String,String>> list = (ArrayList<HashMap<String, String>>) intent.getSerializableExtra("LIST");
        ArrayList<String> show = new ArrayList<String>();
        for(int i = 0; i < list.size(); i++){
            HashMap<String,String> hashMap = list.get(i);
            show.add(hashMap.get("ORDER") + "    " + hashMap.get("DATE") + "    " + hashMap.get("ITEM") + "    " + hashMap.get("MONEY") + "\n");
        }
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,show.toArray());
        mLsvList = findViewById(R.id.lsvList);
        mLsvList.setAdapter(adapter);
    }
}