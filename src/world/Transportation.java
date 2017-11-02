package world;

/**
 * Created by papen on 2017-11-02.
 */
public interface Transportation {

    double getTimeCost(Neighbours neighbour);

    double getEnvironmentCost(Neighbours neighbour);
}
