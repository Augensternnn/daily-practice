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
        System.out.println("contains node2: "+nodes.contains(node2));   // true
        System.out.println("index of node2: "+nodes.indexOf(node2));    // 0
        System.out.println("get value: "+nodes.get(nodes.indexOf(node2)).value);    // 1

        System.out.println("contains node3: "+nodes.contains(node3));   // true
        System.out.println("index of node3: "+nodes.indexOf(node3));    // 0
        System.out.println("get value: "+nodes.get(nodes.indexOf(node3)).value);    // 1
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
}
