package com.example.zeus.loginpage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class adminFunction extends AppCompatActivity implements View.OnClickListener{

    Button insertOrder , updateOrder, updateUser , checkOrder , deleteproduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_function);

        insertOrder= (Button)findViewById(R.id.Insertbt);
        updateOrder= (Button)findViewById(R.id.Updatebt);
        deleteproduct = (Button)findViewById(R.id.Deletebt);
        checkOrder = (Button)findViewById(R.id.checkorderbt);
        updateUser= (Button)findViewById(R.id.upateuserbt);

        insertOrder.setOnClickListener(this);
        updateOrder.setOnClickListener(this);
        deleteproduct.setOnClickListener(this);
        checkOrder.setOnClickListener(this);
        updateUser.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.Insertbt :
                          Intent Int = new Intent(adminFunction.this , InsertData.class );
                         startActivity(Int);
                TextView data = (TextView)findViewById(R.id.data1);
                    data.setText("Done with insertion ");
                        break;
            case R.id.Updatebt :
                     break;
            case R.id.Deletebt :
                break;
            case R.id.checkorderbt :
                break;
            case R.id.upateuserbt :
                break;

        }


    }
}
