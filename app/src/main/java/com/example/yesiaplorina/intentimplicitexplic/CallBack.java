package com.example.yesiaplorina.intentimplicitexplic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CallBack extends AppCompatActivity {

    //TODO 6.1
    Button btnDetailCallBack;
    public static final String EXTRA_CALL_BACK = "EXTRA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_back);

        //TODO 6.2
        btnDetailCallBack = findViewById(R.id.btn_detail_call_back);

        //TODO 6.3
        btnDetailCallBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent data = new Intent();
                data.putExtra(EXTRA_CALL_BACK, "Ini Call Back");

                //TODO set hasilnya ke RESULT_OK
                setResult(RESULT_OK, data);

                //TODO tutup aktivity saat ini
                finish();

            }
        });
    }
}
