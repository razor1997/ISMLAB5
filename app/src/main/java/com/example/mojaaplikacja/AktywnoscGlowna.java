package com.example.mojaaplikacja;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class AktywnoscGlowna extends ListActivity {

    private final String COL0_NAME = "image";
    private final String COL1_NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.); <- Teraz tego nie ma
        //Zrobienie listy map dla adaptera
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        for (int i = 0; i < MainActivity.SIZE; i++) {
            //
            HashMap<String, String> hashMap = new HashMap<>();
            int id = MainActivity.IMAGE.getResourceId(i, 0);
            hashMap.put(COL0_NAME, Integer.toString(id));
            hashMap.put(COL1_NAME, MainActivity.NAME[i]);
            arrayList.add(hashMap);
        }
        //Zrobienie adaptera
        String[] from = {COL0_NAME, COL1_NAME};
        int[] to = {R.id.row_image, R.id.row_name};
        SimpleAdapter simpleAdapter =
                new SimpleAdapter(this, arrayList, R.layout.row_table, from, to);
        //Podlaczenie adaptera
        setListAdapter(simpleAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        //super.onListItemClick(l, v, position, id);
        Intent intent = new Intent(this, AktywnoscOpis.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }
}