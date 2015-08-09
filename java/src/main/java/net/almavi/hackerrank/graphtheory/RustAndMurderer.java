package net.almavi.hackerrank.graphtheory;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

/**
 * https://www.hackerrank.com/challenges/rust-murderer
 *
 * Created by Alex on 09/08/2015.
 */
public class RustAndMurderer {

    private static final byte DEFAULT_DISTANCE = 1;

    public static void main(String[] args) {
        challenge(System.in, System.out);
    }

    public static void challenge(InputStream in, PrintStream out) {
        Scanner input = new Scanner(in);
        int testCases = input.nextInt();
        for (int i = 0; i < testCases; i++) {
            int nodes = input.nextInt();
            Graph graph = new Graph(nodes);
            int edges = input.nextInt();
            for (int j = 0; j < edges; j++) {
                // Normalized to start in ZERO
                int n1 = input.nextInt() - 1;
                int n2 = input.nextInt() - 1;
                graph.add(n1, n2);
            }
            int start = input.nextInt() - 1;

            printTestCaseResult(out, start, dijkstra(graph, start));
            out.print(System.lineSeparator());
        }
    }

    /**
     * Returns an array of distances from starting node to the rest.
     * 0 => distance from starting node to starting node.
     * -1 => non-existing path.
     * 0 < d <= 350 => actual distance.
     * @param graph
     * @param start
     * @return
     */
    public static int[] dijkstra(Graph graph, int start) {
        int[] distances = new int[graph.getSize()];
        for (int i = 0; i < distances.length; i++) {
            if (i != start) {
                distances[i] = graph.exists(start, i) ? 1 : -1;
            }
        }
        boolean[] visited = new boolean[graph.getSize()];
        visited[start] = true;

        Queue<Integer> nodes = new LinkedList<Integer>();
        nodes.add(start);
        Iterator<Integer> iterator = nodes.iterator();
        int visitCount = 0;
        while (iterator.hasNext()) {
            Integer currentNode = iterator.next();
            iterator.remove();
            Set<Integer> adjacent = graph.getNonAdjacentNonVisited(currentNode, visited);
            visited[currentNode] = true;
            visitCount++;

            for (Integer anAdjacent : adjacent) {
                if (!visited[anAdjacent]) {
                    visited[anAdjacent] = true;
                    distances[anAdjacent] = distances[currentNode] + 1;
                    nodes.add(anAdjacent);
                }
            }
            graph.remove(currentNode);
            iterator = nodes.iterator();
        }

        return distances;
    }

    private static void printTestCaseResult(PrintStream out, int start, int[] dijkstra) {
        for (int i = 0; i < dijkstra.length; i++) {
            if (i != start) {
                out.print(dijkstra[i]);
                if (i < dijkstra.length - 1) {
                    out.print(" ");
                }
            }
        }
    }

    public static class Graph {
        private Map<Integer, Set<Integer>> edges = null;
        private int nodes;

        public Graph(Integer nodes) {
            this.nodes = nodes;
            this.edges = new HashMap<Integer, Set<Integer>>();
            for (int i = 0; i < nodes; i++) {
                this.edges.put(i, new HashSet<Integer>());
            }
        }

        public void add(int n1, int n2) {
            this.edges.get(n1).add(n2);
            this.edges.get(n2).add(n1);
        }

        public boolean exists(int n1, int n2) {
            return this.edges.get(n1).contains(n2);
        }

        public Set<Integer> getAdjacent(int n) {
            return this.edges.get(n);
        }

        public void remove(int n) {
            this.edges.remove(n);
            this.nodes--;
        }

        public int getSize() {
            return nodes;
        }

        public Set<Integer> getNonAdjacent(int n) {
            Set<Integer> list = new HashSet<Integer>();
            for (int i = 0; i < this.nodes; i++) {
                if (i != n && !this.edges.get(n).contains(i)) {
                    list.add(i);
                }
            }
            return list;
        }

        public Set<Integer> getNonAdjacentNonVisited(int n, boolean[] visited) {
            Set<Integer> list = new HashSet<Integer>();
            for (int i = 0; i < this.nodes; i++) {
                if (!this.edges.get(n).contains(i) && !visited[i]) {
                    list.add(i);
                }
            }
            return list;
        }
    }
}
