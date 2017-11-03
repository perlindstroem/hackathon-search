package transport;

/**
 * Created by papen on 2017-11-02.
 */

public class Train implements Transportation {

    @Override
    public double getTimeCost(double distance) {
        return distance*2;
    }

    @Override
    public double getEnvironmentCost(double distance) {
        return distance*2;
    }
}
