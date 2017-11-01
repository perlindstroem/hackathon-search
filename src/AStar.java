import world.Node;

import java.util.*;

public class AStar {
    Set<Node> evaluated = new HashSet<>();
    Queue<Node> notEvaluated = new ArrayDeque<>();
    HashMap<Node, Integer> gScore = new HashMap<>();
    HashMap<Node, Integer> fScore = new HashMap<>();

    public void search(Node start, Node goal) {
        notEvaluated.add(start);

        LinkedList<Node> cameFrom = new LinkedList<>();

        gScore.put(start, 0);



        fScore.put(start, estimateCost(start, goal));

        while (!notEvaluated.isEmpty()) {
            Node current = getBestEstimatedNode();

            if(current == goal) {
                constructPath(cameFrom, current);
            }


        }

    }

    public Stack<Node> constructPath(LinkedList<Node> cameFrom, Node current) {
        Stack<Node> path = new Stack<>();
        path.push(current);
        for ( Node n:cameFrom ) {
            path.push(n);
        }
        return path;
    }

    public Node getBestEstimatedNode() {
        Node best = null;
        for ( Node node : notEvaluated ) {
            if(best == null) {
                best = node;
            }else if(fScore.get(node) < fScore.get(best)) {
                best = node;
            }
        }
        return best;
    }

    public int estimateCost(Node a, Node b){


        return 0;
    }
}
