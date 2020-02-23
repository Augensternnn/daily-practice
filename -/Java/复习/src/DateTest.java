import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        System.out.println(new Date());
        Date date = new Date();
        // 日期格式化类
        DateFormat df = new SimpleDateFormat
                ("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(date));
        // 代表格林威治时间1970-01-01 00：00：00到目前的毫秒数
        System.out.println(date.getTime());
        System.out.println(System.currentTimeMillis());
    }
}
