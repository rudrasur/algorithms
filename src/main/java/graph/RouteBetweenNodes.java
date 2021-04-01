package graph;

import java.util.LinkedList;

public class RouteBetweenNodes {

    public static void main(String[] args) {

        GraphNode<Integer> root = new GraphNode<>(1);
        GraphNode<Integer> _2 = new GraphNode<>(2);
        GraphNode<Integer> _3 = new GraphNode<>(3);
        GraphNode<Integer> _4 = new GraphNode<>(4);
        GraphNode<Integer> _5 = new GraphNode<>(5);
        GraphNode<Integer> _6 = new GraphNode<>(6);

        root.adjacents.add(_2);
        root.adjacents.add(_3);
        root.adjacents.add(_4);

        _2.adjacents.add(_3);
        _4.adjacents.add(_3);
        _4.adjacents.add(_5);
        _3.adjacents.add(_6);
        _5.adjacents.add(_6);

        //System.out.println(checkPath(root, _6)); //True
        System.out.println(checkPath(_4, _2)); // false

    }

    private static boolean checkPath(GraphNode<Integer> start, GraphNode<Integer> end) {
        if (start == end) {
            return true;
        }

        LinkedList<GraphNode<Integer>> q = new LinkedList<>();
        q.add(start);
        start.status = Status.Visiting;
        GraphNode<Integer> u;
        while(!q.isEmpty()) {
            u = q.removeFirst();
            if (u != null) {
                for (GraphNode<Integer> v : u.adjacents) {
                    if (v.status == Status.Unvisited) {
                        if (v == end) {
                            return true;
                        }
                        v.status = Status.Visiting;
                        q.add(v);
                    }
                }
                u.status = Status.Visited;
            }
        }
        return false;
    }
}


