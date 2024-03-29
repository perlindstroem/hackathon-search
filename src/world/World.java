package world;

import transport.Transport;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class World {
    private Set<City> cities = new HashSet<>();
    private Set<Route> routes = new HashSet<>();

    public World() {

    }

    public void addCity(City city) {
        cities.add(city);
    }

    public void addNeighbours(City c1, City c2, double d, List<Transport> aT){
        routes.add(new Route(c1, c2, d, aT));
        routes.add(new Route(c2, c1, d, aT));
    }

    public List<Route> getRoutesFrom (City c) {
        List<Route> routes = new ArrayList<>();

        for(Route r : this.routes){
            if(c.equals(r.getStartCity())){
                routes.add(r);
            }
        }

        return routes;
    }

    public Set<Route> getRoutes(){
        return routes;
    }

    public List<City> getNeighboursTo(City c1){
        List<City> cityList = new ArrayList<>();

        for(Route neighbour : routes){
            if(c1.equals(neighbour.getStartCity())){
                cityList.add(neighbour.getEndCity());
            }
        }

        return cityList;
    }

    public void listCities() {
        for (City city:cities) {
            System.out.println(city.getName());
        }
    }

    public void printCost(String c1, String c2) {

    }

}
