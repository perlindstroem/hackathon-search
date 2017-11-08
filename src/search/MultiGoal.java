package search;

import world.City;
import world.World;

import java.util.ArrayList;
import java.util.List;

public class MultiGoal {
    World world;
    City start;
    City end;
    List<City> goals;
    List<List<City>> permutations;
    SearchAlgorithm sa;

    public MultiGoal(World world, City start, City end, List<City> goals, SearchAlgorithm sa) {
        this.world = world;
        this.start = start;
        this.end = end;
        this.goals = goals;
        this.sa = sa;
    }

    private List<List<City>> generatePermutations() {

            if (goals.size() == 0) {
                List<List<City>> result = new ArrayList<List<City>>();
                result.add(new ArrayList<City>());
                return result;
            }

            List<List<City>> returnMe = new ArrayList<List<City>>();

            City firstElement = goals.remove(0);

            List<List<City>> recursiveReturn = generatePermutations();
            for (List<City> li : recursiveReturn) {

                for (int index = 0; index <= li.size(); index++) {
                    List<City> temp = new ArrayList<City>(li);
                    temp.add(index, firstElement);
                    returnMe.add(temp);
                }

            }
            return returnMe;
    }

    public void tryAllPermutations() {
        permutations = generatePermutations();

        List<City> best = null;
        double bestCost = -1;


        for( List<City> permutation : permutations ){
            double cost = search(permutation, false);

            if(bestCost < 0 || bestCost > cost){
                best = permutation;
                bestCost = cost;
                continue;
            }
        }

        System.out.println("%%%% BEST permutation %%%");
        search(best, true);
    }

    /*public void search(boolean print) {
        double totalCost = 0;
        City current = start;

        for( City goal : goals) {
            sa.search(world, current, goal, print);
            totalCost += sa.getTotalCost();
            current = goal;
            sa.clear();
        }

        sa.search(world, current, end, print);
        totalCost += sa.getTotalCost();

        System.out.println("Cost for reaching all goals: " + totalCost);
    }*/

    public double search(List<City> goals, boolean print) {
        double totalCost = 0;
        City current = start;

        for( City goal : goals) {
            sa = new BalancedAStar();
            sa.search(world, current, goal, print);
            totalCost += sa.getTotalCost();
            current = goal;
        }

        sa = new BalancedAStar();
        sa.search(world, current, end, print);
        totalCost += sa.getTotalCost();

        System.out.println("Cost for this permutation: " + totalCost);

        return totalCost;
    }

}
