package strukturdataprak;

/**
 *
 * @author ASUS
 */
public class HighArrayStudyCase {

    public static void main(String[] args) {
        HighArray arr = new HighArray(10);

        arr.insert(15);
        arr.insert(30);
        arr.insert(45);
        arr.insert(53);
        arr.insert(77);
        arr.insert(79);
        arr.insert(81);

        arr.insert(66);

        arr.display();
    }
}
