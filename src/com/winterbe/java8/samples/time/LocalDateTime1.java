//package com.winterbe.java8.samples.time;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;

/**
 * @author Benjamin Winterberg
 */
public class LocalDateTime1 {

    public static void main(String[] args) {

        LocalDateTime sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);

        DayOfWeek dayOfWeek = sylvester.getDayOfWeek();
        System.out.println(dayOfWeek);      // WEDNESDAY

        Month month = sylvester.getMonth();
        System.out.println(month);          // DECEMBER

        long minuteOfDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);
        System.out.println(minuteOfDay);    // 1439

        Instant instant = sylvester
                .atZone(ZoneId.systemDefault())
                .toInstant();

        Date legacyDate = Date.from(instant);
        System.out.println(legacyDate);     // Wed Dec 31 23:59:59 CET 2014


        DateTimeFormatter formatter1 =
                DateTimeFormatter
                        .ofPattern("MMM dd, yyyy - HH:mm");
        DateTimeFormatter formatter2 =
                DateTimeFormatter
                        .ofPattern("MMM dd, yyyy - HH:mm");
                        
        LocalDateTime parsed1 = LocalDateTime.parse("Nov 03, 2014 - 07:13", formatter1);
        String string1 = parsed1.format(formatter1);
        System.out.println(string1);     // Nov 03, 2014 - 07:13
        
 /*       LocalDateTime parsed2 = LocalDateTime.parse("03 Nov , 2014 - 07:13", formatter2);
        String string2 = parsed2.format(formatter2);
        System.out.println(string2);     // Nov 03, 2014 - 07:13
   */ }

}
