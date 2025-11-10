package strukturdataprak;

public class GraphApp {
    public static void main(String[] args) {
        Graph theGraph = new Graph();

        // Tambah vertex
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');

        // Tambah edge (directed)
        theGraph.addEdge(0, 1); // A→B
        theGraph.addEdge(0, 2); // A→C
        theGraph.addEdge(1, 3); // B→D
        theGraph.addEdge(2, 4); // C→E
        theGraph.addEdge(3, 4); // D→E

        // Tampilkan hasil
        theGraph.displayMatrix();
        theGraph.dfs();
        theGraph.bfs();
        theGraph.connectivityTable();
        theGraph.topologicalSort();
    }
}
