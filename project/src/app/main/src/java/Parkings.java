package com.example.simeon.najdiparking;

import android.support.annotation.NonNull;

/**
 * Created by Simeon on 30.8.2017.
 */

class Parkings implements  Comparable<Parkings>{
    Parking p;
    double  dist;
    public Parkings(Parking p, double  dist){
        this.p=p;
        this.dist= dist;
    }
    @Override
    public int compareTo(@NonNull Parkings parkings) {
        return Double.compare(dist,parkings.dist);
    }
    @Override
    public String toString(){
        return String.format("%s \n%s\nОддалеченост: %.02f метри",p.name,p.location,dist);
    }
}
