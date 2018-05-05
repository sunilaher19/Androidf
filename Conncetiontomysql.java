package com.example.zeus.loginpage;


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import java.io.BufferedOutputStream;
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
import android.content.Intent;
/**
 * Created by Zeus on 4/28/2018.
 */

public class Conncetiontomysql extends  AsyncTask<String , Void , String>   {
    Context context;
    AlertDialog alert;
    Conncetiontomysql(Context con)
    {
        context = con;
    }
    @Override
    protected String doInBackground(String... params){
        String type = params[0];
        String result = "" ;
        String line = "";
        if(type.equals("login"))
        {

            String Login_url = "http://192.168.1.4/android_connect/select.php";
        try {
            String usr = params[1];
            String pass = params[2];
            URL url = new URL(Login_url);
            HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
            httpcon.setRequestMethod("POST");
            httpcon.setDoOutput(true);
            httpcon.setDoInput(true);
            OutputStream out = httpcon.getOutputStream();
            BufferedWriter bwriter = new BufferedWriter(new OutputStreamWriter(out,"UTF-8"));
            String postData = URLEncoder.encode("usr","UTF-8")+"="+URLEncoder.encode(usr,"UTF-8")+"&"
                    +URLEncoder.encode("pass","UTF-8")+"="+URLEncoder.encode(pass,"UTF-8");
            bwriter.write(postData);
            bwriter.flush();
            bwriter.close();
            out.close();
            InputStream input = httpcon.getInputStream();
            BufferedReader buffer = new BufferedReader(new InputStreamReader(input,"iso-8859-1"));

            while((line = buffer.readLine())!= null)
            {
                result+=line;
            }
            buffer.close();
            input.close();
            httpcon.disconnect();
            return result;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }else if(type.equals("Insert")) {

        }else if(type.equals("signUp"))
        {
            String Login_url = "http://192.168.1.4/android_connect/InsertData.php";
            try {
                String usr = params[1];
                String pass = params[2];
                String Q1 = params[3];
                String Q2 = params[4];
                URL url = new URL(Login_url);
                HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
                httpcon.setRequestMethod("POST");
                httpcon.setDoOutput(true);
                httpcon.setDoInput(true);
                OutputStream out = httpcon.getOutputStream();
                BufferedWriter bwriter = new BufferedWriter(new OutputStreamWriter(out,"UTF-8"));
                String postData = URLEncoder.encode("usr","UTF-8")+"="+URLEncoder.encode(usr,"UTF-8")+"&"
                        +URLEncoder.encode("pass","UTF-8")+"="+URLEncoder.encode(pass,"UTF-8") + "&"
                        +URLEncoder.encode("Q1","UTF-8")+"="+URLEncoder.encode(Q1,"UTF-8")  + "&"
                        +URLEncoder.encode("Q2","UTF-8")+"="+URLEncoder.encode(Q2,"UTF-8");
                bwriter.write(postData);
                bwriter.flush();
                bwriter.close();
                out.close();
                InputStream input = httpcon.getInputStream();
                BufferedReader buffer = new BufferedReader(new InputStreamReader(input,"iso-8859-1"));

                while((line = buffer.readLine())!= null)
                {
                    result+=line;
                }
                buffer.close();
                input.close();
                httpcon.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }



    @Override
    protected void onPreExecute() {
        alert= new AlertDialog.Builder(context).create();
        alert.setTitle("Hello Pre effect");
            }

    @Override
    protected void onPostExecute(String result) {
        //alert.setMessage(result);
        //alert.setTitle("Hello After effect" + result );
        //alert.show();

        if(result.contains("Login suceed")) // msg you get from success like "Login Success"
        {

            if(result.contains("Admin"))
            {
                Intent i = new Intent(context,adminFunction.class);
                context.startActivity(i);
                alert.setMessage(result);
            }
            else
            {
                Intent i = new Intent(context,userFunction.class);
                context.startActivity(i);
                alert.setMessage(result);
            }
        }else if(result.contains("successfully"))
        {
            alert.setMessage(result);
            alert.setTitle("Hello After data " + result );
            alert.show();
        }


    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}

