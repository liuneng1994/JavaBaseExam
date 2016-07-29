package com.hand.ln.Exam4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        List<Integer> list = getRandomList(100);
        StringBuilder randomList = new StringBuilder("随机生成 50 个小于 100 的数,分别为:");
        for (int i : list) {
            randomList.append(i + ",");
        }
        randomList.deleteCharAt(randomList.length() - 1);
        System.out.println(randomList.toString());
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (Integer i : list) {
            int key = i / 10;
            List<Integer> group = map.get(key);
            if (group == null) {
                group = new ArrayList<Integer>();
            }
            group.add(i);
            map.put(key, group);
        }
        StringBuilder mapResult = new StringBuilder("Map 中的数据为: {");
        for (int i : map.keySet()) {
            mapResult.append(i).append("=>").append(map.get(i)).append(",");
        }
        mapResult.deleteCharAt(mapResult.length() - 1);
        mapResult.append("}");
        System.out.println(mapResult.toString());
        for (Integer i : map.keySet()) {
            sort(map.get(i));
        }
        StringBuilder sortResult = new StringBuilder("排序后的 Map 为: {");
        for (int i : map.keySet()) {
            sortResult.append(i).append("=>").append(map.get(i)).append(",");
        }
        sortResult.deleteCharAt(sortResult.length() - 1);
        sortResult.append("}");
        System.out.println(sortResult.toString());
    }

    public static List<Integer> getRandomList(int max) {
        List<Integer> list = new ArrayList<Integer>();
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            list.add(random.nextInt(max));
        }
        return list;
    }

    public static void sort(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                if (list.get(i) > list.get(j)) {
                    int m = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, m);
                }
            }
        }
    }
}
