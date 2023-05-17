package com.example.hw1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hw1.Fragments.ListFragment;
import com.example.hw1.Fragments.Mapfragment;
import com.example.hw1.Interfaces.RecordCallback;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textview.MaterialTextView;

public class RecordsActivity extends AppCompatActivity {


    private Mapfragment mapfragment;
    private ListFragment listFragment;
    private MaterialTextView menu_title_LBL;
    private ExtendedFloatingActionButton back_to_menu_BTN;
    RecordCallback recordCallback = new RecordCallback() {
        @Override
        public void showLocation(double lattitue, double loattitude) {
            mapfragment.goToLocation(lattitue, loattitude);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);
        findViews();
        init();
        listFragment = new ListFragment();
        mapfragment = new Mapfragment();
        listFragment.setRecordCallback(recordCallback);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_FRAME_map, mapfragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main_FRAME_list, listFragment).commit();
    }
    private void init()
    {
        back_to_menu_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMenu();
            }
        });
        menu_title_LBL.setText("Top ten");
    }
    private void findViews()
    {
        menu_title_LBL=findViewById(R.id.menu_title_LBL);
        back_to_menu_BTN=findViewById(R.id.back_to_menu_BTN);

    }
    private void openMenu()
    {
        Intent mainIntent = new Intent(this, MenuActivity.class);
        startActivity(mainIntent);
        finish();
    }


}