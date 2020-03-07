package _.nowcoder;

/**
 * 风口的猪-中国牛市
 * https://www.nowcoder.com/questionTerminal/9370d298b8894f48b523931d40a9a4aa?orderByHotValue=0&query=%E9%A3%8E%E5%8F%A3%E7%9A%84%E7%8C%AA-%E4%B8%AD%E5%9B%BD%E7%89%9B%E5%B8%82&done=0&pos=1
 */
public class CalculateMax {
    public int calculateMax(int[] prices) {
        int firstBuy = Integer.MIN_VALUE, firstSell = 0;
        int secondBuy = Integer.MIN_VALUE, secondSell = 0;

        for (int curPrice : prices) {
            firstBuy = Math.max(firstBuy, -curPrice);
            firstSell = Math.max(firstSell, firstBuy + curPrice);
            secondBuy = Math.max(secondBuy,firstSell - curPrice);
            secondSell = Math.max(secondSell, secondBuy + curPrice);
        }
        return secondSell;
    }
}
