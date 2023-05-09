package com.example.danawa;

import android.media.Image;

public class Product {
    String Name;
    String Cost;
    String Footlevel;
    int Pic;

    public Product(String name, String cost, String footlevel, int pic) {
        Name = name;
        Cost = cost;
        Footlevel = footlevel;
        Pic = pic;
    }

    public int getPic(){
        return Pic;
    }
    public void setPic(int pic){
        Pic = pic;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCost() {
        return Cost;
    }

    public void setCost(String cost) {
        Cost = cost;
    }

    public String getFootlevel() {
        return Footlevel;
    }

    public void setFootlevel(String footlevel) {
        Footlevel = footlevel;
    }
}