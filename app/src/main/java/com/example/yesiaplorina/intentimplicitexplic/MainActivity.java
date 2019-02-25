package com.example.yesiaplorina.intentimplicitexplic;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.yesiaplorina.intentimplicitexplic.pojo.Orang;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // TODO 1 deklarasi widget yang ingin digunakan

    Button btnMove, btnPassData, btnPassObj, btnTelfon, btnEmail, btnCallBack;

    //TODO 6.7 deklarasi variabel sebagai key untuk request datanya
    public static final int REQUEST_CODE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO 2 casting view / hubungkan dengan idnya masing-masing

        btnMove = findViewById(R.id.btn_move);
        btnPassData = findViewById(R.id.btn_passing_data);
        btnPassObj = findViewById(R.id.btn_passing_object);
        btnTelfon = findViewById(R.id.btn_implicit_telpon);
        btnEmail = findViewById(R.id.btn_implicit_email);
        btnCallBack = findViewById(R.id.btn_call_back);

        // TODO 3 button melakukan sebuah aksi / even click listener

        btnMove.setOnClickListener(this);
        btnPassData.setOnClickListener(this);
        btnPassObj.setOnClickListener(this);
        btnTelfon.setOnClickListener(this);
        btnEmail.setOnClickListener(this);
        btnCallBack.setOnClickListener(this);

        /** btnMove.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {

         *//**
         * buat object intent
         * parameter 1= activitiy asal
         * parameter 2= aktivity tujuan
         * *//*

                Intent move = new Intent(MainActivity.this, MoveIntent.class);
                startActivity(move);
            }
        });*/
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_move:
                pindah();
                break;

            case R.id.btn_passing_data:
                passData();
                break;

            case R.id.btn_call_back:
                intentCallBack();
                break;

            case R.id.btn_implicit_email:
                implicitEmail();
                break;

            case R.id.btn_passing_object:
                passObj();
                break;

            case R.id.btn_implicit_telpon:
                implicitCall();
                break;
        }
    }

    private void intentCallBack() {
        //TODO 6.6
        Intent callBack = new Intent(MainActivity.this, CallBack.class);
        startActivityForResult(callBack, REQUEST_CODE);
    }

    //TODO 6.8 kita kasih perbandingan

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //perbadingan
        if (requestCode==REQUEST_CODE){
            if(resultCode==RESULT_OK){
                //get datanya
                String getData= data.getStringExtra(CallBack.EXTRA_CALL_BACK);

                //show datanta dalam toast
                Toast.makeText(this,getData, Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void implicitEmail() {
        //TODO 5.1
        /**
         *
         * */

        Intent email = new Intent(Intent.ACTION_SENDTO,
                Uri.fromParts("mailto",
                        "kimyesiahyera@gmail.com",
                        null));

        //kirim data ke email
        email.putExtra(Intent.EXTRA_SUBJECT,"Ini Subject loh");
        email.putExtra(Intent.EXTRA_TEXT,"Ini text loh");

        //cek jika device ada opsi share client
        if (email.resolveActivity(getPackageManager())!= null){
            startActivity(Intent.createChooser(email,"Pilih Email Client"));
        }else Toast.makeText(this, "Tidak Ada Email Client", Toast.LENGTH_SHORT).show();
    }

    private void implicitCall() {
        // TODO 4.1
        /**
         * tell adalah skema kesepakatan di android untuk telpon api
         * */
        Intent call = new Intent(Intent.ACTION_DIAL);
        call.setData(Uri.parse("tel:082159893068"));
        startActivity(call);
    }

    private void passObj() {
        //TODO 3.3 buat oject dari kelas orang
        Orang objOrg = new Orang();
        objOrg.setName("Yesia");
        objOrg.setAsal("Labuhan");
        objOrg.setTinggal("Lampau");
        objOrg.setPekerjaan("Nonton Drakor");
        objOrg.setAge(24);

        //TODO 3.7 kirim data
        Intent passObj = new Intent(MainActivity.this, PassingObject.class);
        passObj.putExtra(PassingObject.EXTRA_OBJECT, objOrg);
        startActivity(passObj);
    }

    private void passData() {
        Intent passData = new Intent(MainActivity.this, PassingData.class);
        /**untuk method send data
         * ada 2 parameter
         * 1. key/variabel penampung
         * 2. value yang mau dikirm
         * */
        //TODO 2.1
        passData.putExtra(PassingData.EXTRA_NAME, "Yesia");
        passData.putExtra(PassingData.EXTRA_AGE, 25);
        startActivity(passData);
    }

    private void pindah() {
        //TODO 1
        Intent pindahan = new Intent(MainActivity.this, MoveIntent.class);
        startActivity(pindahan);
    }


}
