package com.OS;
import java.util.ArrayList;
import java.util.Collections;
/**
 * Created by Honsen on 2016/10/16.
 *
 */
class Tour{

    // 保持城市的列表
    private ArrayList tour = new ArrayList<City>();
    // 缓存距离
    private int distance = 0;

    // 生成一个空的路径
    Tour(){
        for (int i = 0; i < SimulatedAnnealing.allCitys.size(); i++) {
            tour.add(null);
        }
    }

    // 复杂路径
    Tour(ArrayList tour){
        this.tour = (ArrayList) tour.clone();
    }

    ArrayList getTour(){
        return tour;
    }

    // Creates a random individual
    void generateIndividual() {
        // Loop through all our destination cities and add them to our tour
        for (int cityIndex = 0; cityIndex < SimulatedAnnealing.allCitys.size(); cityIndex++) {
            setCity(cityIndex, SimulatedAnnealing.allCitys.get(cityIndex));
        }
        // 随机的打乱
        Collections.shuffle(tour);
    }

    // 获取一个城市
    City getCity(int tourPosition) {
        return (City)tour.get(tourPosition);
    }

    void setCity(int tourPosition, City city) {
        tour.set(tourPosition, city);
        // 重新计算距离
        distance = 0;
    }

    // 获得当前距离的 总花费
    int getDistance(){
        if (distance == 0) {
            int tourDistance = 0;
            for (int cityIndex=0; cityIndex < tourSize(); cityIndex++) {
                City fromCity = getCity(cityIndex);
                City destinationCity;
                if(cityIndex+1 < tourSize()){
                    destinationCity = getCity(cityIndex+1);
                }
                else{
                    destinationCity = getCity(0);
                }
                tourDistance += fromCity.distanceTo(destinationCity);
            }
            distance = tourDistance;
        }
        return distance;
    }

    // 获得当前路径中城市的数量
    int tourSize() {
        return tour.size();
    }

    @Override
    public String toString() {
        String geneString = "|";
        for (int i = 0; i < tourSize(); i++) {
            geneString += getCity(i)+"|";
        }
        return geneString;
    }
}