package com.example.applogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity2 extends AppCompatActivity {


    SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        final EditText mobileNumET= (EditText)findViewById(R.id.ETMobile);
        final EditText passET = (EditText)findViewById(R.id.ETpass);
        Button loginBtn = (Button)findViewById(R.id.BTNlogin);

        final String mobilenumbertostring= mobileNumET.toString().trim();




        sp= getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mobileNumberStore = mobileNumET.getText().toString().trim();
                String passStore = passET.getText().toString().trim();
                Boolean userStatus= false;

                //String upToNCharacters = mobileNumberStore.substring(0, Math.min(mobileNumberStore.length(), 2));

                //String upToNCharacters = StringUtils.left(s, n);

                //String substr=mobilenumbertostring.substring(0,2);

               // String substr= mobileNumberStore.substring(2);

                boolean  gp = mobileNumberStore.startsWith("017");
                boolean  bl = mobileNumberStore.startsWith("019");
                boolean  tt = mobileNumberStore.startsWith("015");
                boolean  at = mobileNumberStore.startsWith("016");
                boolean  rb = mobileNumberStore.startsWith("018");

                SharedPreferences.Editor editor = sp.edit();




            if(gp== true || bl == true || tt == true || at == true || rb == true && mobileNumET.length() > 10) {

                        if (passET.length() > 7) {
                            userStatus = true;


                            editor.putString("mobileNo", mobileNumberStore);
                            editor.putString("pass", passStore);
                            editor.putBoolean("status", userStatus);
                            editor.commit();

                            userStatus = true;
                            Intent intent = new Intent(LoginActivity2.this, HomeActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        else {
                            Toast.makeText(LoginActivity2.this, "Please Enter Valid Mobile Number, Password Minimum 8 digits", Toast.LENGTH_SHORT).show();
                        }
                }
                else
                {
                    Toast.makeText(LoginActivity2.this, "Please Enter Valid Mobile Number, Password Minimum 8 digits", Toast.LENGTH_SHORT).show();
                }






            }
        });

    }
}