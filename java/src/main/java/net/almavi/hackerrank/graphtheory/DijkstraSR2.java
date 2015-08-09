package net.almavi.hackerrank.graphtheory;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Alex on 08/08/2015.
 */
public class DijkstraSR2 {
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
                graph.add(input.nextInt() - 1, input.nextInt() - 1, input.nextInt());
            }
            int start = input.nextInt() - 1;
            graph.add(start, start, 0);

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
            distances[i] = graph.getDistance(start, i);
        }
        boolean[] visited = new boolean[graph.getSize()];
        visited[start] = true;

        int minNode = getMinNodeNotVisited(distances, visited);
        do {
            visited[minNode] = true;

            Integer[] adjacent = graph.getAdjacent(minNode);
            for (Integer anAdjacent : adjacent) {
                if (distances[anAdjacent] == -1) {
                    if (graph.getDistance(minNode, anAdjacent) > 0) {
                        distances[anAdjacent] = distances[minNode] + graph.getDistance(minNode, anAdjacent);
                    }
                } else {
                    if (graph.getDistance(minNode, anAdjacent) > 0 && distances[anAdjacent] > distances[minNode] + graph.getDistance(minNode, anAdjacent)) {
                        distances[anAdjacent] = distances[minNode] + graph.getDistance(minNode, anAdjacent);
                    }
                }
            }
            minNode = getMinNodeNotVisited(distances, visited);
        } while (minNode != -1);

        return distances;
    }

    private static int getMinNodeNotVisited(int[] distances, boolean[] visited) {
        int min = -1;
        for (int i = 0; i < distances.length; i++) {
            if (!visited[i]) {
                if (distances[i] > 0 && (min == -1 || (distances[i] < distances[min] && distances[i] > 0))) {
                    min = i;
                }
            }
        }
        return min;
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
        private int[][] distance;

        public Graph(int nodes) {
            this.distance = new int[nodes][nodes];
            for (int i = 0; i < this.distance.length; i++) {
                for (int j = 0; j < this.distance[0].length; j++) {
                    this.distance[i][j] = -1;
                }
            }
        }

        public void add(int n1, int n2, int d) {
            int currentDistance = this.distance[n1][n2];
            if (currentDistance == -1 || currentDistance > d) {
                this.distance[n1][n2] = d;
                this.distance[n2][n1] = d;
            }
        }

        public int getDistance(int n1, int n2) {
            return this.distance[n1][n2];
        }

        public int getSize() {
            return distance.length;
        }

        public Integer[] getAdjacent(int n) {
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < this.distance[n].length; i++) {
                if (this.getDistance(n, i) > 0) {
                    list.add(i);
                }
            }
            return list.toArray(new Integer[0]);
        }
    }
}
