package com.arya.kebututs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Act2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act2);

        ListView list = findViewById(R.id.list_kegiatan);
        Button btnPindah = findViewById(R.id.btnPindah);

        btnPindah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent halaman3 = new Intent(Act2.this, Act3.class);
                startActivity(halaman3);
            }
        });

        String[] listKegiatan = new String[]{
                "Belanja","Olahraga","Tidur","Maingame","Pura Pura Ngoding","Belanja","Olahraga","Tidur","Maingame","Pura Pura Ngoding","Belanja","Olahraga","Tidur","Maingame","Pura Pura Ngoding"
        };

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listKegiatan);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int p, long l) {
                Toast.makeText(getApplicationContext(),
                        "ID" + p +
                                "\n" + "Judul: " +listKegiatan[p],
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}