package world;

/**
 * Created by papen on 2017-11-02.
 */

public class Bike implements Transportation {

    @Override
    public double getTimeCost(Neighbours neighbour) {
        return neighbour.getDistance()*5;
    }

    @Override
    public double getEnvironmentCost(Neighbours neighbour) {
        return neighbour.getDistance()*0;
    }
}
