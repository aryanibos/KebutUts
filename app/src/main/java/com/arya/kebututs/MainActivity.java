package com.arya.kebututs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spin1 = findViewById(R.id.listItem);
        Button btnAmbil = findViewById(R.id.submit);
        TextView txtNama = findViewById(R.id.data_nama);
        Button btnpindah = findViewById(R.id.btnpindah);
        Button btnListener = findViewById(R.id.btn_listener_interfaces);




//      terkait spinner
        List<String> ListNama = new ArrayList<String>();
        ListNama.add("Usman");
        ListNama.add("Usro");

        String[] arrayBaru = getResources().getStringArray(R.array.nama);

        ListNama.addAll(Arrays.asList(arrayBaru));

//        tugas gabungin array dr string dan dari sini(javanya)
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,ListNama);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(adapter);

//      terkait event handler utk btnAmbil
        btnAmbil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = spin1.getSelectedItem().toString();
                txtNama.setText(nama);

                Toast.makeText(MainActivity.this, "Anda Mengambil Id : " + spin1.getSelectedItemId(),
                        Toast.LENGTH_SHORT).show();
//                Toast.makeText(Act3.this, "Position : " + spin1.getSelectedItemPosition(),
//                        Toast.LENGTH_SHORT).show();
            }
        });

        btnpindah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent halaman2 = new Intent(MainActivity.this, Act2.class);
                startActivity(halaman2);
                finish();
            }
        });

        btnListener.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        String label = ((Button) view).getText().toString();
        Toast.makeText(this, "Anda Menekan Tombol"+ label, Toast.LENGTH_SHORT).show();
    }

    public void pencet(View view) {
        Toast.makeText(this, "Anda Menekan Tombol Pencet", Toast.LENGTH_SHORT).show();
    }
}