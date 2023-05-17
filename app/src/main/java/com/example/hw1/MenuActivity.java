package com.example.hw1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textview.MaterialTextView;

public class MenuActivity extends AppCompatActivity {
    private ExtendedFloatingActionButton slow_btn;
    private ExtendedFloatingActionButton fast_btn;
    private ExtendedFloatingActionButton sensor_btn;
    private ExtendedFloatingActionButton TopTen_BTN;
    private MaterialTextView menu_lbl;
    private MaterialTextView buttons_lbl;
    private MaterialTextView sensor_lbl;
    public static final String KEY_DELAY = "KEY_DELAY";
    final int SLOW_DELAY=1000;
    final  int FAST_DELAY=500;
    public static final String  MODE="KEY_MODE";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Log.d("pttt","onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        findViews();
        initViews();
    }
    public void findViews()
    {

        slow_btn=findViewById(R.id.slow_mode_BTN);
        fast_btn=findViewById(R.id.fast_mode_BTN);
        sensor_btn=findViewById(R.id.Sensor_BTN);
        menu_lbl=findViewById(R.id.title_LBL);
        buttons_lbl=findViewById(R.id.Buttons_LBL);
        sensor_lbl=findViewById(R.id.Sensor_LBL);
        TopTen_BTN=findViewById(R.id.TopTen_BTN);
    }
    public void initViews()
    {

        menu_lbl.setText("Menu");
        buttons_lbl.setText("Play with Buttons");
        sensor_lbl.setText("Sensors");
        fast_btn.setOnClickListener(v -> startGameFastMode());
        slow_btn.setOnClickListener(v -> startGameSlowMode());
        sensor_btn.setOnClickListener(v -> startGameSensorMode());
        TopTen_BTN.setOnClickListener(view -> openTopTen());
    }
    public void openTopTen()
    {
        Intent mainIntent = new Intent(MenuActivity.this,RecordsActivity.class);
        startActivity(mainIntent);
        finish();
    }
    public void startGameFastMode()
    {
        Intent mainIntent = new Intent(MenuActivity.this, MainActivity.class);
        mainIntent.putExtra(KEY_DELAY,FAST_DELAY);
        startActivity(mainIntent);
        finish();
    }
   public void startGameSlowMode()
    {
        Intent mainIntent = new Intent(MenuActivity.this, MainActivity.class);
        mainIntent.putExtra(KEY_DELAY,SLOW_DELAY);
        startActivity(mainIntent);
        finish();
    }
    public void startGameSensorMode()
    {





    }

}