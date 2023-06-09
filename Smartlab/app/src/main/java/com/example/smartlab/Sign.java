package com.example.smartlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Sign extends AppCompatActivity {
RadioButton rad1, rad2, rad3;
RadioGroup radBeg;
TextView mainTx, smallTx, finishTx;
ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        rad1 = findViewById(R.id.rad1);
        rad2 = findViewById(R.id.rad2);
        rad3 = findViewById(R.id.rad3);
        mainTx = findViewById(R.id.mainTx);
        smallTx = findViewById(R.id.smallTx);
        radBeg = findViewById(R.id.radBeg);
        finishTx = findViewById(R.id.finishTx);
img = findViewById(R.id.imageView);
        radBeg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb =(RadioButton)findViewById(checkedId);
                int index = radBeg.getCheckedRadioButtonId();
                switch (index)
                {
                    case R.id.rad1:  mainTx.setText(R.string.tabs1main); smallTx.setText(R.string.tabs1small); img.setImageResource(R.mipmap.flask); finishTx.setText(R.string.skip); break;
                    case R.id.rad2: mainTx.setText(R.string.tabs2main); smallTx.setText(R.string.tabs2small); img.setImageResource(R.mipmap.tabimage2); finishTx.setText(R.string.skip);break;
                    case R.id.rad3: mainTx.setText(R.string.tabs3main); smallTx.setText(R.string.tabs3small); img.setImageResource(R.mipmap.tabimage3); finishTx.setText(R.string.finish);break;
                }
            }
        });
        rad1.toggle();
    }
public void onClick(View v)
{
    Intent intent = new Intent(this, Login.class);
    startActivity(intent);
}

}