package strukturdataprak;

class Pembalik {
    private String input;

    public Pembalik(String input) {
        this.input = input;
    }

    public String balikKata() {
        int size = input.length();
        Stack stack = new Stack(size);
        for (int i = 0; i < size; i++) {
            stack.push(input.charAt(i));
        }
        StringBuilder output = new StringBuilder();
        while (!stack.isEmpty()) {
            output.append(stack.pop()); // Benar, hasilnya huruf
        }
        return output.toString();
    }
}

public class AppPembalik {
    public static void main(String[] args) {
        String kata = "kasur"; // input langsung di program
        System.out.println(">> katanya...");
        System.out.println("    " + kata);
        Pembalik pembalik = new Pembalik(kata);
        String hasil = pembalik.balikKata();
        System.out.println(">> dibalik jadi...");
        System.out.println("    " + hasil);
    }
}

