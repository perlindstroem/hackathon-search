package search;

import transport.Transportation;
import world.City;

public class Leg {
    City c;
    Transportation t;

    public Leg(City c, Transportation t) {
        this.c = c;
        this.t = t;
    }

    public City getCity() {
        return c;
    }

    public Transportation getTransport() {
        return t;
    }
}
