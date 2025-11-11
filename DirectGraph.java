package strukturdataprak;

import java.util.Stack;

public class DirectGraph {

    private final int MAX_VERTS = 20;
    private Vertex vertexList[];
    private int adjMat[][];
    private int nVerts;
    private Stack<Integer> theStack;

    public DirectGraph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        theStack = new Stack<>();

        // inisialisasi matriks adjacency ke 0
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
    }
    // menambah simpul (vertex)
    public void addVertex(char label) {
        vertexList[nVerts++] = new Vertex(label);
    }
    // menambah sisi (edge) berarah dari start ke end
    public void addEdge(int start, int end) {
        adjMat[start][end] = 1; // hanya satu arah (directed)
    }
    // menampilkan daftar edge
    public void displayEdges() {
        System.out.println("Adjecency:");
        for (int row = 0; row < nVerts; row++) {
            for (int col = 0; col < nVerts; col++) {
                if (adjMat[row][col] == 1) {
                    System.out.println(vertexList[row].label + " --> " + vertexList[col].label);
                }
            }
        }
        System.out.println();
    }

    // menampilkan adjacency matrix
    public void displayAdjMatrix() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < nVerts; i++) {
            for (int j = 0; j < nVerts; j++) {
                System.out.print(adjMat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    // mencari tetangga yang belum dikunjungi
    private int getAdjUnvisitedVertex(int v) {
        for (int j = 0; j < nVerts; j++) {
            if (adjMat[v][j] == 1 && !vertexList[j].wasVisited) {
                return j;
            }
        }
        return -1;
    }
    // menampilkan tabel koneksi (Connectivity Table)
    public void connectivityTable() {
        System.out.println("Connectivity Table:");
        for (int i = 0; i < nVerts; i++) {
            // reset kunjungan sebelum DFS
            for (int j = 0; j < nVerts; j++) {
                vertexList[j].wasVisited = false;
            }

            dfsFromVertex(i);
        }
    }
    // melakukan DFS dari vertex tertentu
    private void dfsFromVertex(int start) {
        theStack.clear();
        vertexList[start].wasVisited = true;
        System.out.print(vertexList[start].label + " ");
        theStack.push(start);

        while (!theStack.isEmpty()) {
            int v = getAdjUnvisitedVertex(theStack.peek());
            if (v == -1) {
                theStack.pop();
            } else {
                vertexList[v].wasVisited = true;
                System.out.print(vertexList[v].label + " ");
                theStack.push(v);
            }
        }
        System.out.println();
    }
}
