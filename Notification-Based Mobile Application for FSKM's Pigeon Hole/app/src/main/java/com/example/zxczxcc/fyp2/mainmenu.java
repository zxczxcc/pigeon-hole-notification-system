package com.example.zxczxcc.fyp2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class mainmenu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);
    }

    public void admail(View view) {startActivity(new Intent(this, addmail.class));}
    public void findp(View view) {
        startActivity(new Intent(this, findposition.class));
    }
    public void genqr(View view) {
        startActivity(new Intent(this, generateqr.class));
    }
    public void dels(View view) {
        startActivity(new Intent(this, delet.class));
    }
    public void asd(View view) {
        startActivity(new Intent(this, addemail.class));
    }
    public void logout(View view) {startActivity(new Intent(this, Login.class));
        finish();}
}
