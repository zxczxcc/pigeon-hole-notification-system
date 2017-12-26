package com.example.zxczxcc.fyp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class confirmation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
    }

    public void bac(View view) {startActivity(new Intent(this, mainmenu.class));}
    public void nex(View view) {
        startActivity(new Intent(this, addmail.class));
    }
}
