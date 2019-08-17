public interface List {
    // 尾插
    boolean add(int element);

    // 把数据插入到 index 下标处
    boolean add(int index, int element);

    int get(int index);

    int set(int index, int val);

    // 删除指定位置的数据
    int remove(int index);

    int size();

    boolean isEmpty();

    Iterator iterator();
}
