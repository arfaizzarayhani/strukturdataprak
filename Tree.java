package strukturdataprak;
import java.util.Stack;

public class Tree {
    private Node root;
    public Tree() {
        root = null;
    }
    public Node find(int key) {
        Node current = root;
        while (current != null && current.id != key) {
            if (key < current.id) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
        }
        return current;
    }
    // MODIFIKASI INSERT
    public void insert(int id, String data) {
        // Cek apakah key sudah ada
        if (find(id) != null) {
            System.out.println("Duplicate key not allowed: " + id);
            return;
        }
        Node newNode = new Node();
        newNode.id = id;
        newNode.data = data;
        if (root == null) {
            root = newNode;
            return;
        }
        Node current = root;
        Node parent;
        while (true) {
            parent = current;
            if (id < current.id) {
                current = current.leftChild;
                if (current == null) {
                    parent.leftChild = newNode;
                    return;
                }
            } else {
                current = current.rightChild;
                if (current == null) {
                    parent.rightChild = newNode;
                    return;
                }
            }
        }
    }
    // METHOD MENDAPATKAN MINIMUM DAN MAKSIMUM
    public Node getMinimum() {
        Node current = root;
        if (current == null) return null;

        while (current.leftChild != null) {
            current = current.leftChild;
        }
        return current;
    }
    public Node getMaximum() {
        Node current = root;
        if (current == null) return null;

        while (current.rightChild != null) {
            current = current.rightChild;
        }
        return current;
    }
    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;
        while (current != null && current.id != key) {
            parent = current;
            if (key < current.id) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
        }
        if (current == null) {
            return false;
        }
        // Case 1: Node tanpa child
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) root = null;
            else if (isLeftChild) parent.leftChild = null;
            else parent.rightChild = null;
        }
        // Case 2: Node hanya punya left child
        else if (current.rightChild == null) {
            if (current == root) root = current.leftChild;
            else if (isLeftChild) parent.leftChild = current.leftChild;
            else parent.rightChild = current.leftChild;
        }
        // Case 3: Node hanya punya right child
        else if (current.leftChild == null) {
            if (current == root) root = current.rightChild;
            else if (isLeftChild) parent.leftChild = current.rightChild;
            else parent.rightChild = current.rightChild;
        }
        // Case 4: Node punya dua child
        else {
            Node successor = getSuccessor(current);
            if (current == root) root = successor;
            else if (isLeftChild) parent.leftChild = successor;
            else parent.rightChild = successor;
            successor.leftChild = current.leftChild;
        }
        return true;
    }
    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }
    public void traverse(int traverseType) {
        switch (traverseType) {
            case 1:
                System.out.print("Preorder traversal: ");
                preOrder(root);
                break;
            case 2:
                System.out.print("Inorder traversal: ");
                inOrder(root);
                break;
            case 3:
                System.out.print("Postorder traversal: ");
                postOrder(root);
                break;
        }
        System.out.println();
    }
    private void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.id + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }
    private void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.id + " ");
            inOrder(localRoot.rightChild);
        }
    }
    private void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.id + " ");
        }
    }
    public void displayTree() {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("............................................");
        while (!isRowEmpty) {
            Stack localStack = new Stack();
            isRowEmpty = true;
            for (int j = 0; j < nBlanks; j++)
                System.out.print(' ');
            while (!globalStack.isEmpty()) {
                Node temp = (Node) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.id);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if (temp.leftChild != null || temp.rightChild != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            nBlanks /= 2;
            while (!localStack.isEmpty())
                globalStack.push(localStack.pop());
        }
        System.out.println("............................................");
    }
}