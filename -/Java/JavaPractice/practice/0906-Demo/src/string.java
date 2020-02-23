public class string {
    public static void main(String[] args) {
        String s = "900 google.mail.com";
        String[] t = s.split(" ");
        System.out.println(t[0]);
        System.out.println(t[1]);

        // 900 是 String 类型的，要转换为 int 类型
        int n = Integer.valueOf(t[0]);

        String[] u = t[1].split("\\.");
        System.out.println(u[0]);
        System.out.println(u[1]);
        System.out.println(u[2]);

        String[] v = {"google", "com"};
        String w = String.join(".", v);
        System.out.println(w);
    }
}
