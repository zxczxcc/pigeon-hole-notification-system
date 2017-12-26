package com.example.zxczxcc.fyp2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void user_login (View view){startActivity(new Intent(this,Login.class));}
    public void user_reg (View view){startActivity(new Intent(this,register.class));}
}
