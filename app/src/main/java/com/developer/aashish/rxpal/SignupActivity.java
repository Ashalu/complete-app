package com.developer.aashish.rxpal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Aashish on 7/6/2017.
 */

public class SignupActivity extends AppCompatActivity {


    CheckBox ch;
    TextView btn,upload;
    EditText user, email, con,hospital,education,address,us,em;
    TextInputEditText pass, repass;
    ImageView img,im;
    RadioButton r1, r2;
    SharedPreferences.Editor editor;
    String u, e, p, r, c;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        WidgetInitialization();



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                u=user.getText().toString();

                e=email.getText().toString();
                p=pass.getText().toString();
                c=con.getText().toString();
                r=repass.getText().toString();

                if (u.equals("") && email.getText().toString().equals("") && pass.getText().toString().equals("") && repass.getText().toString().equals("")&&hospital.getText().toString().equals("")&&address.getText().toString().equals("")&&education.getText().toString().equals("")) {
                    Toast.makeText(SignupActivity.this, "Fill all block", Toast.LENGTH_LONG).show();

                } else if (!p.equals(r)) {
                    Toast.makeText(SignupActivity.this, "Repassword not matched", Toast.LENGTH_LONG).show();
               }
// else if (!e.matches(emailPattern)) {
//                    Toast.makeText(getApplicationContext(), "Invalid email address", Toast.LENGTH_SHORT).show();
//                }
                else if(c.equals(null)&&c.length()>10&&c.length()<10)
                {
                    con.setError("Enter the Correct Contact Number");

                } else{
                    Toast.makeText(SignupActivity.this, "Data Submitted Successfully", Toast.LENGTH_SHORT).show();


                    SharedPreferences pref = getApplicationContext().getSharedPreferences("Options", MODE_PRIVATE);
                    editor=pref.edit();

                    editor.putString("username",u);
                    editor.putString("email",e);
                    editor.commit();
                    Intent i = new Intent(SignupActivity.this, VerificationForm.class);
//                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
            }
        });
    }

    private void WidgetInitialization() {
        btn = (TextView) findViewById(R.id.button2);
        email = (EditText) findViewById(R.id.email);
        user = (EditText) findViewById(R.id.drname);
        pass = (TextInputEditText) findViewById(R.id.vpassword);
        repass = (TextInputEditText) findViewById(R.id.vrepassword);
        con = (EditText) findViewById(R.id.contact);
        hospital=(EditText)findViewById(R.id.clnk);
        education=(EditText)findViewById(R.id.education);
        address=(EditText)findViewById(R.id.address);

    }



}
