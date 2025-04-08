package com.multi.algo.day03;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A_ArrayCollection {
    public static void main(String[] args) {
        int[] s = { 5, 2, 1, 9, 11, 15, 17 };


        System.out.println(Arrays.toString(s));

        Arrays.sort(s);

        System.out.println(Arrays.toString(s));

        String[] s2 = {"aaa", "bbb", "ccc", "aaa"};

        List<String> list = Arrays.asList(s2);
        System.out.println(list);

        //list.remove(0);
        //list.add("test");]


        //add/remove되지 않는 제약이 있음.  // 배열을 리스트 처럼 다루긴하지만 ,내부적으로는 배열을 가리키고있다 //size 조정하는 것은 불가능

        System.out.println(list.contains("aaa"));
        System.out.println(list.indexOf("aaa"));

        list.set(1,"BBB");
        System.out.println(list);


        //배열 -> list
        List<String> list2 = new ArrayList<>(Arrays.asList(s2));
        System.out.println(list2);
        list2.add("AAA");
        System.out.println(list2);
        System.out.println(list);


        System.out.println("============================================================");
        // 리스트 -> 배열
        String[] s3 = list.toArray(new String[0]);
        System.out.println(Arrays.toString(s3));

        String[] s4 = new String[list.size()];

        for(int i=0;i<s4.length;i++){
            s4[i] = list.get(i);
        }

        System.out.println(Arrays.toString(s4));






    }
}
