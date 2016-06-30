package com.lht.chuangyiyun.util.time;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p><b>Package</b> com.lht.chuangyiyun.util.time
 * <p><b>Project</b> Chuangyiyun
 * <p><b>Classname</b> TimeUtil
 * <p><b>Description</b>: TODO
 * Created by leobert on 2016/6/21.
 */
public class TimeUtil {

    public static final SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat DATE_FORMAT_DATE = new SimpleDateFormat("yyyy-MM-dd");

    private TimeUtil() {
        throw new AssertionError();
    }

    /**
     * long time to string
     *
     * @param timeInMillis
     * @param dateFormat
     * @return
     */
    public static String getTime(long timeInMillis, SimpleDateFormat dateFormat) {
        return dateFormat.format(new Date(timeInMillis));
    }

    /**
     * long time to string, format is {@link #DEFAULT_DATE_FORMAT}
     *
     * @param timeInMillis
     * @return
     */
    public static String getTime(long timeInMillis) {
        return getTime(timeInMillis, DEFAULT_DATE_FORMAT);
    }

    /**
     * get current time in milliseconds
     *
     * @return
     */
    public static long getCurrentTimeInLong() {
        return System.currentTimeMillis();
    }

    /**
     * get current time in milliseconds, format is {@link #DEFAULT_DATE_FORMAT}
     *
     * @return
     */
    public static String getCurrentTimeInString() {
        return getTime(getCurrentTimeInLong());
    }

    /**
     * get current time in milliseconds
     *
     * @return
     */
    public static String getCurrentTimeInString(SimpleDateFormat dateFormat) {
        return getTime(getCurrentTimeInLong(), dateFormat);
    }


//    public static long transMillis2Sec(long timeInMillis) {
//        if (timeInMillis > 9999999999l) {
//            return timeInMillis/1000;
//        } else {
//            throw new IllegalArgumentException("you should give a time in millis");
//        }
//    }



//    public static boolean isTimeInMillis(long timestamp) {
//        return timestamp>9999999999l;
//    }
//
//    //不考虑负值，也不去检验
//    public static boolean isTimeInSecond(long timestamp) {
//        return timestamp<=9999999999l;
//    }
}
