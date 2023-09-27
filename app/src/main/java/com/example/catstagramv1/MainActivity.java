package com.example.catstagramv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username, password1, password2;
    Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // declaration of interactive elements
        username=(EditText)findViewById(R.id.username);
        password1=(EditText)findViewById(R.id.userPassword);
        password2=(EditText)findViewById(R.id.userPasswordRepeat);
        b1=(Button)findViewById(R.id.b1);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String s1= username.getText().toString();

            //intent object declaration
                Intent obj=new Intent(getApplicationContext(), MainActivity2.class);
                obj.putExtra("key", s1);
                startActivity(obj);
            }



        });
    }


}