public class InitArray {
    // 初始化数组
    public static void initArray(){
        int[] array = {1, 2, 3, 4, 5};
        printArray(array);

        System.out.println("******************");

        printArray(new int[]{6, 7, 8, 9, 0});

        System.out.println("******************");

        int[] arr = null;
        arr = new int[10];
        for(int i = 0; i < 10; i++){
            arr[i] = i;
        }
        printArray(arr);

    }

    public static void printArray(int[] array){
        for(int item : array){
            System.out.printf(item + "\t");
        }
        System.out.println();
        for(int i = 0; i < array.length; i++){
            System.out.printf(array[i] + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        initArray();
    }
}
