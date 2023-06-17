package com.example.smartlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EmailCode extends AppCompatActivity {
EditText code1, code2, code3, code4;
CountDownTimer d;
TextView timerTx;
Button againBt;
    Intent intent;
    String j;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_code);
        intent = new Intent(this, Password.class);
        code1 = findViewById(R.id.code1);
        code2 = findViewById(R.id.code2);
        code3 = findViewById(R.id.code3);
        code4 = findViewById(R.id.code4);
timerTx = findViewById(R.id.timerTx);
againBt = findViewById(R.id.againBt);
TextChangedSwap(code1);
d = new CountDownTimer(60000, 1000) {
    @Override
    public void onTick(long millisUntilFinished) {
        double k = millisUntilFinished / 1000;
int o = (int) k;

        if (o%10 == 4 || o%10 == 3 || o%10 == 2 || o%11 == 1 ||o%12 == 1 ||o%13 == 1 ||o%14 == 1) j = "секунды";
        else if(o%10 == 1) j = "секунду";
        else j = "секунд";
        timerTx.setText("Отправить код повторно можно будет через " + o + " " + j);
    }

    @Override
    public void onFinish() {
timerTx.setText("Отправить код снова");
againBt.setVisibility(View.VISIBLE);
    }
};
d.start();

    }
public void codeFocus(EditText e)
{if(e.requestFocus())
{
    getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
}
}

public void onClick(View view)
{
    d.start();
    code1.setText("");
    code2.setText("");
    code3.setText("");
    code4.setText("");
    codeFocus(code1);
    againBt.setVisibility(View.INVISIBLE);
}
public void TextChangedSwap(EditText ed)
{
    ed.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            switch (ed.getId())
            {
                case R.id.code1: codeFocus(code2); break;
                case R.id.code2: codeFocus(code3); break;
                case R.id.code3: codeFocus(code4); break;
                case R.id.code4: codeFocus(code1); break;


            }
        }

        @Override
        public void afterTextChanged(Editable s) {

            if(ed.getId() == R.id.code1)
                TextChangedSwap(code2);
            if(ed.getId() == R.id.code2)
                TextChangedSwap(code3);
            if(ed.getId() == R.id.code3)
                TextChangedSwap(code4);
            if(ed.getId() == R.id.code4)
                TextChangedSwap(code1);

            if (getCode() == 2345)
            {

                startActivity(intent);
            }
        }
    });
}

public int getCode()
{
    String cod1 = code1.getText().toString();
    String cod2 = code2.getText().toString();
    String cod3 = code3.getText().toString();
    String cod4 = code4.getText().toString();
    String DaCod = cod1 + cod2 + cod3 + cod4;
    return Integer.parseInt(DaCod);
}

}