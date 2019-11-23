public class Test {
    private static void testMethod(){
        System.out.println("testMethod");
    }

    public static void main(String[] args) {
        ((Test)null).testMethod();
    }
}
