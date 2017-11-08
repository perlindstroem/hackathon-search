import search.AStar;
import search.BalancedAStar;
import search.Leg;
import search.MultiGoal;
import transport.Bike;
import transport.Car;
import transport.Train;
import transport.Transportation;
import world.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
        World w1 = initWorldOne();
        //World w2 = initWorldTwo();
        //initWorldSmall();
        //initWorldDiffTransport();

    }

    private static World initWorldDiffTransport(){
        World w = new World();

        City s = new City("starterTown");
        City m = new City("middleTown");
        City e = new City("endTown");

        w.addCity(s);
        w.addCity(m);
        w.addCity(e);

        w.addNeighbours(s, m, 10.0, BCT);
        w.addNeighbours(e, m, 9.0, BCT);

        BalancedAStar ba = new BalancedAStar();
        Stack<Leg> solution = ba.search(w, s, e, true);

        return w;
    }

    private static World initWorldSmall(){
        World w = new World();

        City s = new City("starterTown");
        City bt1 = new City("bikerTownOne");
        City ct1 = new City("carTownOne");
        City tt1 = new City("trainTownOne");
        City e = new City("endTown");

        w.addCity(s);
        w.addCity(bt1);
        w.addCity(ct1);
        w.addCity(tt1);
        w.addCity(e);

        w.addNeighbours(s, bt1, 10.0, B);
        w.addNeighbours(e, bt1, 9.0, B);
        w.addNeighbours(s, ct1, 10.0, C);
        w.addNeighbours(e, ct1, 11.0, C);
        w.addNeighbours(s, tt1, 10.0, T);
        w.addNeighbours(e, tt1, 10.0, T);

        BalancedAStar ba = new BalancedAStar();
        Stack<Leg> solution = ba.search(w, s, e, true);

        return w;
    }

    private static World initWorldOne(){

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

        City huddinge = new City("huddinge");
        City eskilstuna = new City("eskilstuna");
        City sundsvall = new City("sundsvall");
        City halmstad = new City("halmstad");
        City karlstad = new City("karlstad");
        City vaxjo = new City("vaxjo");
        City kristianstad = new City("kristianstad");
        City molndal = new City("molndal");
        City lulea = new City("lulea");
        City skelleftea = new City("skelleftea");
        City kalmar = new City("kalmar");

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

        worldOne.addCity(huddinge);
        worldOne.addCity(eskilstuna);
        worldOne.addCity(sundsvall);
        worldOne.addCity(halmstad);
        worldOne.addCity(karlstad);
        worldOne.addCity(vaxjo);
        worldOne.addCity(kristianstad);
        worldOne.addCity(molndal);
        worldOne.addCity(lulea);
        worldOne.addCity(skelleftea);
        worldOne.addCity(kalmar);

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
        worldOne.addNeighbours(orebro, vasteras, 84.1, B);
        worldOne.addNeighbours(sodertalje, stockholm, 29.6, T);
        worldOne.addNeighbours(stockholm, sollentuna, 14.8, B);
        worldOne.addNeighbours(sollentuna, uppsala, 50.6, BCT);
        worldOne.addNeighbours(uppsala, gavle, 96.7, T);
        worldOne.addNeighbours(vasteras, gavle, 122, C);

        worldOne.addNeighbours(kalmar, vaxjo, 97.3, C);
        worldOne.addNeighbours(vaxjo, jonkoping, 108, C);
        worldOne.addNeighbours(kristianstad, kalmar, 153, T);
        worldOne.addNeighbours(kalmar, norrkoping, 214, T);
        worldOne.addNeighbours(helsingborg, kristianstad, 91, CT);
        worldOne.addNeighbours(lund, kristianstad, 70.3, B);
        worldOne.addNeighbours(helsingborg, halmstad, 70.6, BC);
        worldOne.addNeighbours(halmstad, molndal, 120, C);
        worldOne.addNeighbours(molndal, goteborg, 7, B);
        worldOne.addNeighbours(goteborg, karlstad, 233, C);
        worldOne.addNeighbours(linkoping, orebro, 99.1, C);
        worldOne.addNeighbours(karlstad, orebro, 97.6, T);
        worldOne.addNeighbours(karlstad, gavle, 247, CT);
        worldOne.addNeighbours(orebro, eskilstuna, 74.4, CT);
        worldOne.addNeighbours(eskilstuna, sodertalje, 66.4, CT);
        worldOne.addNeighbours(sodertalje, huddinge, 20.8, B);
        worldOne.addNeighbours(huddinge, stockholm, 11.5, B);
        worldOne.addNeighbours(vasteras, uppsala, 67.3, BC);
        worldOne.addNeighbours(gavle, sundsvall, 191, BCT);
        worldOne.addNeighbours(sundsvall, umea, 220, BCT);
        worldOne.addNeighbours(umea, skelleftea, 108, BCT);
        worldOne.addNeighbours(skelleftea, lulea, 109, BCT);

        /*
        worldOne.addNeighbours(linkan, norpan, 10.0, BCT);
        worldOne.addNeighbours(linkan, ryd, 4.0, BC);
        worldOne.addNeighbours(malmslatt, linkan, 6.0, BC);
        worldOne.addNeighbours(malmslatt, ryd, 2.0, B);
        worldOne.addNeighbours(norpan, skarblacka, 6.0, BC);
        worldOne.addNeighbours(soderkoping, norpan, 4.0, BCT);
        worldOne.addNeighbours(soderkoping, skarblacka, 2.0, C);
        */

        /*worldOne.listCities();

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

        }*/

        BalancedAStar a = new BalancedAStar();

        List<City> goals = new ArrayList<>();
        goals.add(linkoping);
        goals.add(kalmar);
        goals.add(orebro);
        goals.add(huddinge);

        MultiGoal mg = new MultiGoal(worldOne, umea, lund, goals, a);

        mg.tryAllPermutations();

        return worldOne;
    }

    private static World initWorldTwo() {

        World worldTwo = new World();

        City linkoping = new City("linkoping");
        City norrkoping = new City("norrkoping");
        City sodertalje = new City("sodertalje");
        City boras = new City("boras");
        City gavle = new City("gavle");
        City umea = new City("umea");

        worldTwo.addCity(linkoping); //1
        worldTwo.addCity(norrkoping); //2
        worldTwo.addCity(sodertalje); //3
        worldTwo.addCity(boras); //4
        worldTwo.addCity(gavle); //5
        worldTwo.addCity(umea); //6

        worldTwo.addNeighbours(linkoping, gavle, 5, B);
        worldTwo.addNeighbours(gavle, boras, 5, B);

        worldTwo.addNeighbours(linkoping, norrkoping, 4, C);
        worldTwo.addNeighbours(norrkoping, sodertalje, 6, C);
        worldTwo.addNeighbours(sodertalje, boras, 4, C);

        worldTwo.addNeighbours(linkoping, umea, 7, T);
        worldTwo.addNeighbours(umea, boras, 7, T);
/*
        worldTwo.listCities();

        System.out.println("linköping has neighbours");
        List<City> tempList = worldTwo.getNeighboursTo(linkoping);
        for(City c : tempList) {
            System.out.println(c.getName());
        }

        List<Route> rs = worldTwo.getRoutesFrom(linkoping);
        System.out.println("linkping has routes to");
        for( Route r : rs) {
            System.out.println(r.getEndCity().getName());
        }
*/
        AStar a = new AStar();
        Stack<City> solution = a.search(worldTwo, linkoping, boras);

        System.out.println("### SOLUTION BELOW");
        while(!solution.isEmpty()) {
            System.out.println(solution.pop().getName());
        }

        return worldTwo;
    }

    private static void printTheWorld(World w) {
        for(Route route: w.getRoutes()){

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
