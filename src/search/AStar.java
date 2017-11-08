package search;

import world.City;
import world.Route;
import world.World;

import java.util.*;

public class AStar {
    Set<City> evaluated = new HashSet<>();
    Queue<City> notEvaluated = new ArrayDeque<>();
    HashMap<City, Double> gScore = new HashMap<>();
    HashMap<City, Double> fScore = new HashMap<>();
    HashMap<City, City> cameFrom = new HashMap<>();

    public Stack<City> search(World world, City start, City goal) {
        notEvaluated.add(start);

        gScore.put(start, 0.0);


        fScore.put(start, estimateCost(start, goal));

        while (!notEvaluated.isEmpty()) {
            City current = getBestEstimatedNode();
            System.out.println("looking at " + current.getName());

            if (current == goal) {
                return constructPath(current);
            }

            notEvaluated.remove(current);
            evaluated.add(current);

            for(Route r : world.getRoutesFrom(current)) {
                City next = r.getEndCity();
                System.out.println("inspecting neighbour " + next.getName());

                if(evaluated.contains(next)) {
                    continue;
                }

                if(!notEvaluated.contains(next)) {
                    notEvaluated.add(next);
                }

                double tmp_gScore = gScore.get(current) + r.getDistance();

                //better path exists
                if ( gScore.containsKey(next) && tmp_gScore >= gScore.get(next)){
                    continue;
                }

                cameFrom.put(next, current);
                gScore.put(next, tmp_gScore);
                fScore.put(next, (tmp_gScore + estimateCost(next, goal)));
            }
        }
        return null;
    }

    public Stack<City> constructPath(City current) {
        Stack<City> path = new Stack<>();
        path.push(current);

        while( cameFrom.keySet().contains(current) ) {
            current = cameFrom.get(current);
            path.push(current);
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
}
