import org.junit.Test;

import java.io.*;

// Description：序列化和反序列化的实现
public class Serialize {
    public static void main(String[] args) throws Exception {
        serializePerson();
        Person person = deserializePerson();
        System.out.println(person.toString());

        // 输出中 stuID=0；因为stuID用transient修饰，不会被序列化（内置类型为对应0值，引用类型为null）

        // 静态变量的值不会被序列化
        // 静态数据属性是否被序列化的测试：修改类中count变量的值，不进行序列化，直接进行反序列化
        // 结果：count的值变为刚刚修改的值（若其参与序列化，值应该不变的，因为测试是直接进行反序列化）

    }
    /**
     * 序列化
     */
    private static void serializePerson() throws IOException {
        Person person = new Person();
        person.setName("LYT");
        person.setAge(3);
        person.setSex("女");
        person.setStuId(66);
        // ObjectOutputStream 对象输出流，将 person 对象存储到
        // G:\Github\practice\Java\Collection\IO\FileTest\person.txt 文件中，完成对 person 对象的序列化操作
            // writeObject(Object obj)：对参数指定的obj对象进行序列化，把得到的字节序列写到一个目标输出流中
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("G:\\Github\\practice\\Java\\Collection\\IO\\FileTest\\person.txt")));
        oos.writeObject(person);
        System.out.println("person 对象序列化成功");
        oos.close();
    }

    /**
     * 反序列化
     */
    private static Person deserializePerson() throws Exception {
        // ObjectInputStream 对象输入流
            // readObject()：从一个源输入流中读取字节序列，再把它们反序列化为一个对象，并将其返回
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("G:\\Github\\practice\\Java\\Collection\\IO\\FileTest\\person.txt")));
        Person person = (Person) ois.readObject();
        System.out.println("person 对象反序列化成功");
        return person;
    }

}

class Person implements Serializable{

    /**
     * 当我们在类中没有指定 serialVersionUID 的时候，编译器会自动赋值，如果序列化
     * 是以默认的 serialVersionUID ，那么反序列化也是会以那个默认的。
     * 而若以默认的 serialVersionUID 进行序列化，以自己赋值的
     * serialVersionUID 进行反序列化，这样代码就会出问题
     */
//    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private String sex;
    // transient 修饰的变量不能被序列化
    transient private int stuId;
    // static 修饰的变量不能被序列化
    private static int count = 99;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", stuId=" + stuId +
                ", count=" + count +
                '}';
    }
}


