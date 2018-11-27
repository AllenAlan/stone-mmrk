package com.allen.stone.utils.time.enums;

import java.time.format.DateTimeFormatter;

/**日期模板enum
 * @author Allen
 * @version V1.0.0
 * @date 2018/10/13 16:00
 */
public enum TimeFormat {

    //短时间格式 年月日
    /**
     *时间格式：yyyy-MM-dd
     */
    SHORT_DATE_PATTERN_LINE("yyyy-MM-dd"),
    /**
     *时间格式：yyyy/MM/dd
     */
    SHORT_DATE_PATTERN_SLASH("yyyy/MM/dd"),
    /**
     *时间格式：yyyy\\MM\\dd
     */
    SHORT_DATE_PATTERN_DOUBLE_SLASH("yyyy\\MM\\dd"),
    /**
     *时间格式：yyyyMMdd
     */
    SHORT_DATE_PATTERN_NONE("yyyyMMdd"),

    // 长时间格式 年月日时分秒
    /**
     *时间格式：yyyy-MM-dd HH:mm:ss
     */
    LONG_DATE_PATTERN_LINE("yyyy-MM-dd HH:mm:ss"),

    /**
     *时间格式：yyyy/MM/dd HH:mm:ss
     */
    LONG_DATE_PATTERN_SLASH("yyyy/MM/dd HH:mm:ss"),
    /**
     *时间格式：yyyy\\MM\\dd HH:mm:ss
     */
    LONG_DATE_PATTERN_DOUBLE_SLASH("yyyy\\MM\\dd HH:mm:ss"),
    /**
     *时间格式：yyyyMMdd HH:mm:ss
     */
    LONG_DATE_PATTERN_NONE("yyyyMMdd HH:mm:ss"),

    // 长时间格式 年月日时分秒 带毫秒
    /*yyyy-MM-dd HH:mm:ss.SSS*/
    LONG_DATE_PATTERN_WITH_MILSEC_LINE("yyyy-MM-dd HH:mm:ss.SSS"),
    /*yyyy/MM/dd HH:mm:ss.SSS*/
    LONG_DATE_PATTERN_WITH_MILSEC_SLASH("yyyy/MM/dd HH:mm:ss.SSS"),

    LONG_DATE_PATTERN_WITH_MILSEC_DOUBLE_SLASH("yyyy\\MM\\dd HH:mm:ss.SSS"),

    LONG_DATE_PATTERN_WITH_MILSEC_NONE("yyyyMMdd HH:mm:ss.SSS");

    public transient DateTimeFormatter formatter;

    TimeFormat(String pattern) {
        formatter = DateTimeFormatter.ofPattern(pattern);
    }


}
