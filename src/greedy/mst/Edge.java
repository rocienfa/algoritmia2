package greedy.mst;

class Edge implements Comparable<Edge> {
    int source, destination, weight;

    public Edge(int s, int d, int w) {
        this.source = s;
        this.destination = d;
        this.weight = w;
    }

    @Override
    public int compareTo(Edge e) {
        return this.weight - e.weight;
    }
}