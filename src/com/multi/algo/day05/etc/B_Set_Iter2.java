package com.multi.algo.day05.etc;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class B_Set_Iter2 {
    public static void main(String[] args) {

        //일주일간 받았던 용돈(월~일)
        //1000, 2000, 3000, 2000, 4000, 2000, 3000
        //중복없이 1개씩 출력
        // 출력 -> 1000, 2000, 3000, 4000

        Set<Integer> set = new HashSet<>();

        set.add(1000);
        set.add(2000);
        set.add(3000);
        set.add(2000);
        set.add(4000);
        set.add(2000);
        set.add(3000);

        System.out.println("iterator()==============================");
        Iterator<Integer> iter = set.iterator();
        while(iter.hasNext()){
            System.out.printf("%d, ",iter.next());
        }
        System.out.println();

        System.out.println("forEach()==============================");

        for(Integer num:set)
            System.out.printf("%d, ",num);

        System.out.println();


    }
}
