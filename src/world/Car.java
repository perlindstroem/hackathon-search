package world;

/**
 * Created by papen on 2017-11-02.
 */
public class Car implements Transportation {

    @Override
    public double getTimeCost(Neighbours neighbour) {
        return neighbour.getDistance()*1;
    }

    @Override
    public double getEnvironmentCost(Neighbours neighbour) {
        return neighbour.getDistance()*2;
    }
}
