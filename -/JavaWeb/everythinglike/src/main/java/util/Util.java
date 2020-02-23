package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
    public static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 解析文件大小为中文描述
     * @param size
     * @return
     */
    public static String parseSize(long size) {
        String[] danweis = {"B","KB","MB","GB","PB","TB"};
        int idx = 0;
        while (size>1024 && idx<danweis.length-1) {
            size /= 1024;
            idx++;
        }
        return size+danweis[idx];
    }

    /**
     * 解析日期为中文描述
     * @param lastModified
     * @return
     */
    public static String parseDate(Date lastModified) {
        return new SimpleDateFormat(DATE_PATTERN).format(lastModified);
    }

    public static void main(String[] args) {
        System.out.println(parseSize(100_000_000_000_000L));
        System.out.println(parseDate(new Date( )));
    }



}

