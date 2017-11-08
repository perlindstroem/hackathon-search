package world;

import transport.Bike;
import transport.Car;
import transport.Train;
import transport.Transport;

import java.util.ArrayList;
import java.util.List;

public class Route {
    private City start;
    private City goal;
    private double distance;
    private List<Transport> availableTransport;

    public Route(City start, City goal, double distance, List<Transport> availableTransport) {
        this.start = start;
        this.goal = goal;
        this.distance = distance;
        initTransports(availableTransport);
    }

    private void initTransports(List<Transport> availableTransport) {
        this.availableTransport = new ArrayList<>();

        //make clones of objects otherwise there is ref errors
        for(Transport t : availableTransport){
            Transport tt = null;

            if(t instanceof Bike){
                tt = new Bike();
            } else if(t instanceof Car){
                tt = new Car();
            } else if(t instanceof Train){
                tt = new Train();
            }

            tt.setDistance(distance);
            this.availableTransport.add(tt);
        }
    }

    public double getDistance(){
        return distance;
    }

    public List<Transport> getAvailableTransport() {
        return availableTransport;
    }

    public City getStartCity(){
        return start;
    }

    public City getEndCity(){
        return goal;
    }

}