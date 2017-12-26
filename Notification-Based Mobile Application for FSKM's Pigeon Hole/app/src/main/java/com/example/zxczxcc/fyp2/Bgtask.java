package com.example.zxczxcc.fyp2;

import android.app.AlertDialog;
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
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by zxczxcc on 22/3/2017.
 */

public class Bgtask extends AsyncTask<String,Void,String> {
    AlertDialog alertDialog,alertDialog2, alertDialog3;
    Context xx;
    Bgtask(Context xx)
    {
        this.xx =xx;

    }

    @Override
    protected void onPreExecute()
    {
        alertDialog = new AlertDialog.Builder(xx).create();
        alertDialog2 = new AlertDialog.Builder(xx).create();
        alertDialog3 = new AlertDialog.Builder(xx).create();
        alertDialog.setTitle("Login Info");
        alertDialog2.setTitle("Position");
        alertDialog3.setTitle("Position already taken");
    }

    @Override
    protected String doInBackground(String... params){

        String reg_url = "http://192.168.8.102/fyp/register.php";
        String login_url = "http://192.168.157.2/fyp/login.php";
        String find_url = "http://192.168.8.102/fyp/find.php";
        String lec_url = "http://192.168.8.102/fyp/lecpos2.php";
        String del_url = "http://192.168.8.102/fyp/delpos.php";
        String method = params[0];
        if(method.equals("register"))
        {
            String name = params[1];
            String user_name = params[2];
            String pass_word = params[3];

            try{
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection )url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
                String data = URLEncoder.encode("user","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"+
                        URLEncoder.encode("user_name","UTF-8")+"="+URLEncoder.encode(user_name,"UTF-8")+"&"+
                        URLEncoder.encode("pass_word","UTF-8")+"="+URLEncoder.encode(pass_word,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();

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

            }catch (MalformedURLException e){e.printStackTrace();} catch (IOException e) {
                e.printStackTrace();
            }

        }

        else if(method.equals("lecdata"))
        {
            String name = params[1];
            String block = params[2];
            String number = params[3];

            try{
                URL url = new URL(lec_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection )url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
                String data = URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"+
                        URLEncoder.encode("block","UTF-8")+"="+URLEncoder.encode(block,"UTF-8")+"&"+
                        URLEncoder.encode("number","UTF-8")+"="+URLEncoder.encode(number,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();

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

            }catch (MalformedURLException e){e.printStackTrace();} catch (IOException e) {
                e.printStackTrace();
            }

        }

        else if (method.equals("login")) {
            String log_name = params[1];
            String log_pass = params[2];

            try {
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data = URLEncoder.encode("log_name","UTF-8")+"="+URLEncoder.encode(log_name,"UTF-8")+"&"+
                        URLEncoder.encode("log_pass","UTF-8")+"="+URLEncoder.encode(log_pass,"UTF-8");

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
        }
        else if (method.equals("findpos")) {
            String lec_name = params[1];

            try {
                URL url = new URL(find_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data = URLEncoder.encode("lec_name","UTF-8")+"="+URLEncoder.encode(lec_name,"UTF-8");

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
        }
        else if (method.equals("delpos")) {
            String lec_name = params[1];

            try {
                URL url = new URL(del_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data = URLEncoder.encode("lec_name","UTF-8")+"="+URLEncoder.encode(lec_name,"UTF-8");

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
        }
        return null;}

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        if(result.equals("Registration done")){Toast.makeText(xx,result,Toast.LENGTH_LONG).show();}
        else
        {
            if(result.contains("success")){
                Intent i = new Intent(xx, mainmenu.class);
                xx.startActivity(i);
            }
            else if (result.equals("data deleted")){Toast.makeText(xx,result,Toast.LENGTH_LONG).show();}
            else if (result.equals("data saved")){Toast.makeText(xx,result,Toast.LENGTH_LONG).show();}
            else if (result.equals("data not found")){Toast.makeText(xx,result,Toast.LENGTH_LONG).show();}
            else if (result.equals("data")){Toast.makeText(xx,result,Toast.LENGTH_LONG).show();}
            else if(result.contains("fail")){
                alertDialog.setMessage(result);
                alertDialog.show();
            }
            else if(result.contains("block")){
                alertDialog2.setMessage(result);
                alertDialog2.show();
            }
            else if(result.contains("cant")){
                alertDialog3.setMessage(result);
                alertDialog3.show();
            }
        }
    }
}