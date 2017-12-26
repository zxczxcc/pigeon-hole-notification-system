package com.example.zxczxcc.fyp2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class delet extends Activity {
    EditText et_lecname;
    String lec_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delet);
        et_lecname = (EditText)findViewById(R.id.editText);
    }

    public void delpos(View view)
    {
        lec_name = et_lecname.getText().toString();
        String method = "delpos";
        Bgtask bg = new Bgtask(this);
        bg.execute(method,lec_name);

    }

    public void back(View view) {
        startActivity(new Intent(this, mainmenu.class));
    }
}
