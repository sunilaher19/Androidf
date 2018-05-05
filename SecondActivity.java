package com.example.zeus.loginpage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    CheckBox ck1,ck2,ck3;
    OnClickListener checkBoxListener;
    int price = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);



         ck1 = (CheckBox)findViewById(R.id.ck1);
         ck2 = (CheckBox)findViewById(R.id.ck2);
         ck3 = (CheckBox)findViewById(R.id.ck3);
        Button pro = (Button)findViewById(R.id.Insertbt);
        final TextView tx1 = (TextView)findViewById(R.id.tx1);
        final TextView tx2 = (TextView)findViewById(R.id.tx2);
        final TextView tx3 = (TextView)findViewById(R.id.tx3);

        pro.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                if(ck1.isChecked())
                {
                    price = price + 200;
                    tx1.setText("Done");
                }
                if (ck2.isChecked())
                {
                    price = price + 300;
                    tx2.setText("Done");
                }
                if(ck3.isChecked())
                {
                    price = price + 4000;
                    tx3.setText("Done");
                }

               printTotal();
            }
        });

    }

    private void printTotal()
    {
        Intent Int = new Intent(SecondActivity.this , Main2Activity.class);
        Int.putExtra("no",price);
        startActivity(Int);
    }


}
