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
    public void addVertex(char label) {
        vertexList[nVerts++] = new Vertex(label);
    }
    public void addEdge(int start, int end) {
        adjMat[start][end] = 1; // hanya satu arah (directed)
    }
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
    private int getAdjUnvisitedVertex(int v) {
        for (int j = 0; j < nVerts; j++) {
            if (adjMat[v][j] == 1 && !vertexList[j].wasVisited) {
                return j;
            }
        }
        return -1;
    }
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
    public void topologicalSort() {
        int origVerts = nVerts;
        char[] sortedArray = new char[nVerts];

        while (nVerts > 0) {
            int currentVertex = noSuccessors();
            if (currentVertex == -1) {
                System.out.println("Error: Graph has cycles.");
                return;
            }
            sortedArray[nVerts - 1] = vertexList[currentVertex].label;
            deleteVertex(currentVertex);
        }
        System.out.print("\nTopological order: ");
        for (int i = 0; i < origVerts; i++)
            System.out.print(sortedArray[i] + " ");
        System.out.println();
    }
    private int noSuccessors() {
        boolean isEdge;
        for (int row = 0; row < nVerts; row++) {
            isEdge = false;
            for (int col = 0; col < nVerts; col++) {
                if (adjMat[row][col] > 0)
                    isEdge = true;
            }
            if (!isEdge)
                return row;
        }
        return -1;
    }
    private void deleteVertex(int delVert) {
        if (delVert != nVerts - 1) {
            for (int j = delVert; j < nVerts - 1; j++)
                vertexList[j] = vertexList[j + 1];

            for (int row = delVert; row < nVerts - 1; row++)
                moveRowUp(row, nVerts);
            for (int col = delVert; col < nVerts - 1; col++)
                moveColLeft(col, nVerts - 1);
        }
        nVerts--;
    }
    private void moveRowUp(int row, int length) {
        for (int col = 0; col < length; col++)
            adjMat[row][col] = adjMat[row + 1][col];
    }
    private void moveColLeft(int col, int length) {
        for (int row = 0; row < length; row++)
            adjMat[row][col] = adjMat[row][col + 1];
    }
    public void displayMatrix() {
        System.out.println("\nAdjacency Matrix:");
        for (int i = 0; i < nVerts; i++) {
            for (int j = 0; j < nVerts; j++) {
                System.out.print(adjMat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
