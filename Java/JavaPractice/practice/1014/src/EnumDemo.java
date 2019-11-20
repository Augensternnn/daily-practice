import java.util.Arrays;

enum Gender{
    FEMALE,MALE;
}

enum 星期 {
    一(1), 二(2), 三(3), 四(4),五(5), 六(6), 七(7);
    private int day;

    星期(int day) {
        this.day = day;
    }

    public void print() {
        System.out.println(day);
    }
}

public class EnumDemo {
    public static void main(String[] args) {
        Gender gender = Gender.FEMALE;
        // Gender.values();
        // 打印所有的Gender
        System.out.println(gender);
        System.out.println(Arrays.toString(Gender.values()));
        Gender g = Gender.valueOf("FEMALE");
        System.out.println(g);
        System.out.println("**********");
        星期 week = 星期.一;
        week.print();
    }
}
