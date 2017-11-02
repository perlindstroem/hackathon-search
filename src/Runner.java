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

        populateLists();
        initWorld();
    }

    private static void initWorld(){

        World one = new World();

        City linkan = new City("linkan");
        City norpan = new City("norpan");
        City malmslatt = new City("malmslatt");
        City ryd = new City("ryd");
        City skarblacka = new City("skarblacka");
        City soderkoping = new City("soderkoping");

        one.addCity(linkan);
        one.addCity(norpan);
        one.addCity(malmslatt);
        one.addCity(ryd);
        one.addCity(skarblacka);
        one.addCity(soderkoping);

        one.addNeighbours(linkan, norpan, 10.0, BCT);
        one.addNeighbours(linkan, ryd, 4.0, BC);
        one.addNeighbours(malmslatt, linkan, 6.0, BC);
        one.addNeighbours(malmslatt, ryd, 2.0, B);
        one.addNeighbours(norpan, skarblacka, 6.0, BC);
        one.addNeighbours(soderkoping, norpan, 4.0, BCT);
        one.addNeighbours(soderkoping, skarblacka, 2.0, C);

        one.listCities();

        List<City> tempList = one.listNeighbours(linkan);

        for (City city : tempList){
            System.out.println("neighbour " + city.getName());
        }

        for(Neighbours neighbour: one.getNeighbours()){

            if(neighbour.getCityA() == linkan){
               System.out.println("The environment cost to travel to " + neighbour.getCityB().getName() + " is " + neighbour.getEnvironmentCost().getBikeCost() + " for bike, " +
                       neighbour.getEnvironmentCost().getCarCost() + " for car and " + neighbour.getEnvironmentCost().getTrainCost() + " for train");
                System.out.println("The time cost to travel to " + neighbour.getCityB().getName() + " is " + neighbour.getTimeCost().getBikeCost() + " for bike, " +
                        neighbour.getTimeCost().getCarCost() + " for car and " + neighbour.getTimeCost().getTrainCost() + " for train");
            }
            else if(neighbour.getCityB()==linkan){
                System.out.println("The environment cost to travel to " + neighbour.getCityA().getName() + " is " + neighbour.getEnvironmentCost().getBikeCost() + " for bike, " +
                        neighbour.getEnvironmentCost().getCarCost() + " for car and " + neighbour.getEnvironmentCost().getTrainCost() + " for train");
                System.out.println("The time cost to travel to " + neighbour.getCityB().getName() + " is " + neighbour.getTimeCost().getBikeCost() + " for bike, " +
                        neighbour.getTimeCost().getCarCost() + " for car and " + neighbour.getTimeCost().getTrainCost() + " for train");
            }
        }
    }

    public static void populateLists(){

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
