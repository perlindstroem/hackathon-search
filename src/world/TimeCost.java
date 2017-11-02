package world;

/**
 * Created by papen on 2017-11-02.
 */
public class TimeCost {

    double bikeCost = -1;
    double carCost = -1;
    double trainCost = -1;

    public void setBikeCost(double bikeCost){
        this.bikeCost = bikeCost;
    }

    public void setCarCost(double carCost){
        this.carCost = carCost;
    }

    public void setTrainCost(double trainCost){
        this.trainCost = trainCost;
    }

    public double getBikeCost(){
        return bikeCost;
    }

    public double getCarCost(){
        return carCost;
    }

    public double getTrainCost(){
        return trainCost;
    }
}
