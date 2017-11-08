package transport;

/**
 * Created by papen on 2017-11-02.
 */

public class Car implements Transport {
    double distance;
    String name = "car";

    public Car() {
        distance = -1.0;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getTimeCost() {
        if(distance < 0 ){
            throw new Error("distance was not set");
        }
        return distance*1;
    }

    public double getEnvironmentCost() {
        if(distance < 0 ){
            throw new Error("distance was not set");
        }
        return distance*4;
    }

    public String getName() {
        return name;
    }
}
