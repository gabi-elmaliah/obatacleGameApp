package com.example.hw1.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.hw1.Interfaces.RecordCallback;
import com.example.hw1.R;
import com.example.hw1.models.Record;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;
import java.util.List;


public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.MyViewHolder> {

    private List<Record> records;
    private LayoutInflater mInflater;
    private  RecordCallback recordCallback;

    // data is passed into the constructor

    public void setRecordCallback(RecordCallback recordCallback) {
        this.recordCallback = recordCallback;
    }

    public RecordAdapter(Context context, ArrayList<Record> _records) {
        this.mInflater=LayoutInflater.from(context);
        this.records = _records;
    }

    // inflates the row layout from xml when needed
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.record_item, parent, false);
        return new MyViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Record record = records.get(position);
        holder.place_LBL.setText(position+1+".");
        holder.score_LBL.setText(" " + record.getScore());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return records.size();
    }

    

    // convenience method for getting data at click position
    Record getItem(int position) {
        return records.get(position);
    }

    // stores and recycles views as they are scrolled off screen
    public class MyViewHolder extends RecyclerView.ViewHolder {
        MaterialTextView score_LBL;
        MaterialTextView place_LBL;


        MyViewHolder(View itemView)
        {
            super(itemView);
            place_LBL=itemView.findViewById(R.id.place_LBL);
            score_LBL=itemView.findViewById(R.id.score_LBL);
            itemView.setOnClickListener(v -> {
                if(recordCallback!=null)
                    recordCallback.showLocation(getItem(getAdapterPosition()).getLatitude(),getItem(getAdapterPosition()).getLontitude());
            });
        }
    }

}
