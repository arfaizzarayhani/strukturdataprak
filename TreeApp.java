package strukturdataprak;
import java.io.*;

public class TreeApp {

    public static void main(String[] args) throws IOException {
        int value;
        String data;
        Tree theTree = new Tree();

        // Data awal
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
        theTree.insert(55, "Carlos");

        while (true) {
            System.out.print("""
                             
                             Enter first letter of:
                             show (s), insert (i), find (f), delete (d),
                             traverse (t), 
                             min (n), max (x), or both (m): """);
            char choice = getChar();

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

                // ✅ Tambahan menu khusus
                case 'n': // Minimum
                    Node minNode = theTree.getMinimum();
                    if (minNode != null) {
                        System.out.println("Minimum value in tree: " + minNode.id + " (" + minNode.data + ")");
                    } else {
                        System.out.println("Tree is empty!");
                    }
                    break;

                case 'x': // Maximum
                    Node maxNode = theTree.getMaximum();
                    if (maxNode != null) {
                        System.out.println("Maximum value in tree: " + maxNode.id + " (" + maxNode.data + ")");
                    } else {
                        System.out.println("Tree is empty!");
                    }
                    break;

                case 'm': // Kedua nilai sekaligus
                    Node minN = theTree.getMinimum();
                    Node maxN = theTree.getMaximum();
                    if (minN != null && maxN != null) {
                        System.out.println("Minimum value: " + minN.id + " (" + minN.data + ")");
                        System.out.println("Maximum value: " + maxN.id + " (" + maxN.data + ")");
                    } else {
                        System.out.println("Tree is empty!");
                    }
                    break;

                default:
                    System.out.println("Invalid entry ");
            }
        }
    }

    // ====== Utility methods untuk input ======
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