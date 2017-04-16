package com.OS;

/**
 * Created by Honsen on 2016/10/16.
 *
 */
public class City {
    private int x;
    private int y;
    public City(){
        this.x= (int)(Math.random()*200);
        this.y= (int)(Math.random()*200);
    }
    public City(int x,int y){
        this.x=x;
        this.y=y;
    }
    public double distanceTo(City city){
        int xDistance=Math.abs(getX()-city.getX());
        int yDistance=Math.abs(getX()-city.getX());
        return Math.sqrt((xDistance*xDistance)+(yDistance*yDistance));
    }

    @Override
    public String toString() {
        return getX()+", "+getY();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
