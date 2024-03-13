package greedy.mst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class KruskalMST {
    int nroVertices;
    ArrayList<Edge> edges;

    public KruskalMST(int v) {
        nroVertices = v;
        edges = new ArrayList<>();
    }

    public void addEdge(int s, int d, int w) {
        Edge edge = new Edge(s, d, w);
        edges.add(edge);
    }

    private int find(int[] parent, int i) {
        if (parent[i] == -1)
            return i;

        return find(parent, parent[i]);
    }

    // Union of two sets of x and y
    private void union(int[] parent, int x, int y) {
        int xSet = find(parent, x);
        int ySet = find(parent, y);
        parent[xSet] = ySet;
    }

    public void kruskalMST() {
        Edge[] result = new Edge[nroVertices];
        int[] parent = new int[nroVertices];
        Arrays.fill(parent, -1);

        Collections.sort(edges);

        int e = 0;
        int i = 0;

        while (e < nroVertices - 1 && i < edges.size()) {
            Edge next_edge = edges.get(i++);
            int x = find(parent, next_edge.source);
            int y = find(parent, next_edge.destination);

            if (x != y) {
                result[e++] = next_edge;
                union(parent, x, y);
            }
        }

//        System.out.println("Edges in the MST:");

        int minimumCost = 0;
        for (i = 0; i < e; ++i) {
//            System.out.println(result[i].source + " - " + result[i].destination + ": " + result[i].weight);
            minimumCost += result[i].weight;
        }

        System.out.println("Minimum Cost Spanning Tree: " + minimumCost);
    }

    public static void main(String[] args) {
        int nroVertices = 9;
        KruskalMST graph = new KruskalMST(nroVertices);

        // Adding edges to the graph
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 7, 8);
        graph.addEdge(1, 2, 8);
        graph.addEdge(1, 7, 11);
        graph.addEdge(2, 8, 3);
        graph.addEdge(2, 3, 7);
        graph.addEdge(2, 5, 4);
        graph.addEdge(3, 5, 14);
        graph.addEdge(3, 4, 9);
        graph.addEdge(4, 5, 10);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 7, 1);
        graph.addEdge(6, 8, 6);
        graph.addEdge(7, 8, 7);

        graph.kruskalMST();
    }
}
