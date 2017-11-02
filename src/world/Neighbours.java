package world;

import java.util.List;

public class Neighbours {
    private City cityA;
    private City cityB;
    private double distance;
    private List<Transportation> availableTransportation;

    public Neighbours(City cityA, City cityB, double distance, List<Transportation> availableTransportation) {
        this.cityA = cityA;
        this.cityB = cityB;
        this.distance = distance;
        this.availableTransportation = availableTransportation;
    }

    public double getDistance(){

        return distance;
    }

    public City getCityA(){
        return cityA;
    }

    public City getCityB(){
        return cityB;
    }

    public double getTimeCost(){

        if(availableTransportation != null){
            for(Transportation transport : availableTransportation){

                transport.getTimeCost(this);
            }
        }

        return -1;
    }

    public double getEnvironmentCost(){

        if(availableTransportation != null){
            for(Transportation transport : availableTransportation){

                transport.getEnvironmentCost(this);
            }
        }

        return -1;
    }
}