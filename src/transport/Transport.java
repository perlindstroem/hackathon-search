package transport;

/**
 * Created by papen on 2017-11-02.
 */
public interface Transport {

    double getTimeCost();

    double getEnvironmentCost();

    void setDistance(double distance);

    String getName();
}
