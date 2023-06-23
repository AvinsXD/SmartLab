package com.example.smartlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;
import java.util.regex.Pattern;

public class Login extends AppCompatActivity {
EditText mail;
    String email1, emailsubject, emailbody;
    int po;
    Random r;
Button login, yandex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mail = findViewById(R.id.emailTx);
        login = findViewById(R.id.login);
        yandex = findViewById(R.id.button2);
        r = new Random();
po = r.nextInt(9999 - 0)+0;

        mail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                email1 = mail.getText().toString();
                if(isEmailValid(email1))
{login.setEnabled(true);}
                if(!isEmailValid(email1))
                {login.setEnabled(false);}
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    boolean isEmailValid(String email1)
    {Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile("[a-zA-Z0-9+._%-+]{1,256}"
            + "@" + "[a-zA-Z0-9][a-zA-Z0-9-]{0,64}" + "(" + "." + "[a-zA-Z0-9][a-zA-Z0-9-]{0,25}" +")+");
        return  EMAIL_ADDRESS_PATTERN.matcher(email1).matches();
    }

    public void onClick(View view)
    {

     emailsubject = "Ваш код";
      emailbody= String.valueOf(po);
        Intent intent = new Intent(this, EmailCode.class);
      Intent emailsend = new Intent(Intent.ACTION_SEND);
       emailsend.putExtra(Intent.EXTRA_EMAIL, new String[]{email1});
       emailsend.putExtra(Intent.EXTRA_SUBJECT, emailsubject);
       emailsend.putExtra(Intent.EXTRA_TEXT, emailbody);
       emailsend.setType("message/rfc822");
        intent.putExtra("email", email1);
        intent.putExtra("code", po);
       startActivity(Intent.createChooser(emailsend, "Choose an Email client :"));
        startActivity(intent);
    }

}