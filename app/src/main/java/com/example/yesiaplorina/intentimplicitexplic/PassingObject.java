package com.example.yesiaplorina.intentimplicitexplic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.yesiaplorina.intentimplicitexplic.pojo.Orang;

public class PassingObject extends AppCompatActivity {

    //TODO 3.4 deklarasi text view
    TextView tvDataObjectReceived;

    //TODO 3.5 deklarasi variabel sebagai menampung
    public static final String EXTRA_OBJECT = "OBJECT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_object);

        //TODO 3.6 cassing view/hub dng idnya
        tvDataObjectReceived = findViewById(R.id.tv_data_obj_received);

        //TODO 3.8 get datanya dengan parcelable
        Orang get = getIntent().getParcelableExtra(EXTRA_OBJECT);
        tvDataObjectReceived.setText("Nama : " + get.getName()
                + "\n Asal : " + get.getAsal()
                + "\n Tinggal : " + get.getTinggal()
                + "\n Pekerjaan : " + get.getPekerjaan()
                + "\n Umur : " + get.getAge());
    }
}
