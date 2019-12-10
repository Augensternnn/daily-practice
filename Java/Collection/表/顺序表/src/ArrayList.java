public class ArrayList {
    private int size = 0;
    private int[] array;

    public ArrayList(){
        array = new int[10];
    }

    public ArrayList(int[] array){
        // 1.this.array 和 array 不是一回事
        // 2.申请的空间至少需要 array.length 长
        this.array = new int[array.length];

        // 把传入数组的所有元素 copy 到属性 array 中
        for(int i = 0; i < array.length; i++){
            this.array[i] = array[i];
        }

        // 记得更新 size
        size = array.length;
    }

    // 将 element 插入到 index 所在的下标位置
    // 要求：对 index 做合法性检验
    // 最坏情况：index == 0时，时间复杂度为 O(n)
    public void insert(int index, int element){
        if(index < 0 || index > size){
            System.out.printf("index输入不合法，取值范围应为：[0, %d]%n", size);
            return;
        }

        // 确保空间够用，不够则进行扩容
        ensureCapacity();

        // 插入过程
        // 倒着遍历，将 [index, size-1] 内数据往后搬移一格
        for(int i = size - 1; i >= index; i--){
            array[i+1] = array[i];
        }
        array[index] = element;
        size++;
    }


}
