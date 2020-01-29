public class day10 {
    // 8.字符串转换整数(atoi )
    public static int myAtoi(String str) {
        if(str=="")
            return 0;
        int min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;
        String s = str.replace(" ","");
        int i = 0;
        if((s.charAt(0)!='+')||(s.charAt(0)!='-')){
            while (s.charAt(0)>='0' || s.charAt(0)<='9'){
                i++;
            }
        }else if(s.charAt(0)>='0' || s.charAt(0)<='9'){
            while (s.charAt(0)>='0' || s.charAt(0)<='9'){
                i++;
            }
        }else {
            return 0;
        }
        String res = s.substring(0,i+1);
        int n = Integer.parseInt(res);
        if(n<min){
            return min;
        }else if(n>max){
            return max;
        }
        return n;
    }

    public static void main(String[] args) {
        String s = "42";
        int n = myAtoi(s);
        System.out.println(n);
    }
}
