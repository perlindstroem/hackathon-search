package world;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class World {
    private Set<City> cities = new HashSet<>();
    private Set<Neighbours> neighbours = new HashSet<>();

    public World() {

    }

    public void addCity(City city) {
        cities.add(city);
    }

    public void addNeighbours(City c1, City c2, double d, List<Transportation> aT){
        neighbours.add(new Neighbours(c1, c2, d, aT));
    }

    public void listCities() {
        for (City city:cities) {
            System.out.println(city.getName());
        }
    }

    public void printCost(String c1, String c2) {

    }

}
