package com.example.simeon.najdiparking;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.util.Random;

/**
 * Created by Simeon on 26.8.2017.
 */

public class  Parking implements  Comparable<Parking>,Parcelable {
   public  String name;
    public  String zone;
    public String location;
    public int capacity;
    public double latitude;
    public double longtitude;
    int free=0;
    int taken=0;
    int id;

    public  Parking(){
    }
    public Parking(int capacity,double latitude,String location, double longtitude,String name,String zone){
        this.capacity=capacity;
        this.location=location;
        this.name=name;
        this.zone=zone;
        this.latitude=latitude;
        this.longtitude=longtitude;
        this.taken=getTaken();
        this.free=getFree();
    }

    protected Parking(Parcel in) {
        capacity = in.readInt();
        latitude = in.readDouble();
        location = in.readString();
        longtitude = in.readDouble();
        name = in.readString();
        zone = in.readString();
        taken = in.readInt();
        free = in.readInt();
    }

    public static final Creator<Parking> CREATOR = new Creator<Parking>() {
        @Override
        public Parking createFromParcel(Parcel in) {
            return new Parking(in);
        }

        @Override
        public Parking[] newArray(int size) {
            return new Parking[size];
        }
    };

    public int getCapacity() {
        return capacity;
    }

    public int getFree() {
        return capacity-getTaken();
    }

    public int getTaken() {
        Random random=new Random();
        this.taken=random.nextInt(capacity+1);
        return  taken;
    }

    public  void  setFree(int taken){
        free=capacity-taken;
    }
    public void setTaken(int taken) {
        Random random=new Random();
        this.taken=random.nextInt(capacity+1);
    }
    public  double getLatitude(){
        return  latitude;
    }
    public  double getLongtidue(){
        return  longtitude;
    }


    @Override
    public String toString() {
        return String.format("%s\t\tZone: %s\nlocation: %s\nCapacity: %d\t\tFree: %d",name,zone,location,capacity,getFree());
    }


    @Override
    public int compareTo(@NonNull Parking parking) {
        return Integer.compare(parking.getFree(),this.getFree());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(capacity);
        parcel.writeDouble(latitude);
        parcel.writeString(location);
        parcel.writeDouble(longtitude);
        parcel.writeString(name);
        parcel.writeString(zone);
        parcel.writeInt(getTaken());
        parcel.writeInt(getFree());
    }
}

