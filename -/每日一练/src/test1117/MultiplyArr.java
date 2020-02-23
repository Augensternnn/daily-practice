package test1117;

public class MultiplyArr {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        for(int i = 1; i < A.length-1; i++){
            int m=1,n = 1;
            for(int j = i+1; j < A.length; j++)
                m *= A[j];
            for(int j = 0; j < i; j++)
                n *= A[j];
            B[i] = m*n;
        }
        int m = 1;
        for(int i = 1; i < A.length; i++){
            m *= A[i];
        }
        B[0] = m;
        int nm=1;
        for(int i = 0; i < A.length-1; i++){
            nm *= A[i];
        }
        B[B.length-1] = nm;
        for(int i = 0; i < B.length; i++){
            System.out.println(B[i]);
        }
        return B;
    }
}
