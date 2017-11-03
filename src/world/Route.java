package world;

import transport.Bike;
import transport.Car;
import transport.Train;
import transport.Transportation;

import java.util.ArrayList;
import java.util.List;

public class Route {
    private City cityA;
    private City cityB;
    private double distance;
    private List<Transportation> availableTransportation;

    public Route(City cityA, City cityB, double distance, List<Transportation> availableTransportation) {
        this.cityA = cityA;
        this.cityB = cityB;
        this.distance = distance;
        initializeTransports(availableTransportation);
    }

    private void initializeTransports(List<Transportation> availableTransportation) {
        this.availableTransportation = new ArrayList<>();

        //make clones of objects otherwise there is ref errors
        for(Transportation t : availableTransportation){
            Transportation tt = null;

            if(t instanceof Bike){
                tt = new Bike();
            } else if(t instanceof Car){
                tt = new Car();
            } else if(t instanceof Train){
                tt = new Train();
            }

            tt.setDistance(distance);
            this.availableTransportation.add(tt);
        }
    }

    public double getDistance(){
        return distance;
    }

    public List<Transportation> getAvailableTransportation() {
        return availableTransportation;
    }

    public City getStartCity(){
        return cityA;
    }

    public City getEndCity(){
        return cityB;
    }

}