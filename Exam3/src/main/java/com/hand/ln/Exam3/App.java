package com.hand.ln.Exam3;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入你的日期:");
        String date = scanner.nextLine();
        MyDate myDate = MyDate.tranlateDate(date);
        System.out.println(String.format("你输入的日期为当年的第 %d天", myDate.computeDays()));
    }
}

class MyDate {
    private int year;
    private int month;
    private int day;

    private static int[] months = { 31, 27, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    private static int[] leapMonths = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public MyDate(int year, int month, int day) {
        super();
        if ((month < 1) || (month > 12)) {
            throw new IllegalArgumentException("month is out of range");
        }
        if (day < 1) {
            throw new IllegalArgumentException("day is out of range");
        }
        if (isLeap(year) && (day > leapMonths[month - 1])) {
            throw new IllegalArgumentException("day is out of range");
        }
        else if (day > months[month - 1]) {
            throw new IllegalArgumentException("day is out of range");
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public static boolean isLeap(int year) {
        if (((year % 100) == 0) && ((year % 400) == 0)) {
            return true;
        }
        if (((year % 100) != 0) && ((year % 4) == 0)) {
            return true;
        }
        return false;
    }

    public boolean isLeap() {
        return isLeap(year);
    }

    public int computeDays() {
        int[] days = months;
        if (isLeap()) {
            days = leapMonths;
        }
        int count = 0;
        for (int i = 0; i < (month - 1); i++) {
            count += days[i];
        }
        count += day;
        return count;
    }

    public static MyDate tranlateDate(String date) {
        String[] tmp = date.split("-");
        if (tmp.length != 3) {
            throw new IllegalArgumentException("日期格式错误");
        }
        return new MyDate(Integer.valueOf(tmp[0]), Integer.valueOf(tmp[1]), Integer.valueOf(tmp[2]));
    }
}
