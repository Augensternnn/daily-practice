import javax.sql.DataSource;

/**
 * 设计一个日期类
 * 第一步：根据需求列出功能
 *      1. 传 年、月、日 构造日期类
 *      2. 在当前日期上增加多少天
 *      3. 在当前日期上减少多少天
 *      4. 可以返回字符串 String 的方法		”2019-05-20“
 *      5. 加一些限制,年支持的范围 [1900, 2100]
 *      6. 如果给定两个日期，希望计算下两个日期之间相差多少天
 * 第二步：设计属性：        年、月、日
 */
public class Date {
    private int year;
    private int month;
    private int day;

    // 构造方法
    public Date(int year, int month, int day){
        // 至少做最基本的参数检查
        if(year < 1900 || year > 2100){
            // 最好的做法是抛异常
            System.out.println("年输入不合法：" + year);
            return;
        }
        if(month < 1 || month > 12){
            System.out.println("月输入不合法：" + month);
            return;
        }
        if(day < 1 || day > getDayOfMonth(year, month)){
            System.out.println("日输入不合法：" + day);
            return;
        }

        // 涉及 name shadow
        this.year = year;
        this.month = month;
        this.day = day;
    }
    private Date(Date other){
        this(other.year, other.month, other.day);
    }

    // 支持的方法
    public void add(int days){
        // days 必须是正数
        if(days < 0){
            System.out.println("days 输入不合法：" + days);
            return;
        }
        day += days;
        while (day > getDayOfMonth(year, month)){
            day -= getDayOfMonth(year, month);
            month++;
            if(month > 12){
                month = 1;
                year++;
            }
        }
    }
    public void sub(int days){
        // days 必须是正数
        if(days < 0){
            System.out.println("days 输入不合法：" + days);
            return;
        }
        day -= days;
        while (day < 1){
            month--;
            if (month < 1){
                month = 12;
                year--;
            }
            day += getDayOfMonth(year, month);
        }
    }
    public String toString(){
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    // 返回 d1 和 d2 之间相差的天数       要求：d1 > d2
    public static int differ(Date d1, Date d2){
        if(!isGreatThan(d1, d2)){
            System.out.println("d1 需大于 d2");
            return -1;
        }
        int days = 0;
        Date tmp = new Date(d1);
        while (isGreatThan(tmp, d2)){
            tmp.sub(1);
            days++;
        }
        return days;
    }


    // 内部使用的方法：private
    private static final int[] DAY_OF_MONTH = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    private static int getDayOfMonth(int year, int month){
        int days = DAY_OF_MONTH[month - 1];
        if(month == 2 && isLeapYear(year)){
            days = 29;
        }
        return days;
    }
    private static boolean isLeapYear(int year){
        if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
            return true;
        }
        return false;
    }
    private static boolean isGreatThan(Date d1, Date d2){
        if(d1.year > d2.year){
            return true;
        }
        if(d1.year == d2.year && d1.month > d2.month){
            return true;
        }
        if(d1.year == d2.year && d1.month == d2.month && d1.day > d2.day){
            return true;
        }
        return false;
    }

    // 入口的方法
    public static void main(String[] args) {
        Date date = new Date(2019, 5, 20);
        System.out.println(date.toString());
        date.add(10);
        System.out.println(date.toString());
        date.add(10);
        System.out.println(date.toString());
        date.sub(20);
        System.out.println(date.toString());

        Date today = new Date(2019, 5, 20);
        Date intern = new Date(2019, 12, 1);
        System.out.printf("距离12月1日还有 %d 天%n", Date.differ(intern, today));
    }
}
