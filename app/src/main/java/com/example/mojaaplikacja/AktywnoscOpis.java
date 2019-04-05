package com.example.mojaaplikacja;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;


public class AktywnoscOpis extends AppCompatActivity {

    TextView nazwa, opis;
    ImageView obraz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_aktywnosc_opis);
        nazwa = (TextView) findViewById(R.id.nazwa);
        opis = (TextView) findViewById(R.id.opis);
        obraz = (ImageView) findViewById(R.id.obraz);

        int id = (int) getIntent().getLongExtra("id", 0);

        nazwa.setText(MainActivity.NAME[id]);
        opis.setText(MainActivity.DESCRIPTION[id]);
        obraz.setImageResource(MainActivity.IMAGE.getResourceId(id, 0));
    }
}
