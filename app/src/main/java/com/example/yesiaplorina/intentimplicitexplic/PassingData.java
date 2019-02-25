package com.example.yesiaplorina.intentimplicitexplic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PassingData extends AppCompatActivity {

    //TODO 2.2 deklarasi
    TextView tvDataReceived;

    //TODO 2.3 deklarasi widget yg ingin digunakan

    public static final String EXTRA_NAME = "NAME";
    public static final String EXTRA_AGE = "AGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_data);

        // TODO 2.4 cassing view/ hub dgn idnya
        tvDataReceived = findViewById(R.id.tv_data_received);

        //TODO 2.5 method untuk menerima datanya
        getDataRecieved();


    }

    private void getDataRecieved() {

        //TODO 2.6 get datanya sesuai dengan type data yang dikirm
        String name = getIntent().getStringExtra(EXTRA_NAME);
        int age = getIntent().getIntExtra(EXTRA_AGE,0);

        //TODO 2.7 show kedalam text view
        tvDataReceived.setText("Name : "+ name + "\n Age "+age);

    }
}
