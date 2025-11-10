package strukturdataprak;

public class Graph {
    private final int MAX_VERTS = 10;
    private final Vertex[] vertexList;
    private final int[][] adjMat;
    private int nVerts;
    private final Stack theStack;
    private final Queue theQueue;

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        theStack = new Stack(MAX_VERTS);
        theQueue = new Queue(MAX_VERTS);

        // Inisialisasi adjacency matrix
        for (int j = 0; j < MAX_VERTS; j++)
            for (int k = 0; k < MAX_VERTS; k++)
                adjMat[j][k] = 0;
    }
    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }
    // Directed edge (arah start → end)
    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
    }
    public void displayVertex(int v) {
        System.out.print(vertexList[v].label + " ");
    }
    private void resetFlags() {
        for (int i = 0; i < nVerts; i++)
            vertexList[i].wasVisited = false;
    }   
    public void dfs() {
        System.out.print("DFS visit order: ");
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theStack.push(0);

        while (!theStack.isEmpty()) {
            int v = getAdjUnvisitedVertex(theStack.peek());
            if (v == -1)
                theStack.pop();
            else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                theStack.push(v);
            }
        }
        System.out.println();
        resetFlags();
    }
    private int getAdjUnvisitedVertex(int v) {
        for (int i = 0; i < nVerts; i++) {
            if (adjMat[v][i] == 1 && !vertexList[i].wasVisited)
                return i;
        }
        return -1;
    }
    public void bfs() {
        System.out.print("BFS visit order: ");
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theQueue.insert(0);
        int v2;

        while (!theQueue.isEmpty()) {
            int v1 = theQueue.remove();
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                theQueue.insert(v2);
            }
        }
        System.out.println();
        resetFlags();
    }
    public void connectivityTable() {
        System.out.println("\nConnectivity Table:");
        for (int i = 0; i < nVerts; i++) {
            System.out.print(vertexList[i].label + " -> ");
            dfsFromVertex(i);
            resetFlags();
            System.out.println();
        }
    }
    private void dfsFromVertex(int start) {
        vertexList[start].wasVisited = true;
        System.out.print(vertexList[start].label + " ");
        for (int j = 0; j < nVerts; j++) {
            if (adjMat[start][j] == 1 && !vertexList[j].wasVisited)
                dfsFromVertex(j);
        }
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