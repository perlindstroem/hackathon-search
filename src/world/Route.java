package world;

import cost.EnvironmentCost;
import cost.TimeCost;
import transport.Bike;
import transport.Car;
import transport.Train;
import transport.Transportation;

import java.util.List;

public class Route {
    private City cityA;
    private City cityB;
    private double distance;
    private List<Transportation> availableTransportation;
    private EnvironmentCost environmentCost = new EnvironmentCost();
    private TimeCost timeCost = new TimeCost();

    public Route(City cityA, City cityB, double distance, List<Transportation> availableTransportation) {
        this.cityA = cityA;
        this.cityB = cityB;
        this.distance = distance;
        this.availableTransportation = availableTransportation;

        updateCosts();
    }

    private void updateCosts(){

        for(Transportation transport : availableTransportation){

            if(transport instanceof Bike){

                environmentCost.setBikeCost(transport.getEnvironmentCost(distance));
                timeCost.setBikeCost(transport.getTimeCost(distance));
            }
            else if(transport instanceof Car){

                environmentCost.setCarCost(transport.getEnvironmentCost(distance));
                timeCost.setCarCost(transport.getTimeCost(distance));

            }
            else if(transport instanceof Train){

                environmentCost.setTrainCost(transport.getEnvironmentCost(distance));
                timeCost.setTrainCost(transport.getTimeCost(distance));
            }
        }
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

    public TimeCost getTimeCost(){

      return timeCost;
    }

    public EnvironmentCost getEnvironmentCost(){

        return environmentCost;
    }
}