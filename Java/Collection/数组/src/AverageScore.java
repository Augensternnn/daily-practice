public class AverageScore {
    // 去掉一个最高分、去掉一个最低分，求平均分
    // scores 的长度一定大于 3
    public static double average(int[] scores){
        int maxValue = scores[0];
        int minValue = scores[0];
        int sum = scores[0];
        for(int i = 1; i < scores.length; i++){
            if(scores[i] > maxValue){
                maxValue = scores[i];
            }
            if(scores[i] < minValue){
                minValue = scores[i];
            }
            sum += scores[i];
        }
        return (double)(sum - minValue - maxValue) / (scores.length - 2);
    }
}
