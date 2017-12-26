package com.example.zxczxcc.fyp2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class generateqr extends Activity {

    EditText text,text2,text3;
    Button button,but;
    ImageView image;
    String text2Qr,name,block,number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generateqr);
        text = (EditText) findViewById(R.id.text);
        text2 = (EditText) findViewById(R.id.text2);
        text3 = (EditText) findViewById(R.id.text3);
        button = (Button) findViewById(R.id.gen_btn);
        but = (Button) findViewById(R.id.button7);
        image = (ImageView) findViewById(R.id.image);
    }
    public void gen(View view)
    {
        text2Qr = text.getText().toString();
        text2Qr += "=" + text2.getText().toString();
        text2Qr += "=" + text3.getText().toString();
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try{
            BitMatrix bitMatrix = multiFormatWriter.encode(text2Qr, BarcodeFormat.QR_CODE,200,200);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            image.setImageBitmap(bitmap);
        }
        catch (WriterException e){
            e.printStackTrace();
        }
        name = text.getText().toString();
        block = text2.getText().toString();
        number = text3.getText().toString();
        String method = "lecdata";
        Bgtask bg = new Bgtask(this);
        bg.execute(method,name,block,number);

    }

    public void savedata(View view)
    {
        startActivity(new Intent(this, mainmenu.class));

    }
}
