package com.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义类型转换器
 * 把字符串日期转换成日期类型
 */
public class StringToDateConverter implements Converter<String,Date> {
    /**
     *
     * @param source    传进来的字符串
     * @return
     */
    public Date convert(String source) {
        //判断
        if(source == null)
            throw new RuntimeException("请传入数据...");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            //将字符串转换为日期
            return df.parse(source);
        } catch (Exception e) {
            throw new RuntimeException("数据类型转换出现错误...");
        }
    }
}
