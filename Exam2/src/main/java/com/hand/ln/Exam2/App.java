package com.hand.ln.Exam2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入工资:");
        double salary = scanner.nextDouble();
        double duty = compute(salary);
        System.out.println("所需要缴纳的税费为:" + duty);
        scanner.close();
    }

    public static double compute(double salary) {
        double duty = 0;
        double count = salary - 3500;
        if (count > 80000) {
            duty += (count - 80000) * 0.45;
            count = 80000;
        }
        if (count > 55000) {
            duty += (count - 55000) * 0.35;
            count = 55000;
        }
        if (count > 35000) {
            duty += (count - 35000) * 0.30;
            count = 35000;
        }
        if (count > 9000) {
            duty += (count - 9000) * 0.25;
            count = 9000;
        }
        if (count > 4500) {
            duty += (count - 4500) * 0.20;
            count = 4500;
        }
        if (count > 1500) {
            duty += (count - 1500) * 0.10;
            count = 1500;
        }
        duty += count * 0.03;
        return duty;
    }

}
