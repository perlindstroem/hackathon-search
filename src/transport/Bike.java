package transport;

import com.sun.javaws.exceptions.ErrorCodeResponseException;

/**
 * Created by papen on 2017-11-02.
 */

public class Bike implements Transportation {
    double distance;
    String name = "bike";

    public Bike() {
        distance = -1.0;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getTimeCost() {
        if(distance < 0 ){
            throw new Error("distance was not set");
        }
        return distance*10;
    }

    public double getEnvironmentCost() {
        if(distance < 0 ){
            throw new Error("distance was not set");
        }
        return distance*0;
    }

    public String getName() {
        return name;
    }
}
