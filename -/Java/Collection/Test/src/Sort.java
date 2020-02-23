import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort {
    public static void main(String[] args) {
//        System.out.println(f(8));
        sort();
    }

    public static int f(int n){
        System.out.println(n);
        return n<2 ? 0 : f(n-1)+f(n-2);
    }

    /**
     * int[]数组使用Arrays.sort方式
     */
    public static void sort(){
        Person p1 = new Person("a", 11);
        Person p2 = new Person("b", 21);
        Person p3 = new Person("c", 21);
        Person p4 = new Person("d", 15);
        Person p5 = new Person("e", 55);
        List<Person> list = new ArrayList<>();
        list.add(p3);
        list.add(p5);
        list.add(p2);
        list.add(p1);
        list.add(p4);
        // 第一种
//        Collections.sort(list);
        // 第二种
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.age-o2.age;
            }
        });
        System.out.println(list);
    }
    static class Person implements Comparable<Person>{
        private String name;
        private int age;

        public Person(String name, int age){
            this.name = name;
            this.age = age;
        }

        //数据库排序：order by age,name
        @Override
        public int compareTo(Person o) {
            if (age==o.age)
                return name.compareTo(o.name);
            return age-o.age;
//            return Integer.compare(age,o.age);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
