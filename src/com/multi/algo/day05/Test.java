package com.multi.algo.day05;


import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        //["mislav", "stanko", "mislav", "ana"]	["stanko", "ana", "mislav"]
        System.out.println(test.solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}));

    }
    public String solution(String[] participant, String[] completion) {

        Map<String, Integer> map = new HashMap<>();
        for(String str:participant){
            map.put(str,map.getOrDefault(str,0)+1);
        }

        for(String str:completion){
            map.put(str,map.get(str)-1);
        }

        for(String str:map.keySet())
            if(map.get(str)==1)
                return str;

        return "";



    }
}
