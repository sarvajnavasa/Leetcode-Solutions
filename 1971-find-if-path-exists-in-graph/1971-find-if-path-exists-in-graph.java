import java.util.*;

class Solution {

    public boolean validPath(
            int n,
            int[][] edges,
            int source,
            int destination) {

        // Create graph
        ArrayList<ArrayList<Integer>> graph =
            new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Visited array
        boolean[] visited = new boolean[n];

        // DFS
        return dfs(graph, source, destination, visited);
    }

    private boolean dfs(
            ArrayList<ArrayList<Integer>> graph,
            int node,
            int destination,
            boolean[] visited) {

        // Destination reached
        if (node == destination) {
            return true;
        }

        visited[node] = true;

        for (int neighbour : graph.get(node)) {

            if (!visited[neighbour]) {

                if (dfs(graph, neighbour,
                        destination, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}