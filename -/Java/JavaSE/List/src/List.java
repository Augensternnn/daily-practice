public interface List {
    // 尾插
    boolean add(int element);

    // 数据插入到 index 下标处
    boolean add(int index,int element);

    // 删除指定位置的下标
    int remove(int index);

    int get(int index);

    int set(int index,int element);

    int size();

    boolean isEmpty();
}
