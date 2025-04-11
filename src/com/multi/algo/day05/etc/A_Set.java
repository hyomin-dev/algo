package com.multi.algo.day05.etc;


import java.util.*;

public class A_Set {
    public static void main(String[] args) {
        String s = "aaabbbcdddefe";

        Set<String> set = new HashSet<>();

        String[] sArr = s.split("");

        for(String str: sArr)
            set.add(str);

        System.out.println(set);

        // list에 set처럼 담기
        ArrayList<String> list = new ArrayList<>();
        for(String str: sArr)
            if(!list.contains(str))
                list.add(str);

        Collections.sort(list);

        //문자열로 다시 담기

        //방법 1
        System.out.println("반복=================================================");

        String answer = "";
        for(String str:list)
            answer +=str;

        System.out.println(answer);

        // 방법 2
        System.out.println("join=================================================");
        String answer2 = String.join("",list);
        System.out.println(answer2);

        // 방법3
        System.out.println("iterator=================================================");
        Iterator<String> iter = set.iterator();

        String answer3 = "";
        while(iter.hasNext()){
            answer3 += iter.next();
        }
        System.out.println(answer3);

        System.out.println("frequency=================================================");

        System.out.println(Collections.frequency(list,"a"));




    }
}
