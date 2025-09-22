package strukturdataprak;

import java.util.Scanner;

public class AppPembalik {
    public static void main(String[] args) {
        //output a
        String kataHardcode = "kasur";
        System.out.println(">> katanya...");
        System.out.println(kataHardcode);
        pembalik p1 = new pembalik(kataHardcode);
        String hasil1 = p1.balik();
        System.out.println(">> dibalik jadi...");
        System.out.println(hasil1);
        System.out.println(); 
        Scanner sc = new Scanner(System.in);
        String kata;
        while (true) {
            System.out.print("Masukkan kata: ");
            kata = sc.nextLine();       
            if (kata.equals("")) break;
            pembalik p = new pembalik(kata);
            String hasil = p.balik();
            System.out.println("Kebalikan: " + hasil);
        }
        sc.close();
    }
}