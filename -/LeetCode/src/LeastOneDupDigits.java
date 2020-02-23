public class LeastOneDupDigits {
//    public int numDupDigitsAtMostN(int N) {
//
//    }
    public static void main(String[] args) {
        int n = 199;
        int count = 0;
        for(int i = 11; i <= n; i++){
            if(isPalindrome(i)) {
                count++;
            }else {
                continue;
            }
        }
        if(n / 100 > 0){
            count += n / 100;
        }
        if(n > 100 || n <= 1000){
            if((n/10) >= ((n/100)+(n/100)*10)){
                if((n/10) == ((n/100)+(n/100*10))){
                    count += (n - ((n/100)+(n/100*10)) + ((n/100)-1)*9);
                }else {
                    count += (n/100)*9;
                }
            }
        }
        System.out.println(count);
    }
    public static boolean isPalindrome(int n){
        String s = String.valueOf(n);
        int i = 0;
        int j = s.length() - 1;
        while (i < j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
