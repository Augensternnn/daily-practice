package test1127;

public class JudgeSubstring {
    public boolean[] chkSubstr(String[] p, int n, String s){
        if(p.length > 500 || s.length() > 1000)
            return null;
        boolean[] ans = new boolean[n];
        for(int i = 0; i < n; i++){
            String str = p[i];
            if(str.length() > 8) {
                return null;
            }else {
                if(s.indexOf(str) > -1){
                    ans[i] = true;
                }else {
                    ans[i] = false;
                }
            }
        }
        return ans;
    }
}
