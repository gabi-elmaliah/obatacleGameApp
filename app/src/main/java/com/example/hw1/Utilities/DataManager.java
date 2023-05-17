package com.example.hw1.Utilities;

import com.example.hw1.models.Record;


import java.util.ArrayList;

public class DataManager {



    public static ArrayList<Record> getRrecords()
    {
        ArrayList<Record> records = new ArrayList<>();
        records.add(new Record()
                .setScore(100)
                .setLatitude( -33.865143)
                .setLontitude( 151.209900)
        );
        records.add(new Record()
                .setScore(87)
                .setLatitude(40.712776)
                .setLontitude(-74.005974)

        );
        records.add(new Record()
                .setScore(85)
                .setLatitude(35.689487)
                .setLontitude(139.691711)
        );
        records.add(new Record()
                .setScore(82)
                .setLatitude(48.856614)
                .setLontitude(2.352222)

        );
        records.add(new Record()
                .setScore(78)
                .setLatitude(-22.906847)
                .setLontitude(-43.172897)
        );
        records.add(new Record()
                .setScore(62)
                .setLatitude( 30.044420)
                .setLontitude(31.235712)
        );
        records.add(new Record()
                .setScore(60)
                .setLatitude(55.751244)
                .setLontitude( 37.618423)
        );
        records.add(new Record()
                .setScore(49)
                .setLatitude(-33.924870)
                .setLontitude(18.424055)
        );
        records.add(new Record()
                .setScore(45)
                .setLatitude(49.282729)
                .setLontitude(-123.120738)

        );
        records.add(new Record()
                .setScore(39)
                .setLatitude(41.902783)
                .setLontitude( 12.496366)
        );
        return records;
    }


}
