package com.allen.stone.utils.time;

import com.allen.stone.utils.time.enums.TimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 时间api 工具类
 *
 * @Author Allen
 * @Description
 * @Date 2018/10/13 15:02
 **/

public class DateTimeUtils {

    private static final DateTimeFormatter DEFAULT_DATETIME_FORMATTER = TimeFormat.SHORT_DATE_PATTERN_LINE.formatter;

    /**
     * 防止类被实例化
     */
    private DateTimeUtils() {
    }

    /**
     * String 转化为 LocalDateTime
     *
     * @param timeStr 被转化的字符串
     * @return LocalDateTime
     */
    public static LocalDateTime parseTime(String timeStr) {
        return LocalDateTime.parse(timeStr, DEFAULT_DATETIME_FORMATTER);

    }

    /**
     * String 转化为 LocalDateTime
     *
     * @param timeStr    被转化的字符串
     * @param timeFormat 转化的时间格式
     * @return LocalDateTime
     */
    public static LocalDateTime parseTime(String timeStr, TimeFormat timeFormat) {
        return LocalDateTime.parse(timeStr, timeFormat.formatter);

    }

    /**
     * LocalDateTime 转化为String
     *
     * @param time LocalDateTime
     * @return String
     */
    public static String parseTime(LocalDateTime time) {
        return DEFAULT_DATETIME_FORMATTER.format(time);

    }


    /**
     * LocalDateTime 时间转 String
     *
     * @param time   LocalDateTime
     * @param format 时间格式
     * @return String
     */
    public static String parseTime(LocalDateTime time, TimeFormat format) {
        return format.formatter.format(time);
    }

    /**
     * 获取当前时间
     * @return
     */
    public static String getCurrentDateTime() {
        return DEFAULT_DATETIME_FORMATTER.format(LocalDateTime.now());
    }

    /**
     * 获取当前时间
     *
     * @param timeFormat
     *            时间格式
     * @return
     */
    public static String getCurrentDateTime(TimeFormat timeFormat) {
        return timeFormat.formatter.format(LocalDateTime.now());
    }

    public static void main(String[] args) {
//        TimeFormat.LONG_DATE_PATTERN_DOUBLE_SLASH
        DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_TIME;
        LocalDateTime ldt = LocalDateTime.now();
        String strDate = ldt.format(dtf);
        System.out.println(strDate);


        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String strDate2 = dtf2.format(ldt);
        System.out.println(strDate2);

        //获取当前时间
        System.out.println(getCurrentDateTime());

        System.out.println(getCurrentDateTime(TimeFormat.LONG_DATE_PATTERN_LINE));


    }


}
