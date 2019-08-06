package com.nanfeng.one.four;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-20 16:39
 */
public class DateTest {

    @Test
    public void test (){
        System.out.println(new Date());

        LocalDate newTime = LocalDate.now();
        System.out.println(newTime);
        int year = newTime.getYear();
        int month = newTime.getMonthValue();
        int day = newTime.getDayOfMonth();
        System.out.println(year+"-"+month+"-"+day);
    }

    @Test
    public void test2(){
        // 使用默认时区和语言环境获得一个日历
        Calendar calendar = Calendar.getInstance();

        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH)+1);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println(calendar.get(Calendar.MINUTE));
        System.out.println(calendar.get(Calendar.SECOND));

        calendar.set(2018,11-1,12,10,33,45);
        System.out.println(calendar.getTime());

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sf.format(calendar.getTime()));

        calendar.add(Calendar.DAY_OF_MONTH,10);

        System.out.println(sf.format(calendar.getTime()));
    }

    @Test
    void test3(){
        String s = new Date().toString();
        System.out.println(s);
        LocalDate date = LocalDate.now();
        System.out.println(date);
        LocalDate dateSet = LocalDate.of(2012, 12, 23);
        System.out.println(dateSet);
        System.out.println(dateSet.getYear());
        System.out.println(dateSet.getMonthValue());
        System.out.println(date.getDayOfMonth());

        System.out.println("-------------------------------------------------------------");

        LocalDate plusDays = dateSet.plusDays(10);

        System.out.println(plusDays);
    }

    @Test
    void test4(){
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();

        //建立开始的时间
        //minusDays（）：设置当月的那一天
        date = date.minusDays(today - 1);
        DayOfWeek weekday = date.getDayOfWeek();
        int value = weekday.getValue();
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");

        while (date.getMonthValue() == month){
            System.out.printf("%3d",date.getDayOfMonth());
            if (date.getDayOfMonth() == today){
                System.out.print("*");
            }else {
                System.out.print(" ");
            }
            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 1){
                System.out.println();
            }
        }
        if (date.getDayOfWeek().getValue() != 1){
            System.out.println();
        }
    }
}
