package strukturdataprak;

import java.util.Scanner;

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
            output.append(stack.pop());
        }
        return output.toString();
    }
}

public class AppPembalik {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Masukkan kata: ");
            String kata = scanner.nextLine();
            if (kata.isEmpty()) break; // keluar jika input kosong
            Pembalik pembalik = new Pembalik(kata);
            String hasil = pembalik.balikKata();
            System.out.println("kebalikan: " + hasil);
        }
    }
}
