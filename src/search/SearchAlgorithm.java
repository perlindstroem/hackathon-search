package search;

import world.City;
import world.World;

import java.util.Stack;

public interface SearchAlgorithm {
    public Stack<Leg> search(World world, City start, City goal, boolean print);

    public void clear();

    public double getTotalCost();
}
