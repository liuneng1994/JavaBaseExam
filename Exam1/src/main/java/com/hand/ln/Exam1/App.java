package com.hand.ln.Exam1;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 101; i <= 200; i++) {
            if (isPrime(i)) {
                list.add(i);
            }
        }
        StringBuilder result = new StringBuilder("101-200 间总共有 " + list.size() + "个素数,分别是:");
        for (Integer i : list) {
            result.append(i + ",");
        }
        result.deleteCharAt(result.length() - 1);
        System.out.println(result.toString());
    }

    public static boolean isPrime(int m) {
        for (int i = 2; i < m; i++) {
            if ((m % i) == 0) {
                return false;
            }
        }
        return true;
    }
}
