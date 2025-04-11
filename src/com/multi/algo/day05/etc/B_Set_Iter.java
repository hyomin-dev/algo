package com.multi.algo.day05.etc;


import java.util.HashSet;
import java.util.Iterator;

public class B_Set_Iter {
    public static void main(String[] args) {
        HashSet<String> bag = new HashSet<>();
        bag.add("휴대폰");
        bag.add("휴지");
        bag.add("볼펜");
        bag.add("볼펜");

        System.out.println("iterator()===========================================");
        Iterator<String> iter = bag.iterator();
        while(iter.hasNext()){
            System.out.printf("%s ",iter.next());
        }
        System.out.println();

        System.out.println("join======================================");
        String str = String.join(" ",bag);
        System.out.println(str);
    }
}
