import transport.Transportation;
import world.City;
import world.Route;
import world.World;

import java.util.*;

public class BalancedAStar {
    Set<City> evaluated = new HashSet<>();
    Queue<City> notEvaluated = new ArrayDeque<>();
    HashMap<City, Double> gScore = new HashMap<>();
    HashMap<City, Double> fScore = new HashMap<>();
    HashMap<City, Transportation> transport = new HashMap<>();
    HashMap<City, City> cameFrom = new HashMap<>();

    double timeWeight = 0;
    double environmentWeight = 0.5;

    public Stack<Leg> search(World world, City start, City goal) {
        notEvaluated.add(start);

        gScore.put(start, 0.0);
        fScore.put(start, estimateCost(start, goal));

        while (!notEvaluated.isEmpty()) {
            City current = getBestEstimatedNode();
            //System.out.println("looking at " + current.getName());

            if (current == goal) {
                Stack<Leg> solution = constructPath(current);
                printPath(solution);
                return solution;
            }

            notEvaluated.remove(current);
            evaluated.add(current);

            for(Route r : world.getRoutesFrom(current)) {
                City next = r.getEndCity();
                //System.out.println("inspecting neighbour " + next.getName());

                if(evaluated.contains(next)) {
                    continue;
                }

                if(!notEvaluated.contains(next)) {
                    notEvaluated.add(next);
                }

                for(Transportation t : r.getAvailableTransportation()){
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
        for ( City node : notEvaluated ) {
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
                System.out.println(l.getCity().getName());
                first = false;
            } else {
                System.out.println(l.getTransport().getName() + " to " + l.getCity().getName());
            }
        }
    }
}
