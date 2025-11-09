package strukturdataprak;

public class Graph {
    private final int MAX_VERTS = 5;
    private final Vertex[] vertexList;
    private final int[][] adjMat;
    private int nVerts;
    private Stack theStack;
    private Queue theQueue = new Queue(MAX_VERTS);
    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        
        for (int j = 0; j < MAX_VERTS; j++) {
            for (int k = 0; k < MAX_VERTS; k++) {
                adjMat[j][k] = 0;
            }
        }
        
        // Memanggil constructor Stack(int MAX_VERTS)
        theStack = new Stack(MAX_VERTS); 
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1; // Undirected
    }
    
    // METHOD DFS (Depth-First Search)
    public void dfs() {
        System.out.print("Visit by using DFS algorithm: ");
        
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theStack.push(0); 

        while (!theStack.isEmpty()) {
            int v = getAdjUnvisitedVertex(theStack.peek());

            if (v == -1) {
                theStack.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                theStack.push(v);
            }
        }
        System.out.println("");
        resetFlags();
    }
    
    public void displayVertex(int v) {
        System.out.print(vertexList[v].label + " ");
    }
    
    public int getAdjUnvisitedVertex(int v) {
        for (int i = 0; i < nVerts; i++) {
            // Cek koneksi (adjMat[v][i] == 1) dan status kunjungan (wasVisited == false)
            if (adjMat[v][i] == 1 && vertexList[i].wasVisited == false) {
                return i;
            }
        }
        return -1;
    }
    private void resetFlags() {
        for (int i = 0; i < nVerts; i++) {
            vertexList[i].wasVisited = false;
        }
    }
    public void bfs() {
        System.out.println("Visit by using" + " BFS algorithm: ");
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
        System.out.println("");
        resetFlags();
    } 
    public void mst() {
    System.out.println("Minimum spanning" + " tree: ");
    vertexList[0].wasVisited = true;
    theStack.push(0);
    while (!theStack.isEmpty()) {
        int currentVertex = theStack.peek();
        int v = getAdjUnvisitedVertex(currentVertex);
        if (v == -1) {
            theStack.pop();
        } else {
            vertexList[v].wasVisited = true;
            theStack.push(v);
     
            displayVertex(currentVertex);
            System.out.print(" -- ");
            displayVertex(v);
            System.out.println("");
       }
    }
    resetFlags();
    }
    public void display() {
        System.out.println("Adjacency:");
        for (int j = 0; j < nVerts; j++) {
            for (int i = 0; i < nVerts; i++) {
                // Cek apakah ada sisi dari j ke i
                if (adjMat[j][i] == 1) {
                    System.out.println(vertexList[i].label + " -- " + vertexList[j].label);
                }
            }
        }
        System.out.println("");
    }
}