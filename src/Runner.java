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

        City sodertalje = new City("sodertalje");
        City boras = new City("boras");
        City gavle = new City("gavle");
        City umea = new City("umea");
        City lund = new City("lund");
        City jonkoping = new City("jonkoping");
        City helsingborg = new City("helsingborg");
        City orebro = new City("orebro");
        City vasteras = new City("vasteras");
        City sollentuna = new City("sollentuna");
        City uppsala = new City("uppsala");
        City malmo = new City("malmo");
        City goteborg = new City("goteborg");
        City stockholm = new City("stockholm");

        City linkoping = new City("linkoping");
        City norrkoping = new City("norrkoping");
       /*
        City malmslatt = new City("malmslatt");
        City ryd = new City("ryd");
        City skarblacka = new City("skarblacka");
        City soderkoping = new City("soderkoping");

        worldOne.addCity(malmslatt);
        worldOne.addCity(ryd);
        worldOne.addCity(skarblacka);
        worldOne.addCity(soderkoping);
        */

        worldOne.addCity(linkoping);
        worldOne.addCity(norrkoping);
        worldOne.addCity(sodertalje);
        worldOne.addCity(boras);
        worldOne.addCity(gavle);
        worldOne.addCity(umea);
        worldOne.addCity(lund);
        worldOne.addCity(jonkoping);
        worldOne.addCity(helsingborg);
        worldOne.addCity(orebro);
        worldOne.addCity(vasteras);
        worldOne.addCity(sollentuna);
        worldOne.addCity(uppsala);
        worldOne.addCity(malmo);
        worldOne.addCity(goteborg);
        worldOne.addCity(stockholm);

        worldOne.addNeighbours(malmo, lund, 17.8, BCT);
        worldOne.addNeighbours(malmo, helsingborg, 54.2, CT);
        worldOne.addNeighbours(lund, helsingborg, 49.5, T);
        worldOne.addNeighbours(helsingborg, goteborg, 191, BT);
        worldOne.addNeighbours(goteborg, boras, 58.8, BCT);
        worldOne.addNeighbours(boras, jonkoping, 72.5, BCT);
        worldOne.addNeighbours(lund, jonkoping, 238, C);
        worldOne.addNeighbours(jonkoping, linkoping, 110, CT);
        worldOne.addNeighbours(linkoping, norrkoping, 38.8, BT);
        worldOne.addNeighbours(norrkoping, orebro, 93.6, CT);
        worldOne.addNeighbours(norrkoping, sodertalje, 106, T);
        worldOne.addNeighbours(orebro, vasteras, 84.1, CT);
        worldOne.addNeighbours(sodertalje, stockholm, 29.6, T);
        worldOne.addNeighbours(stockholm, sollentuna, 14.8, B);
        worldOne.addNeighbours(sollentuna, uppsala, 50.6, BCT);
        worldOne.addNeighbours(uppsala, gavle, 96.7, T);
        worldOne.addNeighbours(vasteras, gavle, 122, C);
        worldOne.addNeighbours(gavle, umea, 427, T);
        worldOne.addNeighbours(orebro, sodertalje, 138, T);

        /*
        worldOne.addNeighbours(linkan, norpan, 10.0, BCT);
        worldOne.addNeighbours(linkan, ryd, 4.0, BC);
        worldOne.addNeighbours(malmslatt, linkan, 6.0, BC);
        worldOne.addNeighbours(malmslatt, ryd, 2.0, B);
        worldOne.addNeighbours(norpan, skarblacka, 6.0, BC);
        worldOne.addNeighbours(soderkoping, norpan, 4.0, BCT);
        worldOne.addNeighbours(soderkoping, skarblacka, 2.0, C);
        */

        worldOne.listCities();

        List<City> tempList = worldOne.getNeighboursTo(linkoping);

        for (City city : tempList){
            System.out.println("neighbour " + city.getName());
        }

        for(Route route: worldOne.getRoutes()){

            System.out.println("START is " + route.getStartCity().getName());
            System.out.println("END is " + route.getEndCity().getName());
            System.out.println("DISTANCE is " + route.getDistance());

           for(Transportation t : route.getAvailableTransportation()){
               System.out.println("Transport: " + t.getName() + " has environment cost: " + t.getEnvironmentCost() + " and time cost: " + t.getTimeCost());

            }

        }
    }

    private static void populateTransportLists(){

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
