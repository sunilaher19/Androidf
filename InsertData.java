package com.example.zeus.loginpage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class InsertData extends AppCompatActivity {

    EditText product , price, quantity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);

        product = (EditText)findViewById(R.id.ProductData);
        price = (EditText)findViewById(R.id.priceData);
        quantity = (EditText)findViewById(R.id.quantityData);


    }
}

