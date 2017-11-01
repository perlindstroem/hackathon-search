import world.City;
import world.World;

public class Runner {


    public static void main(String[] args){
        System.out.println("bla");

        initWorld();
    }

    public static void initWorld(){
        World one = new World();

        one.addCity(new City("linkan"));
        one.addCity(new City("norpan"));

        one.listCities();
    }
}
