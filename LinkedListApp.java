package strukturdataprak;
class Link {
    public int Data;
    public Link next;

    public Link (int Data){
        this.Data = Data;
    }
    public void displayLink(){
        System.out.print(Data + " ");
    }
}

class LinkedList{
    private Link first;
    public LinkedList(){
        first = null;
    }
    public boolean isEmpty(){
        return (first == null);
    }
    public void insertFirst(int Data){
        Link newLink = new Link(Data);
        newLink.next = first;
        first = newLink;
    }
    public Link deleteFirst(){
        Link temp = first;
        first = first.next;
        return temp;
    }
    public Link find(int key){
        Link current = first;
        while (current.Data != key){
            if (current.next == null) {
                return null;
            } else {
                current = current.next;
            }
        }
        return current;
    }
    public Link delete(int key){
        Link current = first;
        Link previous = first;
        while (current.Data != key){
            if (current.next == null) {
                return null;
            } else {
                previous = current;
                current = current.next;
            }
        }
        if (current == first) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
        return current;
    }
    public void displayList(){
        System.out.println("List(first --> last): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
    public void insertLast(int Data) {
        Link newLink = new Link(Data);
        if (isEmpty()) {
            first = newLink; // Jika list kosong, node baru jadi first
        } else {
            Link current = first;
            while (current.next != null) { // Cari node terakhir
                current = current.next;
            }
            current.next = newLink; // Hubungkan node terakhir ke node baru
        }
    }
    public Link deleteLast() {
        if (isEmpty()) {
            return null; // List kosong
        }
        Link current = first;
        Link previous = null;
        // Jika hanya satu node
        if (current.next == null) {
            first = null;
            return current;
        }
        // Cari node terakhir dan node sebelumnya
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null; // Putuskan node terakhir
        return current; // Kembalikan node yang dihapus
    }
}
public class LinkedListApp {
    public static void main(String[] args) {
        LinkedList theList = new LinkedList();
        theList.insertFirst(22); 
        theList.insertFirst(44); 
        theList.insertFirst(66); 
        theList.insertFirst(88); 
        theList.displayList(); 

        while (!theList.isEmpty()) {
            Link aLink = theList.deleteFirst();
            System.out.print("Deleted ");
            aLink.displayLink();
            System.out.println("");
        }
        theList.displayList();

        theList.insertFirst(33); 
        theList.insertFirst(55); 
        theList.insertFirst(77); 
        theList.insertFirst(88); 
        theList.displayList(); 

        Link f = theList.find(77);
        if (f != null) {
            System.out.println("ketemu...." + f.Data);
        } else {
            System.out.println("Link tidak ditemukan");
        }
        theList.displayList();
    }
}
