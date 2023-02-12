package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    databaseHelper mydb;
    Button submit,view,commit;
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
        commit=findViewById(R.id.commitbtn);
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
        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLink("https://github.com/AmeenaFatima01/MadrisahTutorApp/commits/main");
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res=mydb.getData();
                if(res==null)
                {
                    showMessage("Error","Nothing Found");
                    return;
                }
                else
                {
                    StringBuffer bf=new StringBuffer();
                    while(res.moveToNext())
                    {
                        bf.append("Date :"+res.getString(0)+" ");
                        bf.append("Name :"+res.getString(1)+" ");
                        bf.append("Ayat :"+res.getString(2)+" ");
                        bf.append("Sabaqi :"+res.getString(3)+" ");
                        bf.append("Manzil :"+res.getString(4)+" ");
                        bf.append("Salah :"+res.getString(5)+"\n\n");
                    }
                    showMessage("Data",bf.toString());
                }
            }
        });

    }

    private void showMessage(String title, String message) {
        AlertDialog.Builder bd=new AlertDialog.Builder(this);
        bd.setCancelable(true);
        bd.setTitle(title);
        bd.setMessage(message);
        bd.show();
    }
    private void goLink(String s)
    {
        Uri uri= Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

}