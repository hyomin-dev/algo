package com.multi.algo.day05.etc;


import java.util.ArrayList;
import java.util.Collections;

public class F_Collections {
    public static void main(String[] args) {
        int[] s = { 3, 3, 6, 7, 8, 11, 34, 90, 102 };

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            list.add(s[i]);
        }

        System.out.println(list);
        System.out.println(list.size());
        System.out.println(Collections.min(list));// 정렬안하고 바로 최소값 찾을때
        System.out.println(Collections.max(list));
        Collections.sort(list);
        System.out.println(list.get(2));
        System.out.println(Collections.frequency(list, 3));
        System.out.println(!list.contains(6));
        System.out.println(list.indexOf(6));
        Collections.reverse(list); //역순!
        System.out.println(list);
        list.clear();
    }
}
