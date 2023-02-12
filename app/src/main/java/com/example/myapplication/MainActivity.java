package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    databaseHelper mydb;
    Button submit,view;
    EditText date,name,ayat,sabaqi,manzil,salah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit=findViewById(R.id.sbmitbtn);
        view=findViewById(R.id.viewbtn);
        date=findViewById(R.id.datefld);
        name=findViewById(R.id.namefld);
        ayat=findViewById(R.id.ayatfld);
        sabaqi=findViewById(R.id.sabaqifld);
        manzil=findViewById(R.id.manzilfld);
        salah=findViewById(R.id.salahfld);
        mydb=new databaseHelper(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted= mydb.Insert(date.getText().toString(),name.getText().toString(),ayat.getText().toString(),sabaqi.getText().toString(),manzil.getText().toString(),salah.getText().toString());
                if(isInserted==true)
                {
                    Toast.makeText(MainActivity.this, "Inserted in database", Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(MainActivity.this, "Failed to insert in database", Toast.LENGTH_LONG).show();
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}