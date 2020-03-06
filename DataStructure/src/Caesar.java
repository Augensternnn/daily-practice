import java.util.Scanner;

public class Caesar {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String mingwen = sc.nextLine();
        int key = sc.nextInt();
        encrypt(mingwen,key);
    }
    public static void encrypt(String words, int key) throws Exception {
        int length = words.length();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char c = words.charAt(i);
            if (c >= 'a' && c <= 'z') {
                c += key % 26;
                if (c < 'a') c += 26;
                if (c > 'z') c -= 26;
            } else if (c >= 'A' && c <= 'Z'){
                c += key % 26;
                if (c < 'A') c += 26;
                if (c > 'Z') c -= 26;
            }
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}

