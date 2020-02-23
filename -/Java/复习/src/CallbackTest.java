public class CallbackTest {
    /**
     * 先在执行一个逻辑之后，插入一段动态的程序片段，
     * 这个程序片段可以有不同的逻辑
     * @param callback
     */
    public static void test(Callback callback){
        System.out.println("test");
        callback.doCallback();
    }

    public static void main(String[] args) {
        // 场景1，调用test()后，打印success
        System.out.println("==============场景1==============");
        test(new Callback() {
            @Override
            public void doCallback() {
                System.out.println("success");
            }
        });
        // 场景2，调用test()后，打印fail
        System.out.println("==============场景2==============");
        test(new Callback() {
            @Override
            public void doCallback() {
                System.out.println("fail");
            }
        });
    }
}
interface Callback{
    void doCallback();
}
