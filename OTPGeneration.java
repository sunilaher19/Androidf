package com.example.zeus.loginpage;

/**
 * Created by Zeus on 5/4/2018.
 */

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.textservice.TextInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.security.SecureRandom;

public class OTPGeneration extends AppCompatActivity {

    int number;
    int length = 4;
    int range = 9;
    Context context;
    public OTPGeneration(Context con)
    {
        context = con;
    }


    public void genrateOTP(String userName) {
        SecureRandom secureRandom = new SecureRandom();
        String s = "";
        for (int i = 0; i < length; i++) {
            number = secureRandom.nextInt(range);
            if (number == 0 && i == 0) { // to prevent the Zero to be the first number as then it will reduce the length of generated pin to three or even more if the second or third number came as zeros
                i = -1;
                continue;
            }
            s = s + number;
        }
        Intent intent = new Intent(Intent.ACTION_SENDTO); // it's not ACTION_SEND
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "OTP Generation");
        intent.putExtra(Intent.EXTRA_TEXT, "Please keep it secure");
        intent.setData(Uri.parse(String.valueOf(userName)));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // this will make such that when user returns to your app, your app is displayed, instead of the email app.
        startActivity(intent);

    }
}
