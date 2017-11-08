package search;

import transport.Transport;
import world.City;
import world.Route;
import world.World;

import java.util.*;

public class BalancedAStar implements SearchAlgorithm {
    private Set<City> evaluated = new HashSet<>();
    private Queue<City> exploreQueue = new ArrayDeque<>();
    private HashMap<City, Double> gScore = new HashMap<>();
    private HashMap<City, Double> fScore = new HashMap<>();
    private HashMap<City, Transport> transport = new HashMap<>();
    private HashMap<City, City> cameFrom = new HashMap<>();

    private double timeWeight = 1;
    private double environmentWeight = 1;
    private double totalCost = 0;

    public void clear(){
        evaluated.clear();
        exploreQueue.clear();
        gScore.clear();
        fScore.clear();
        transport.clear();
        cameFrom.clear();
        totalCost = 0;
    }

    public Stack<Leg> search(World world, City start, City goal, boolean print) {
        exploreQueue.add(start);

        gScore.put(start, 0.0);
        fScore.put(start, estimateCost(start, goal));

        while (!exploreQueue.isEmpty()) {
            City current = getBestEstimatedNode();
            //System.out.println("looking at " + current.getName());

            if (current == goal) {
                Stack<Leg> solution = constructPath(current);
                totalCost = gScore.get(goal);
                if(print) printPath(solution);
                return solution;
            }

            exploreQueue.remove(current);
            evaluated.add(current);

            for(Route r : world.getRoutesFrom(current)) {
                City next = r.getEndCity();
                //System.out.println("inspecting neighbour " + next.getName());

                //already evaluated
                if(evaluated.contains(next)) {
                    continue;
                }

                //found new city
                if(!exploreQueue.contains(next)) {
                    exploreQueue.add(next);
                }

                //loop over available transports
                for(Transport t : r.getAvailableTransport()){
                    double new_gScore = (environmentWeight * t.getEnvironmentCost()) + (timeWeight * t.getTimeCost());

                    double tmp_gScore = gScore.get(current) + new_gScore;

                    //better path exists
                    if ( gScore.containsKey(next) && tmp_gScore >= gScore.get(next)){
                        continue;
                    }

                    transport.put(next, t);
                    cameFrom.put(next, current);
                    gScore.put(next, tmp_gScore);
                    fScore.put(next, (tmp_gScore + estimateCost(next, goal)));
                }


            }
        }
        return null;
    }

    public Stack<Leg> constructPath(City current) {
        Stack<Leg> path = new Stack<>();
        path.push(new Leg(current, transport.get(current)));

        while( cameFrom.keySet().contains(current) ) {
            current = cameFrom.get(current);
            path.push(new Leg(current, transport.get(current)));
        }

        return path;
    }

    public City getBestEstimatedNode() {
        City best = null;
        for ( City node : exploreQueue) {
            if (best == null) {
                best = node;
            } else if (fScore.get(node) < fScore.get(best)) {
                best = node;
            }
        }
        return best;
    }

    public double estimateCost(City a, City b){

        return 0.0;
    }

    public void printPath(Stack<Leg> path){
        System.out.println("### SOLUTION BELOW");
        boolean first = true;

        while(!path.isEmpty()) {
            Leg l = path.pop();
            if(first){
                System.out.println("Start in " + l.getCity().getName());
                first = false;
            } else {
                System.out.println(l.getTransport().getName() + " to " + l.getCity().getName());
            }
        }

        System.out.println("Total cost was " + getTotalCost());
    }

    public double getTotalCost() {
        return totalCost;
    }
}
