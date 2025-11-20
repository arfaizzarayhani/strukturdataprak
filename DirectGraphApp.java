package strukturdataprak;

public class DirectGraphApp {
    public static void main(String[] args) {
        DirectGraph theGraph = new DirectGraph();

        theGraph.addVertex('A'); // 0
        theGraph.addVertex('B'); // 1
        theGraph.addVertex('C'); // 2
        theGraph.addVertex('D'); // 3
        theGraph.addVertex('E'); // 4
        
        theGraph.addEdge(1, 0); // B -> A
        theGraph.addEdge(0, 2); // A -> C
        theGraph.addEdge(1, 4); // B -> E
        theGraph.addEdge(3, 4); // D -> E
        theGraph.addEdge(4, 2); // E -> C

        // Tampilkan hasil
        theGraph.displayEdges();
        theGraph.connectivityTable();
        theGraph.topologicalSort();
    }
}
