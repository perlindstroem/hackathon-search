package world;

public class Neighbours {
    private City cityA;
    private City cityB;
    private double distance;

    public Neighbours(City cityA, City cityB, double distance) {
        this.cityA = cityA;
        this.cityB = cityB;
        this.distance = distance;
    }

    public double getTimeCost(String transport){
        if(transport.equals("bike")) {
            return distance * 5;
        }

        if(transport.equals("car")) {
            return distance * 1;
        }

        return -1;
    }

    public double getEnvironmentCost(String transport){
        if(transport.equals("bike")) {
            return 0;
        }

        if(transport.equals("car")) {
            return distance * 2;
        }

        return -1;
    }


}