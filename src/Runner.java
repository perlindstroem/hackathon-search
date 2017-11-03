import transport.Bike;
import transport.Car;
import transport.Train;
import transport.Transportation;
import world.*;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    private static List<Transportation> BCT = new ArrayList<>();
    private static List<Transportation> BC = new ArrayList<>();
    private static List<Transportation> BT = new ArrayList<>();
    private static List<Transportation> CT = new ArrayList<>();
    private static List<Transportation> B = new ArrayList<>();
    private static List<Transportation> C = new ArrayList<>();
    private static List<Transportation> T = new ArrayList<>();

    public static void main(String[] args){

        populateTransportLists();
        initWorld();
    }

    private static void initWorld(){

        World worldOne = new World();

        City linkan = new City("linkan");
        City norpan = new City("norpan");
        City malmslatt = new City("malmslatt");
        City ryd = new City("ryd");
        City skarblacka = new City("skarblacka");
        City soderkoping = new City("soderkoping");

        worldOne.addCity(linkan);
        worldOne.addCity(norpan);
        worldOne.addCity(malmslatt);
        worldOne.addCity(ryd);
        worldOne.addCity(skarblacka);
        worldOne.addCity(soderkoping);

        worldOne.addNeighbours(linkan, norpan, 10.0, BCT);
        worldOne.addNeighbours(linkan, ryd, 4.0, BC);
        worldOne.addNeighbours(malmslatt, linkan, 6.0, BC);
        worldOne.addNeighbours(malmslatt, ryd, 2.0, B);
        worldOne.addNeighbours(norpan, skarblacka, 6.0, BC);
        worldOne.addNeighbours(soderkoping, norpan, 4.0, BCT);
        worldOne.addNeighbours(soderkoping, skarblacka, 2.0, C);

        worldOne.listCities();

        List<City> tempList = worldOne.getNeighboursTo(linkan);

        for (City city : tempList){
            System.out.println("neighbour " + city.getName());
        }

        for(Route route: worldOne.getRoutes()){

            if(route.getCityA() == linkan){
               System.out.println("The environment cost to travel to " + route.getCityB().getName() + " is " + route.getEnvironmentCost().getBikeCost() + " for bike, " +
                       route.getEnvironmentCost().getCarCost() + " for car and " + route.getEnvironmentCost().getTrainCost() + " for train");
                System.out.println("The time cost to travel to " + route.getCityB().getName() + " is " + route.getTimeCost().getBikeCost() + " for bike, " +
                        route.getTimeCost().getCarCost() + " for car and " + route.getTimeCost().getTrainCost() + " for train");
            }
        }
    }

    public static void populateTransportLists(){

        BCT.add(new Bike());
        BCT.add(new Car());
        BCT.add(new Train());

        BC.add(new Bike());
        BC.add(new Car());

        BT.add(new Bike());
        BT.add(new Train());

        CT.add(new Car());
        CT.add(new Train());

        B.add(new Bike());

        C.add(new Car());

        T.add(new Train());
    }
}
