package com.example.hw1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hw1.Adapters.RecordAdapter;
import com.example.hw1.Interfaces.RecordCallback;
import com.example.hw1.R;
import com.example.hw1.Topten;
import com.example.hw1.Utilities.MySp;
import com.google.gson.Gson;

public class ListFragment extends Fragment
{

    private RecyclerView main_LST_records;
    private RecordCallback recordCallback;
    private Topten topten;
    public void setRecordCallback(RecordCallback
                                           recordCallback)
    {
        this.recordCallback = recordCallback;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        loadData();
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        findViews(view);
        initViews();
        return view;
    }
    private void initViews()
    {
        RecordAdapter record_adapter = new RecordAdapter(getContext(),topten.getRecords() );
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        main_LST_records.setAdapter(record_adapter);
        main_LST_records.setLayoutManager(linearLayoutManager);
        record_adapter.setRecordCallback(new RecordCallback() {
            @Override
            public void showLocation(double lattitue, double loattitude) {
                if (recordCallback != null)
                    recordCallback.showLocation(lattitue, loattitude);
            }
        }

        );

    }


    private void findViews(View view)
    {
        main_LST_records=view.findViewById(R.id.main_LST_records);
    }
    private void loadData()
    {
        String fromSp= MySp.getInstance().getString("records","");
        topten=new Gson().fromJson(fromSp,Topten.class);
        if(topten==null)
            topten=new Topten();
    }

}
