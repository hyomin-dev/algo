package com.multi.algo.day02.a_collection;


import java.util.*;

public class B_App {
    public static void main(String[] args) {
        // problem 1
        Set<String> set = new HashSet<>();

        set.add("대한민국");
        set.add("미국");
        set.add("중국");
        set.add("일본");
        set.add("러시아");
        System.out.println(set);


        // problem2
        System.out.println("=======================================================");

        Map<String, String> map = new HashMap<>();
        map.put("안방","TV");
        map.put("거실","쇼파");
        map.put("부엌","냉장고");
        map.put("현관","신발");
        System.out.println(map);
        System.out.println("현관: "+map.get("현관"));

        map.put("거실","책상");
        System.out.println("거실: "+map.get("거실"));

        // problem3
        System.out.println("=======================================================");

        List<String> list = new ArrayList<>();
        list.add("spring");
        list.add("java");
        list.add("html");
        list.add("css");
        list.add("js");

        System.out.println(list);
        System.out.printf("1번째 할일: %s, 2번째 할일: %s \n",list.get(0),list.get(list.size()-1));

        list.add(1,"청소");
        System.out.println(list);
    }
}
