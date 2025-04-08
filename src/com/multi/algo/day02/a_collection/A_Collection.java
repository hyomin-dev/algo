package com.multi.algo.day02.a_collection;


import java.util.*;

public class A_Collection {
    public static void main(String[] args) {
        // 1. 중복 허용 X
        HashSet<String> team = new HashSet<>();
        team.add("디자이너");
        team.add("프로그래머");
        team.add("DB 관리자");
        team.add("DB 관리자");
        System.out.println(team);

        // 2. 선입 선출(FIFO - QUEUE, LinkedList)

        LinkedList<String> cold = new LinkedList<>();
        cold.add("상한 우유");
        cold.add("신선우유");
        System.out.println(cold);
        cold.remove();
        System.out.println(cold);

        // 3. ArrayList (순서중요)

        ArrayList<String> ski = new ArrayList<>();
        ski.add("박스키");
        ski.add("송스키");
        ski.add("김스키");
        ski.add("정스키");

        System.out.println(ski);

        ski.remove(1);
        System.out.println(ski);

        ski.add(0,"김연아");

        System.out.println(ski.get(0));
        System.out.println(ski.indexOf("박스키"));
        ski.clear();
        System.out.println(ski);

        // key, value -> map

        HashMap<Integer, String> phone = new HashMap<>();
        phone.put(1,"엄마");
        phone.put(2,"아빠");
        phone.put(3,"엄마");
        phone.put(4,"아빠");

        System.out.println(phone);

        phone.put(2,"누구");
        System.out.println(phone);

        System.out.println(phone.get(3));
        System.out.println(phone.getOrDefault(5, "누나"));
        System.out.println(phone);





    }
}
