package transport;

/**
 * Created by papen on 2017-11-02.
 */
public interface Transportation {

    double getTimeCost(double distance);

    double getEnvironmentCost(double distance);
}
