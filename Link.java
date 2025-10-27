package strukturdataprak;
public class Link {
    private int iData;
    public Link next;

    public Link(int id) {
        iData = id;
    }
    public void displayLink() {
        System.out.print(iData + " ");
    }
}
