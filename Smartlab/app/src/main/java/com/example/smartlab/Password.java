package com.example.smartlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Password extends AppCompatActivity {
Button num1, num2, num3, num4, num5, num6, num7, num8, num9, num0;
ImageButton delBt;
ImageView cir1, cir2, cir3, cir4;
TextView tx;
    String o, pass = "", passBuf;

    ArrayList password;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        num3 = findViewById(R.id.num3);
        num4 = findViewById(R.id.num4);
        num5 = findViewById(R.id.num5);
        num6 = findViewById(R.id.num6);
        num7 = findViewById(R.id.num7);
        num8 = findViewById(R.id.num8);
        num9 = findViewById(R.id.num9);
        num0 = findViewById(R.id.num0);
        delBt = findViewById(R.id.delBt);
        tx = findViewById(R.id.textView4);
        cir1 = findViewById(R.id.cir1);
        cir2 = findViewById(R.id.cir2);
        cir3 = findViewById(R.id.cir3);
        cir4 = findViewById(R.id.cir4);
        password = new ArrayList();
         intent = new Intent(this, EmailCode.class);

    }
  public void onClick(View view)
  {
      switch (view.getId())
      {
          case R.id.num1: if(password.size() <= 3)   password.add("1"); break;
          case R.id.num2: if(password.size() <= 3)   password.add("2"); break;
          case R.id.num3:  if(password.size() <= 3) password.add("3"); break;
          case R.id.num4:  if(password.size() <= 3) password.add("4"); break;
          case R.id.num5:  if(password.size() <= 3)  password.add("5"); break;
          case R.id.num6:  if(password.size() <= 3)  password.add("6"); break;
          case R.id.num7:  if(password.size() <= 3)  password.add("7"); break;
          case R.id.num8:  if(password.size() <= 3) password.add("8"); break;
          case R.id.num9:  if(password.size() <= 3) password.add("9"); break;
          case R.id.num0:  if(password.size() <= 3)  password.add("0"); break;
          case R.id.delBt: if(password.size() != 0) password.remove(password.size() - 1); break;
          default: break;
      }
      cirFill();
      pass = String.join("", password);
if(password.size() == 4) startActivity(intent);
  }

public void cirFill()
{
    if (password.size() == 0)
    {cir1.setImageResource(R.mipmap.ellipse_58);
        cir2.setImageResource(R.mipmap.ellipse_58);
        cir3.setImageResource(R.mipmap.ellipse_58);
        cir4.setImageResource(R.mipmap.ellipse_58);}
    if (password.size() == 1)
    {cir1.setImageResource(R.mipmap.ellipse_57);
        cir2.setImageResource(R.mipmap.ellipse_58);
        cir3.setImageResource(R.mipmap.ellipse_58);
        cir4.setImageResource(R.mipmap.ellipse_58);}
        if (password.size() == 2)
        {cir1.setImageResource(R.mipmap.ellipse_57);
            cir2.setImageResource(R.mipmap.ellipse_57);
            cir3.setImageResource(R.mipmap.ellipse_58);
            cir4.setImageResource(R.mipmap.ellipse_58);}
            if (password.size() == 3)
            {cir1.setImageResource(R.mipmap.ellipse_57);
                cir2.setImageResource(R.mipmap.ellipse_57);
                cir3.setImageResource(R.mipmap.ellipse_57);
                cir4.setImageResource(R.mipmap.ellipse_58);}
                if (password.size() == 4)
                {cir1.setImageResource(R.mipmap.ellipse_57);
                    cir2.setImageResource(R.mipmap.ellipse_57);
                    cir3.setImageResource(R.mipmap.ellipse_57);
                    cir4.setImageResource(R.mipmap.ellipse_57);}
}


}