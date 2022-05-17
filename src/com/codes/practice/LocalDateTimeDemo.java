package com.codes.practice;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.ValueRange;

public class LocalDateTimeDemo {
    public static void main(String[] args) {
//        LocalDateDemo1();
//        LocalDateDemo2();
//        LocalDateDemo3();
//        LocalDateDemo4();
//        LocalDateDemo5();
        MonthDayDemo1();
    }

    public static void LocalDateDemo1() {
        LocalDate date = LocalDate.now();
        LocalDate yesterday = date.minusDays(1);
        LocalDate tomorrow = yesterday.plusDays(2);
        System.out.println("Today date: "+date);
        System.out.println("Yesterday date: "+yesterday);
        System.out.println("Tomorrow date: "+tomorrow);
    }

    public static void LocalDateDemo2() {
        LocalDate date1 = LocalDate.of(2017, 1, 13);
        System.out.println(date1.isLeapYear());
        LocalDate date2 = LocalDate.of(2016, 9, 23);
        System.out.println(date2.isLeapYear());
    }
    public static void LocalDateDemo3() {
        LocalDate date = LocalDate.of(2017, 1, 13);
        LocalDateTime datetime = date.atTime(1,50,9);
        System.out.println(datetime);
    }
    public static void LocalDateDemo4()
    {
        // Converting LocalDate to String
        // Example 1
        LocalDate d1 = LocalDate.now();
        String d1Str = d1.format(DateTimeFormatter.ISO_DATE);
        System.out.println("Date1 in string :  " + d1Str);
        // Example 2
        LocalDate d2 = LocalDate.of(2002, 05, 01);
        String d2Str = d2.format(DateTimeFormatter.ISO_DATE);
        System.out.println("Date2 in string :  " + d2Str);
        // Example 3
        LocalDate d3 = LocalDate.of(2016, 11, 01);
        String d3Str = d3.format(DateTimeFormatter.ISO_DATE);
        System.out.println("Date3 in string :  " + d3Str);
    }

    public static void LocalDateDemo5()
    {
        // Example 1
        String dInStr = "2011-09-01";
        LocalDate d1 = LocalDate.parse(dInStr);
        System.out.println("String to LocalDate : " + d1);
        // Example 2
        String dInStr2 = "2015-11-20";
        LocalDate d2 = LocalDate.parse(dInStr2);
        System.out.println("String to LocalDate : " + d2);
    }
    public static void LocalTimeDemo1() {
        LocalTime time1 = LocalTime.of(10,43,12);
        System.out.println(time1);
        LocalTime time2=time1.minusHours(2);
        LocalTime time3=time2.minusMinutes(34);
        System.out.println(time3);

        LocalTime time4=time1.plusHours(4);
        LocalTime time5=time4.plusMinutes(18);
        System.out.println(time5);
    }
    public static void LocalTimeDemo2() {
        ZoneId zone1 = ZoneId.of("Asia/Kolkata");
        ZoneId zone2 = ZoneId.of("Asia/Tokyo");
        LocalTime time1 = LocalTime.now(zone1);
        System.out.println("India Time Zone: "+time1);
        LocalTime time2 = LocalTime.now(zone2);
        System.out.println("Japan Time Zone: "+time2);
        long hours = ChronoUnit.HOURS.between(time1, time2);
        System.out.println("Hours between two Time Zone: "+hours);
        long minutes = ChronoUnit.MINUTES.between(time1, time2);
        System.out.println("Minutes between two time zone: "+minutes);
    }

    public static void MonthDayDemo1() {

        ZonedDateTime zone = ZonedDateTime.parse("2016-10-05T08:20:10+05:30[Asia/Kolkata]");
        System.out.println(zone);

        MonthDay month = MonthDay.now();
        System.out.println("Mouth now: " + month);

        boolean b = month.isValidYear(2012);
        System.out.println(b);

        LocalDate date = month.atYear(1994);
        System.out.println(date);

        long n = month.get(ChronoField.MONTH_OF_YEAR);
        System.out.println(n);

        ValueRange r1 = month.range(ChronoField.MONTH_OF_YEAR);
        System.out.println("Mouth range of the year: " + r1);
        ValueRange r2 = month.range(ChronoField.DAY_OF_MONTH);
        System.out.println("Day range of the month: " + r2);
    }

    public static void ZoneDateTimeDemo1() {
        ZonedDateTime zone =ZonedDateTime.now();
        System.out.println(zone.getZone());

        ZonedDateTime m = zone.minus(Period.ofDays(126));
        System.out.println(m);

        ZonedDateTime p = zone.plus(Period.ofDays(126));
        System.out.println(p);

        LocalDateTime  ldt = LocalDateTime.of(2017, Month.JANUARY,  19,   15,   26);
        ZoneId  india = ZoneId.of("Asia/Kolkata");
        ZonedDateTime zone1  = ZonedDateTime.of(ldt, india);
        System.out.println("In India Central Time Zone: " + zone1);
        ZoneId  tokyo = ZoneId.of("Asia/Tokyo");
        ZonedDateTime zone2   = zone1.withZoneSameInstant(tokyo);
        System.out.println("In Tokyo Central Time Zone:"  + zone2);

    }

    public static void ClockDemo1() {

        Clock cd = Clock.systemDefaultZone();
        System.out.println(cd.getZone());

        Clock c = Clock.systemUTC();

        System.out.println(c.instant());

        Duration d = Duration.ofHours(5);
        Clock clock = Clock.offset(c, d);
        System.out.println(clock.instant());
    }
}
