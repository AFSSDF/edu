package com.bdqn.edu.test;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateTest {
    @Test
    public void test() throws ParseException {
        String dateString1 = "2019-1-1";
        String dateString2 = "2019-1-3";
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = dateFormat.parse(dateString1);
        Date date2 = dateFormat.parse(dateString2);
        long daysBetween = (date2.getTime() - date1.getTime()) / (60 * 60 * 24 * 1000) + 1;
        System.out.println(daysBetween);
    }


    @Test
    public void list() throws ParseException {
        String dateString1 = "2019-1-11";
        String dateString2 = "2019-1-22";
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = dateFormat.parse(dateString1);
        Date date2 = dateFormat.parse(dateString2);
        Long startTIme = date1.getTime();
        Long endTime = date2.getTime();
        Long oneDay = 1000 * 60 * 60 * 24l;

        Long time = startTIme;
        while (time <= endTime) {
            Date d = new Date(time);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(df.format(d));
            time += oneDay;
        }
    }

    public static final String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};

    @Test
    public void week() throws ParseException {
        String dateString1 = "2019-2-10";
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = dateFormat.parse(dateString1);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);

        int w = calendar.get(Calendar.DAY_OF_WEEK);
        w = w - 1;
        System.out.println(w + "\t" + weekDays[w]);
    }

    @Test
    public void listCount() {
        List list = new ArrayList(1);
        System.out.println(list.size());
    }
}
