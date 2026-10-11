package com.example.eggproject2hilichen;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private ImageButton btn_back;
    private ImageButton img_egg;
    private ImageButton btn_reset;
    private TextView tv_helpMe;
    private TextView tv_num;
    private Switch sw_on;
    private int count = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        android.widget.Toast.makeText(
                this,
                "MainActivity started!",
                android.widget.Toast.LENGTH_LONG
        ).show();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btn_back = (ImageButton) findViewById(R.id.btn_back);
        img_egg=(ImageButton) findViewById(R.id.img_egg);
        btn_reset=(ImageButton) findViewById(R.id.btn_reset);
        tv_helpMe=(TextView) findViewById(R.id.tv_helpMe);
        tv_num=(TextView) findViewById(R.id.tv_num);
        sw_on=(Switch) findViewById(R.id.sw_on);

        img_egg.setOnClickListener(this);
        btn_reset.setOnClickListener(this);
        btn_back.setOnClickListener(this);
        this.sw_on.setOnCheckedChangeListener(this);

        tv_helpMe.setText("help me!");
        tv_num.setText(String.valueOf(count));
    }

    @Override
    public void onClick(View v)
    {
        if (v == img_egg)
        {
            if (count > 0)
            {
                count--;
                tv_num.setText(String.valueOf(count));
            }
            if (count == 0) {
                tv_helpMe.setText("thank you");
                img_egg.setImageResource(R.drawable.img_chick);
            }
        }
        if (v == btn_reset)
        {
            count = 10;
            tv_num.setText(String.valueOf(count));
            img_egg.setImageResource(R.drawable.img_egg);
            tv_helpMe.setText("Help Me!");
        }
    }

    @Override
    public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
        if(isChecked)
            findViewById(R.id.main).setBackgroundResource(R.drawable.volcano);
        else
            findViewById(R.id.main).setBackgroundResource(R.drawable.img_forest);
    }
}