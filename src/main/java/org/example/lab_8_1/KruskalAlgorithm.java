package org.example.lab_8_1;
import java.util.*;

public class KruskalAlgorithm {

    static class Edge implements Comparable<Edge> {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    static class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }

    public static List<Edge> kruskalMST(List<Edge> edges, int numberOfVertices) {
        List<Edge> minimumSpanningTree = new ArrayList<>();
        Collections.sort(edges);

        UnionFind uf = new UnionFind(numberOfVertices);

        for (Edge edge : edges) {
            int sourceRoot = uf.find(edge.source);
            int destinationRoot = uf.find(edge.destination);

            if (sourceRoot != destinationRoot) {
                minimumSpanningTree.add(edge);
                uf.union(sourceRoot, destinationRoot);
            }
        }

        return minimumSpanningTree;
    }

    public static void main(String[] args) {
        // Пример представления графа в виде списка рёбер
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 4));
        edges.add(new Edge(0, 7, 8));
        edges.add(new Edge(1, 2, 8));
        edges.add(new Edge(1, 7, 11));
        edges.add(new Edge(2, 3, 7));
        edges.add(new Edge(2, 8, 2));
        edges.add(new Edge(2, 5, 4));
        edges.add(new Edge(3, 4, 9));
        edges.add(new Edge(3, 5, 14));
        edges.add(new Edge(4, 5, 10));
        edges.add(new Edge(5, 6, 2));
        edges.add(new Edge(6, 7, 1));
        edges.add(new Edge(6, 8, 6));
        edges.add(new Edge(7, 8, 7));

        int numberOfVertices = 9;

        List<Edge> minimumSpanningTree = kruskalMST(edges, numberOfVertices);

        System.out.println("Кратчайший остов графа (алгоритм Краскала):");
        for (Edge edge : minimumSpanningTree) {
            System.out.println(edge.source + " - " + edge.destination + ": " + edge.weight);
        }
    }
}
