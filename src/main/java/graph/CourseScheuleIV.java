package graph;

import java.util.*;

/**
 * solution for leetcode: 1462
 */
public class CourseScheuleIV {

    public static void main(String[] args) {

        int n = 5;
        int[][] prereq = new int[][]{new int[]{0,1}, new int[]{1,2}, new int[]{2,3}, new int[]{3,4}};
        int[][] queries = new int[][]{new int[]{0,4}, new int[]{4,0}, new int[]{1,3}, new int[]{3,0}};
        List<Boolean> out = checkIfPrerequisite(n, prereq, queries);
        //Expected output-> true, false, true, false

        for (Boolean b : out) {
            System.out.print( b + " ");
        }

    }

    public static List<Boolean> checkIfPrerequisite(int n, int[][] prereq, int[][] queries) {
        List<Integer>[] adjs = new ArrayList[n];
        for (int[] pr : prereq) {
            if (adjs[pr[0]] == null) {
                adjs[pr[0]] = new ArrayList<>();
            }
            adjs[pr[0]].add(pr[1]);
        }

        int[][] matrix = new int[n][n];
        for (int i=0; i<n; i++) {
            bfs(i, adjs, matrix);
        }

        List<Boolean> output = new ArrayList<>();
        for (int[] q : queries) {
            output.add(matrix[q[0]][q[1]] == 1);
        }
        return output;
    }

    private static void bfs(int vertex, List<Integer>[] adjs, int[][] matrix) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(vertex);
        visited.add(vertex);
        while (!q.isEmpty()) {
            int v = q.poll();
            if (adjs[v] != null) {
                for (int e : adjs[v]) {
                    if (!visited.contains(e)) {
                        matrix[vertex][e] = 1;
                        visited.add(e);
                        q.offer(e);
                    }
                }
            }
        }
    }
}
