package com.example.zxczxcc.fyp2;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by zxczxcc on 30/5/2017.
 */

public class emailtask extends AsyncTask<String,Void,String> {

    Context xx;
    emailtask(Context xx)
    {
        this.xx =xx;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        String email_url = "http://192.168.8.102/fyp/email.php";
            String namee = params[0];

            try {
                URL url = new URL(email_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data = URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(namee,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String respond = "";
                String line = "";

                while ((line = bufferedReader.readLine())!=null)
                {
                    respond += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return respond;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
    return null;}

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        if(result.contains("success")){
            String s = result;
            String[] words = s.split("=");
            String de = "trytestfyp@gmail.com";
            String se = "you have receive mail in the pigeon hole";
            sendmail sm = new sendmail(xx, words[1], de);
            sm.execute();
            if (words[2].equals("null")){}
            else{sendmail qw = new sendmail(xx, se, words[2]);
                qw.execute();}
            Intent i = new Intent(xx, confirmation.class);
            xx.startActivity(i);}
         else if(result.equals("xjadi")){
        Intent i = new Intent(xx, failcorm.class);
        xx.startActivity(i);}
        else
        {Toast.makeText(xx,result,Toast.LENGTH_LONG).show();
            Intent i = new Intent(xx, mainmenu.class);
            xx.startActivity(i);
        }
    }
}
