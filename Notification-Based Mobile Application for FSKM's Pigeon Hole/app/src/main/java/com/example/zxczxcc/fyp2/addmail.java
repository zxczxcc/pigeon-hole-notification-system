package com.example.zxczxcc.fyp2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.zxing.Result;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class addmail extends Activity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView ms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addmail);
    }
    public void backqr(View view) {startActivity(new Intent(this, mainmenu.class));}

    public void try2(View v) {
        ms = new ZXingScannerView(this);
        setContentView(ms);
        ms.setResultHandler(this);
        ms.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        ms.stopCamera();
    }

    @Override
    public void handleResult(Result result){
//        Log.v("handleResult",result.getText());
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Scan Result");
//        builder.setMessage(result.getText());
//        AlertDialog alertDialog = builder.create();
//        alertDialog.show();
        String trying  = result.getText();
        String s = trying;
        String[] words = s.split("=");
        emailtask bg = new emailtask(this);
        bg.execute(words[0]);


        //ms.resumeCameraPreview(this);
    }
}
