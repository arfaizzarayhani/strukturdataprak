package strukturdataprak;
public class pembalik {
    private String input;

   
    public pembalik(String input) {
        this.input = input;
    }

    
    public String balik() {
        int panjang = input.length();
        stack stack = new stack(panjang);

        
        for (int i = 0; i < panjang; i++) {
            stack.push(input.charAt(i));
        }

        
        StringBuilder hasil = new StringBuilder();
        while (!stack.isEmpty()) {
            hasil.append(stack.pop());
        }

        return hasil.toString();
    }
}