public class Practices {
    // 查找
    public static void find(){
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        for(int i = 0; i < array.length; i++){
            if(array[i] == 4){
                System.out.printf("找到 %d 了", array[i]);
                break;
            }
        }
        int[][] twoArray = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 },
        };
        found:
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    if(twoArray[i][j] == 5){
                        break found;
                        // continue found;
                    }
                }
            }
    }

    // 计算正数 n 的位数
    public static int calcDigit(long n){
        int digitNum = 0;
        for(; n > 0; n = n / 10){
            digitNum++;
        }
        return digitNum;
    }

    // foreach 循环
    public static void foreach(int[] array){
        for(int item : array){
            System.out.printf(item + "\t");
        }
        System.out.println();
    }

    // 打印乘法口诀表
    public static void displayMutipyCation() {
        for(int i = 1; i <= 9; i++){
            for(int j = 1; j <= i; j++){
                System.out.printf("%d * %d = %d\t", j, i, i * j);
            }
            System.out.println();
        }
    }

    // 反转字符串
    public static String reverse(String s){
        int length = s.length();
        String r = "";
        for(int i = length - 1; i >= 0; i--){
            r += s.charAt(i);
        }
        return r;
    }

    /**
     * 10 进制转 16 进制，计算公式如下例
     *      1958 转 16 进制
     *      1958 % 16 == 6   1958 / 16 == 122
     *      122 % 16 == 10 也就是 A   122 / 16 == 7
     *      7 < 16
     *      1958 的 16 进制 为 7A6
     * @param dec
     * @return
     */
    public static String decToHex(int dec) {
        String hex = "";
        while (dec >= 16){
            int remainder = dec % 16;
            dec = dec / 16;
            if(remainder < 10){
                hex += remainder;       // 字符串 + int 类型 仍是字符串
            }else{
                char ch = (char)('A' + (remainder - 10));
                hex += ch;
            }
        }
        if(dec != 0){
            hex += dec;
        }
        return reverse(hex);
    }

    public static void main(String[] args) {
        foreach(new int[] {1, 3, 5, 7, 9});
        System.out.println("******************");
        displayMutipyCation();
        System.out.println("******************");
        System.out.println(reverse("hello"));
        System.out.println("******************");
        System.out.println(decToHex(1958));
    }
}
