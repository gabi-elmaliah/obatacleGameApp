package com.example.hw1;

import android.util.Log;

import com.example.hw1.models.Record;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Topten {

    private ArrayList<Record> records;
    public Topten(){
        records=new ArrayList<Record>();
        Log.d("hw1.ArrayList","created");
    }
   // public Topten(ArrayList<Record> records)
   // {
  //      this.records=records;
 //   }

    public ArrayList<Record> getRecords() {
        return records;
    }
    public void addRecordToTopTen(Record record)
    {



    }

    public void setRecords(ArrayList<Record> records)
    {
        this.records = records;
    }

    /*@Override

    public String toString()
    {
        String str="";
        Log.d("toptenloop","size: "+records.size());
        for(int i=0;i<records.size();i++)
        {
            Log.d("toptenloop","i="+i);
            records.get(i).toString();
            str+= records.get(i).toString()+"\n";
            Log.d("toptenloop","i="+i);

        }
        return  str;
    }
     */

    @Override
    public String toString() {
        return "Topten{" +
                "records=" + records +
                '}';
    }
    public boolean checkNewRecord(Record record)
    {
        int lastIndex=records.size()-1;
        if(record.getScore()>records.get(lastIndex).getScore())
        {
            records.get(lastIndex).setRecord(record);
            return true;
        }
        return false;
    }

    public void insertNewRecord(Record record)
    {
        int maxSize=10;
        if(records.size()<maxSize)
        {
            records.add(record);
            return;
        }

        if(checkNewRecord(record)==false)
            return;
        Collections.sort(records, new Comparator<Record>()
        {
            @Override
            public int compare(Record lRecord, Record rRecord)
            {
                // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                return lRecord.getScore() > rRecord.getScore() ? -1 : (lRecord.getScore() < rRecord.getScore()) ? 1 : 0;
            }
        });

    }

}
