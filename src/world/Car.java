package world;

/**
 * Created by papen on 2017-11-02.
 */
public class Car implements Transportation {

    @Override
    public double getTimeCost(double distance) {
        return distance*1;
    }

    @Override
    public double getEnvironmentCost(double distance) {
        return distance*2;
    }
}
