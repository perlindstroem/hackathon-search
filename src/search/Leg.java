package search;

import transport.Transport;
import world.City;

public class Leg {
    City c;
    Transport t;

    public Leg(City c, Transport t) {
        this.c = c;
        this.t = t;
    }

    public City getCity() {
        return c;
    }

    public Transport getTransport() {
        return t;
    }
}
