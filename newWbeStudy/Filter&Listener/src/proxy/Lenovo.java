package proxy;

/**
 * 真实类
 */
public class Lenovo implements SaleComputer {
    @Override
    public String sale(double money) {
        System.out.println("花"+money+"买了一台电脑");
        return "联想电脑";
    }

    @Override
    public void show() {
        System.out.println("展示电脑...");
    }
}
