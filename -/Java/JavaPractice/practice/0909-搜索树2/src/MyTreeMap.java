import java.util.Comparator;

// 泛型实现
    // 这里的 K, V 是类型变量，形参
public class MyTreeMap<K, V> {
    // 这里的 M, N 是类型变量，形参
    public static class Entry<M, N>{
        // 这里的M，N是类型变量，是M，N背后类型的运用
        private M key;
        private N value;

        private Entry<M, N> left;
        private Entry<M, N> right;
    }

    /*
    class Tree<K, V>{
        static class Node<M, N>{}
        Node<K, V>
    }
     */
    private Entry<K, V> root;
    private Comparator<K> comparator = null;

    public MyTreeMap(Comparator<K> comparator){
        this.comparator = comparator;
    }
    public  MyTreeMap(){
    }

    public V get(K key){
        Entry<K, V> cur = root;
        while(cur != null){
            //
        }
    }
}
