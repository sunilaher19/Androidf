package com.example.zeus.loginpage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class signUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Button submit = (Button)findViewById(R.id.Submit);
        submit.setEnabled(false);
        final EditText User = (EditText)findViewById(R.id.UserId);
        final EditText password = (EditText)findViewById(R.id.Password);
        final EditText ConfirmPass = (EditText)findViewById(R.id.confirmPassword);
        TextView error = (TextView)findViewById(R.id.TextView_PwdProblem);
        if (password.equals(password)) {
            error.setText("Password Equal");
            submit.setEnabled(true);
        } else {
            error.setText("Password Not Equal");
            submit.setEnabled(false);
        }
        final EditText question1 = (EditText)findViewById(R.id.Question1);
        final EditText question2 = (EditText)findViewById(R.id.Question2);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Update(User.getText().toString(), password.getText().toString() ,ConfirmPass.getText().toString(),question1.getText().toString()  ,question2.getText().toString());
            }
        });
    }

    private void Update(String user, String password, String confirmPass, String question1, String question2) {
        String type = "signUp";
        Conncetiontomysql con1 = new Conncetiontomysql(this);
        con1.execute(type,user,password,question1,question2);
    }
}
