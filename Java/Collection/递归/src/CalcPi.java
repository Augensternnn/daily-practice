public class CalcPi {
    /**
     * 利用公式 Pi / 4 = 1 - 1/3 + 1/5 - 1/7 + 1/9 - ... 计算 pi 的值
     * @param n     一共计算 n 项
     * @return
     */
    public static double calcPi(int n){
        double pi4 = 0;
        for(int i = 1; i <= n; i++){
            int m = 2 * i - 1;
            if(i % 2 == 1){
                pi4 += 1.0 / m;
            }
            if(i % 2 == 0){
                pi4 += 1.0 / ((-1) * m);
            }
        }
        return pi4 * 4;
    }

    public static double calcPi2(int n) {
        double pi4 = 0;
        for (int i = 0; i < n; i++) {
            int m = 2 * i + 1;
            if (i % 2 == 0) {
                // 加
                pi4 = pi4 + 1.0 / m;
            } else {
                // 减
                pi4 = pi4 - 1.0 / m;
            }
        }
        return pi4 * 4;
    }

    public static void main(String[] args) {
        System.out.println(calcPi(5));
        System.out.println("***************");
        System.out.println(calcPi2(5));
    }
}
