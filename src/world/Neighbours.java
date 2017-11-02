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

    public double getTimeCost(double distance){

        if(availableTransportation != null){
            for(Transportation transport : availableTransportation){

                transport.getTimeCost(distance);
            }
        }

        return -1;
    }

    public double getEnvironmentCost(double distance){

        if(availableTransportation != null){
            for(Transportation transport : availableTransportation){

                transport.getEnvironmentCost(distance);
            }
        }

        return -1;
    }
}