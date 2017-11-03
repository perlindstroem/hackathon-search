package transport;

/**
 * Created by papen on 2017-11-02.
 */

public class Bike implements Transportation {

    @Override
    public double getTimeCost(double distance) {
        return distance*10;
    }

    @Override
    public double getEnvironmentCost(double distance) {
        return distance*0;
    }
}
