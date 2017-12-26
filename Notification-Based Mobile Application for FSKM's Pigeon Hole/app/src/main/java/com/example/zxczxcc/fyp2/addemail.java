package com.example.zxczxcc.fyp2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class addemail extends Activity {

    EditText et_lecname, et_lecemail;
    String lec_name, lec_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addemail);
        et_lecname = (EditText) findViewById(R.id.editText);
        et_lecemail = (EditText) findViewById(R.id.editText2);
    }

    public void mail(View view) {
        lec_name = et_lecname.getText().toString();
        lec_email = et_lecemail.getText().toString();
        tak bg = new tak(this);
        bg.execute(lec_name, lec_email);

    }

    public void back(View view) {
        startActivity(new Intent(this, mainmenu.class));
    }
}