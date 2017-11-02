import world.*;

import java.util.ArrayList;
import java.util.List;

public class Runner {


    public static void main(String[] args){
        System.out.println("bla");

        initWorld();
    }

    private static void initWorld(){
        World one = new World();


        City linkan = new City("linkan");
        City norpan = new City("norpan");
        City ryd = new City("ryd");
        City skarblacka = new City("skarblacka");

        one.addCity(linkan);
        one.addCity(norpan);
        one.addCity(ryd);
        one.addCity(skarblacka);

        List<Transportation> aT1 = new ArrayList<>();

        aT1.add(new Bike());
        aT1.add(new Car());

        one.addNeighbours(linkan, norpan, 10.0, aT1);

        List<Transportation> aT2 = new ArrayList<>();

        aT2.add(new Bike());
        one.addNeighbours(linkan, ryd, 4.0, aT2);

        List<Transportation> aT3 = new ArrayList<>();

        aT3.add(new Car());
        one.addNeighbours(norpan, skarblacka, 6.0, aT3);

        one.listCities();
    }
}
