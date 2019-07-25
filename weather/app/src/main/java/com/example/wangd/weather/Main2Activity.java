package com.example.wangd.weather;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{

    public Button btn_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn_show = findViewById(R.id.btn_show);
        btn_show.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Snackbar.make(view,"hello",Snackbar.LENGTH_SHORT).show();
    }
}
