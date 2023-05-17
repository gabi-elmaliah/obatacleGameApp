package com.example.hw1.models;

public class Record
{

    private int score;

    private double latitude;
    private double lontitude;



    public Record() {}
    public Record(int score,double latitude, double lontitude)
    {
        this.score=score;
        this.latitude=latitude;
        this.lontitude=lontitude;
    }
    public void setRecord(Record record)
    {
        this.score=record.score;
        this.lontitude=record.lontitude;
        this.latitude=record.latitude;
    }

    public int getScore() {
        return score;
    }

    public Record setScore(int score) {
        this.score = score;
        return this;
    }
    public double getLatitude() {
        return latitude;
    }

    public Record setLatitude(double latitude) {
        this.latitude = latitude;
        return this;
    }

    public double getLontitude() {
        return lontitude;
    }

    public Record setLontitude(double lontitude) {
        this.lontitude = lontitude;
        return this;
    }


    @Override
    public String toString() {
        return "Record{" +
                "score=" + score +
                ", latitude=" + latitude +
                ", lontitude=" + lontitude +
                '}';
    }
}
