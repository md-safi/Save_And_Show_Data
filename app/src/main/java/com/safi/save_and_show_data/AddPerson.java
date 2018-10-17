package com.safi.save_and_show_data;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPerson extends AppCompatActivity {

    EditText mEtName,mEtEmail,mEtMobile;
    Button mBtnSave;
    Context context=this;

    DbHelperPerson dbHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);

        mEtName=findViewById(R.id.EtName);
        mEtEmail=findViewById(R.id.EtEmail);
        mEtMobile=findViewById(R.id.EtMobile);

        mBtnSave=findViewById(R.id.BtnSave);

        dbHelper=new DbHelperPerson(this);

        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addData();
            }
        });

    }

    public void addData(){

        boolean isInsert=dbHelper.saveData(mEtName.getText().toString(),mEtEmail.getText().toString(),mEtMobile.getText().toString());

        if(isInsert==true){
            Toast.makeText(getApplicationContext(), "Information Added", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getApplicationContext(), "Something Went Wrong", Toast.LENGTH_SHORT).show();
        }
    }
}
