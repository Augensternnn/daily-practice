package List.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> person = new ArrayList<>();
        person.add(new Person(10,"Jack"));
        person.add(new Person(12,"James"));
        person.add(new Person(15,"Rose"));
        person.clear();

        //提醒JVM进行垃圾回收
        System.gc();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("list - finalize");
    }
}
