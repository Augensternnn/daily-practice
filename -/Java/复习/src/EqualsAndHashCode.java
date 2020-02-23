import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EqualsAndHashCode {
    public static void main(String[] args) {
        Node node1 = new Node("hello", 1);
        Node node2 = new Node("hello", 2);
        Node node3 = new Node("hello");
        List<Node> nodes = new ArrayList<>();
        nodes.add(node1);

        // 是否包含node2、node3？     包含（虽然在堆中不是同一对象，但 name 相同，故集合使用时被判断为同一对象）
                // 判断对象是否一致，是根据 hashCode 和 equals 方法进行判断、比较的
        // 集合中添加的是node1
        // 获取时，虽然node2、node3是new出来的，没有添加到集合中（value也不一样），但是name相同
        System.out.println("contains node2: "+nodes.contains(node2));
        System.out.println("index of node2: "+nodes.indexOf(node2));
        // 集合的 indexOf() 方法：返回指定元素的第一次出现的索引，若不包含该元素则返回 -1
        // 因为在集合使用时 node1、node2 被判断为同一对象，故在使用index方法获取时，会当做node1对象，即在集合中搜索node1对象，并返回他的索引
            // new了很多对象并且这些对象被判断为同一对象，若有一个对象在集合中，但其余对象不在集合中
            // 在使用index方法获取时，即使参数为不在集合中的对象，但是也会将他们当做在集合中的那个对象并获取这个对象的索引（因为它们被判断为同一对象）
        System.out.println("get value: "+nodes.get(nodes.indexOf(node2)).value);

        System.out.println("contains node3: "+nodes.contains(node3));
        System.out.println("index of node3: "+nodes.indexOf(node3));
        System.out.println("get value: "+nodes.get(nodes.indexOf(node3)).value);
    }

    static class Node{
        private String name;
        private int value;
        Node(String name){
            this.name = name;
        }
        Node(String name, int value){
            this.name = name;
            this.value = value;
        }

        // 重写 equals、hashCode 方法，根据 name 属性进行判断
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(name, node.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    // 若将node1、node2、node3放入set中，最后只会存储一个对象
    // 因为被判断为同一对象，就放入一个对象中了

    // List中存储了n个元素，这n个元素可能有重复的值，如何去重？      放入set中
}
