package com.example.zxczxcc.fyp2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Login extends Activity {
    EditText et_username, et_password;
    String login_name,login_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_username = (EditText)findViewById(R.id.username);
        et_password = (EditText)findViewById(R.id.password);
    }

    public void log_submit(View view)
    {
        login_name = et_username.getText().toString();
        login_pass = et_password.getText().toString();
        String method = "login";
        Bgtask bg = new Bgtask(this);
        bg.execute(method,login_name,login_pass);

    }
}
