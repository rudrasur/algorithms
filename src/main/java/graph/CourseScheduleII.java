package graph;

import java.util.LinkedList;
import java.util.Stack;

public class CourseScheduleII {

    public static void main(String[] args) {
        int[][] prereq = new int[][]{new int[]{1,0}, new int[]{0,1}};
        int[] out = findOrder(2, prereq);
        for (int o : out) {
            System.out.print(o + " ");
        }
    }

    public static int[] findOrder(int n, int[][] prereq) {
        CourseScheduleII.Graph g = new Graph(n);
        for (int[] pr : prereq) {
            g.addEdge(pr[1], pr[0]);
        }

        if (g.hasCycle()) {
            return new int[0];
        }
        Stack<Integer> st = g.topologicalSort();
        int[] out = new int[st.size()];
        int i=0;
        while(!st.isEmpty()) {
            out[i++] = st.pop();
        }

        return out;
    }

    private static class Graph {
        private int v;
        private LinkedList<Integer> adj[];

        Graph(int v) {
            this.v = v;
            adj = new LinkedList[v];
            for (int i=0; i<v; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int u, int v) {
            adj[u].add(v);
        }

        public void dfs(int node, Stack<Integer> st, boolean[] visited) {
            visited[node] = true;
            for (int child : adj[node]) {
                if (!visited[child]) {
                    dfs(child, st, visited);
                }
            }
            st.push(node);
        }

        public boolean dfsCycle(int node, boolean[] visited) {
            if (visited[node]) {
                return true;
            }
            visited[node] = true;
            for (int child : adj[node]) {
                if (dfsCycle(child, visited)) {
                    return  true;
                }
            }
            visited[node] = false;
            return false;
        }

        public boolean hasCycle() {
            boolean[] visited = new boolean[v];
            for (int i=0; i<v; i++) {
                if (dfsCycle(i, visited)) {
                    return true;
                }
            }
            return false;
        }

        public Stack<Integer> topologicalSort() {
            boolean[] visited = new boolean[v];
            Stack<Integer> st = new Stack<>();
            for (int i=0; i<v; i++) {
                if (!visited[i]) {
                    dfs(i, st, visited);
                }
            }
            return st;
        }
    }
}
