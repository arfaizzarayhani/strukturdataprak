package strukturdataprak;
import java.io.*;

public class TreeApp {
    public static void main(String[] args) throws IOException {
        int value;
        String data;
        Tree theTree = new Tree();

        theTree.insert(50, "Ahmad");
        theTree.insert(25, "Rosa");
        theTree.insert(75, "Raisa");
        theTree.insert(12, "Naya");
        theTree.insert(37, "Gagas");
        theTree.insert(43, "Ainun");
        theTree.insert(30, "Beri");
        theTree.insert(33, "Vivid");
        theTree.insert(87, "Orin");
        theTree.insert(93, "Wiwid");
        theTree.insert(97, "Sasa");
        //theTree.insert(55, "Carlos");

        while (true) {
            System.out.print("""
                             
                             Enter first letter of:
                             show, insert, find, delete, traverse,
                             or (m) for Min/Max: """);
            int choice = getChar();

            switch (choice) {
                case 's':
                    theTree.displayTree();
                    break;
                case 'i':
                    System.out.print("Enter value and data to insert: ");
                    value = getInt();
                    data = getString();
                    theTree.insert(value, data);
                    break;
                case 'f':
                    System.out.print("Enter value to find: ");
                    value = getInt();
                    Node found = theTree.find(value);
                    if (found != null) {
                        System.out.print("Found: ");
                        found.displayNode();
                        System.out.print("\n");
                    } else {
                        System.out.println("Could not find " + value);
                    }
                    break;
                case 'd':
                    System.out.print("Enter value to delete: ");
                    value = getInt();
                    boolean didDelete = theTree.delete(value);
                    if (didDelete) {
                        System.out.println("Deleted " + value);
                    } else {
                        System.out.println("Could not delete " + value);
                    }
                    break;
                case 't':
                    System.out.print("Enter type 1, 2 or 3 (Pre, In, Post order): ");
                    value = getInt();
                    theTree.traverse(value);
                    break;

                // Tambahan fitur untuk menampilkan nilai min & max
                case 'm':
                    Node minNode = theTree.getMinimum();
                    Node maxNode = theTree.getMaximum();
                    if (minNode != null && maxNode != null) {
                        System.out.println("Minimum value in tree: " + minNode.id + " (" + minNode.data + ")");
                        System.out.println("Maximum value in tree: " + maxNode.id + " (" + maxNode.data + ")");
                    } else {
                        System.out.println("Tree is empty!");
                    }
                    break;

                default:
                    System.out.println("Invalid entry ");
            }
        }
    }
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }
    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}