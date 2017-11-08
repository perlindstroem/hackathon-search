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

    public MultiGoal(World world, City start, City end, List<City> goals) {
        this.world = world;
        this.start = start;
        this.end = end;
        this.goals = goals;
    }

    private List<List<City>> generatePermutations() {

            if (goals.size() == 0) {
                List<List<City>> result = new ArrayList<>();
                result.add(new ArrayList<>());
                return result;
            }

            List<List<City>> returnMe = new ArrayList<>();

            City firstElement = goals.remove(0);

            List<List<City>> recursiveReturn = generatePermutations();
            for (List<City> li : recursiveReturn) {

                for (int index = 0; index <= li.size(); index++) {
                    List<City> temp = new ArrayList<>(li);
                    temp.add(index, firstElement);
                    returnMe.add(temp);
                }

            }
            return returnMe;
    }

    public List<City> getBestPermutation() {
        List<List<City>> permutations = generatePermutations();

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

        return best;
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
        SearchAlgorithm sa;

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
