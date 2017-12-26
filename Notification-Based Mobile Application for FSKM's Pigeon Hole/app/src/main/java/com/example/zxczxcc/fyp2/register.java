package com.example.zxczxcc.fyp2;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class register extends Activity {
    EditText et_name, et_username, et_password;
    String name,user_name,pass_word;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_name = (EditText)findViewById(R.id.regname);
        et_username = (EditText)findViewById(R.id.reguser);
        et_password = (EditText)findViewById(R.id.regpass);
    }

    public void reg_submit(View view)
    {
        name = et_name.getText().toString();
        user_name = et_username.getText().toString();
        pass_word = et_password.getText().toString();
        String method = "register";
        Bgtask bg = new Bgtask(this);
        bg.execute(method,name,user_name,pass_word);
        finish();

    }
}
