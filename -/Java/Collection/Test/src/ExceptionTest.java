import org.junit.Test;

public class ExceptionTest {
    @Test
    public void test1(){
        System.out.println(ex1());
    }

    public static int ex1(){
        try {
//            Integer i = 0;
            Integer i = null;
            int num = 1/i;
            return 1;
        }catch (NullPointerException e){
            System.out.println("NullPointerException");
            return 2;
        }catch (RuntimeException e) {
            System.out.println("RuntimeException");
            return 3;
        }catch (Exception e){
            System.out.println("Exception");
            return 4;
        }finally {
            System.out.println("finally");
            return 5;
        }
    }

    @Test
    public void test2(){
        try {
            ex3();
        }catch (Exception e){
            Throwable t = e.getCause();
        }
    }

    public static void ex2(){
        throw new RuntimeException("ex2");
    }

    public static void ex3(){
        try {
            ex2();
        }catch (Exception e){

            throw new RuntimeException("ex3", e);
        }
    }
}
