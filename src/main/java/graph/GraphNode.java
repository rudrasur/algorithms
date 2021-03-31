package graph;

import java.util.ArrayList;
import java.util.List;

public class GraphNode<T> {

    public T data;
    public List<GraphNode<T>> adjacents = new ArrayList<>();
    public Status status = Status.Unvisited;

    public GraphNode(T data) {
        this.data = data;
    }

    public GraphNode(T data, List<GraphNode<T>> adjacents) {
        this.data = data;
        this.adjacents = adjacents;
    }

    @Override
    public String toString() {
        return "GraphNode{" +
                "data=" + data +
                '}';
    }
}

enum Status {
    Visited, Visiting, Unvisited;
}