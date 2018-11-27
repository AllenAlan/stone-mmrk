package com.allen.stone.api.learn.java8;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Author Allen
 * @Description
 * @Date 2018/10/13 14:43
 **/
public class TimeApiTest {


    public static void main(String[] args) {

        String nowDateStr = LocalDate.now().toString();
        /*2018-03-27*/
        System.out.println(nowDateStr);

        LocalDate nowDate = LocalDate.parse("2018-03-25");
        /*//2018-03-25*/
        System.out.println(nowDate.toString());


        String nowTimeStr = LocalTime.now().toString();
        /* 13:45:07.105*/
        System.out.println(nowTimeStr);

        LocalTime nowTime = LocalTime.parse("12:10:13");
        /*//12:10:13*/
        System.out.println(nowTime.toString());

        /*//2018-03-27T13:55:34.047*/
        System.out.println(LocalDateTime.now().toString());
        /*//2018-03-27*/
        System.out.println(LocalDateTime.now().toLocalDate().toString());
        /*//13:55:34.047*/
        System.out.println(LocalDateTime.now().toLocalTime().toString());

        /*//+999999999-12-31T23:59:59.999999999*/
        System.out.println(LocalDateTime.MAX.toString());
        /*//-999999999-01-01T00:00*/
        System.out.println(LocalDateTime.MIN.toString());

        date2LocalDateTime(new Date());
        localDateTime2Date(LocalDateTime.now());
    }


    /**
     * Date转换为LocalDateTime
     *
     * @param date
     */
    public static void date2LocalDateTime(Date date) {
        /*//An instantaneous point on the time-line.(时间线上的一个瞬时点。)*/
        Instant instant = date.toInstant();
        /*//A time-zone ID, such as {@code Europe/Paris}.(时区)*/
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();

        /*//2018-03-27T14:07:32.668*/
        System.out.println(localDateTime.toString());
        /*//2018-03-27 14:48:57.453*/
        System.out.println(localDateTime.toLocalDate() + " " + localDateTime.toLocalTime());

        /*//This class is immutable and thread-safe.@since 1.8*/
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        /*//2018-03-27 14:52:57*/
        System.out.println(dateTimeFormatter.format(localDateTime));
    }

    /**
     * LocalDateTime转换为Date
     *
     * @param localDateTime
     */
    public static void localDateTime2Date(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        /*//Combines this date-time with a time-zone to create a  ZonedDateTime.*/
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        Date date = Date.from(zdt.toInstant());
        /*//Tue Mar 27 14:17:17 CST 2018*/
        System.out.println(date.toString());
    }


}
