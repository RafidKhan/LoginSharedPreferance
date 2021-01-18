package com.example.applogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class HomeActivity extends AppCompatActivity {

    TextView fetchNumber;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button logoutbtn2= findViewById(R.id.btnlogout2);

        fetchNumber= findViewById(R.id.fetchNumber);




        SharedPreferences sp = getApplicationContext().getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
        String fetchNo= sp.getString("mobileNo","");

        fetchNumber.setText(fetchNo);


        Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show();

        logoutbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(HomeActivity.this, LoginActivity2.class);
                startActivity(intent);
                finish();
            }
        });
    }
}