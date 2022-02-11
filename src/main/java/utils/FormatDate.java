package main.java.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;


import static main.java.utils.ConfigDate.*;

public class FormatDate {
    public static long getCurrentDateTime() {
        return LocalDateTime.now(ZoneId.of(TIME_ZONE)).toInstant(getZoneOffset()).toEpochMilli();
    }

    public static ZoneOffset getZoneOffset() {
        return LocalDateTime.now(ZoneId.of(TIME_ZONE)).atZone(ZoneId.of(TIME_ZONE)).getOffset();
    }

    public static long dateTimeToLong(String strDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
        LocalDateTime dateTime = LocalDateTime.parse(strDateTime, formatter);
        ZoneOffset zoneOffset = dateTime.atZone(ZoneId.of(TIME_ZONE)).getOffset();
        return dateTime.toInstant(zoneOffset).toEpochMilli();
    }

    public static String dateToStr(Long dateTime, String format) {
        return Instant.ofEpochMilli(dateTime).atZone(ZoneId.of(TIME_ZONE)).toLocalDateTime().format(DateTimeFormatter.ofPattern(format));
    }

    public static String printNow(){
        return LocalDateTime.now(ZoneId.of(TIME_ZONE)).format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT));
    }

    public static String printNowTimeForLogger(){
        return LocalDateTime.now(ZoneId.of(TIME_ZONE)).format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT_LOGGER));
    }

    public static String timeOfDayLongToString(Long time) {
        return LocalTime.ofNanoOfDay(time)
                .format(DateTimeFormatter.ofPattern(TIME_FORMAT));
    }

//    public static long parseTime(String str) {
//        LocalTime time = LocalTime.now(ZoneId.of(TIME_ZONE));
//        str = str.replaceAll("[^0-9,:]", "");
//        try {
//            time = LocalTime.parse(str, DateTimeFormatter.ofPattern(TIME_FORMAT));
//        } catch (DateTimeParseException e) {
//            System.out.println(e.getStackTrace());
//        }
//        return time.toNanoOfDay();
//    }

    public static long parseDate(String str) {
        LocalDate date = LocalDate.now(ZoneId.of(TIME_ZONE));
        ZoneOffset zoneOffset = date.atStartOfDay(ZoneId.of(TIME_ZONE)).getOffset();
        str = str.replaceAll("[^0-9,/]", "");
        try {
            date = LocalDate.parse(str, DateTimeFormatter.ofPattern(DATE_FORMAT));
        } catch (DateTimeParseException e) {
            System.out.println(e.getStackTrace());
        }

        return date.atStartOfDay().toInstant(zoneOffset).toEpochMilli();
    }


}
