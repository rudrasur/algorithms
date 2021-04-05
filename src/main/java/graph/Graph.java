package graph;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

public class Graph {

    public static void main(String[] args) {

        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("----------- BFS --------");
        g.bfs(2);
        System.out.println();
        System.out.println("----------- DFS --------");
        g.dfs(2);

    }

    private void bfs(int source) {

        boolean[] visited = new boolean[v];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source] = true;
        while(!q.isEmpty()) {
            int ele = q.poll();
            System.out.print( ele + " ");
            ListIterator<Integer> ad = adj[ele].listIterator();
            while(ad.hasNext()) {
                int next = ad.next();
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }

    private void dfs(int source) {
        boolean[] visited = new boolean[v];
        dfs(source, visited);
    }

    private void dfs(int v, boolean[] visited) {
        System.out.print(v + " ");
        visited[v] = true;
        ListIterator<Integer> it = adj[v].listIterator();
        while(it.hasNext()) {
            int ele = it.next();
            if (!visited[ele]) {
                dfs(ele, visited);
            }
        }
    }

    int v; //No of vertices
    LinkedList<Integer>[] adj;

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v){
        adj[u].add(v);
    }

}
