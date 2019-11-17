package test1114;

public class Test {
    public static void main(String[] args) {
        System.out.println(new B().getVal());
    }
    static class A{
        protected int val;
        public A(int v)
        {
            setVal(v);
        }
        public void setVal(int val){
            this.val = val;
        }
        public int getVal(){
            try {
                val++;
                return val;
            }catch (Exception e){
                System.out.println(e.toString());
            }finally {
                this.setVal(val);
                System.out.println(val);
            }
            return val;
        }
    }
    static class B extends A{
        public B(){
            super(5);
            setVal(getVal()-3);
        }
        public void setVal(int val){
            super.setVal(2*val);
        }

    }
}

