public class Person implements Comparable<Person> {
    public String name;
    public int age;

    @Override
    public int compareTo(Person o) {
        return age - o.age;
    }
}
