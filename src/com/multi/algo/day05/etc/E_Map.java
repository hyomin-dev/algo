package com.multi.algo.day05.etc;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class E_Map {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("apple", 0);
        map.put("melon", 0);
        map.put("ice", 2);
        System.out.println(map);

        map.put("ice2",map.getOrDefault("ice2",0)+1);
        System.out.println(map);

        Set key = map.keySet();
        for(Object k:key){
            System.out.println(k);
            System.out.println(map.get(k));
        }

        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();

        for(Map.Entry<String,Integer> entry:entrySet){
            System.out.println(entry.getKey()+" => "+entry.getValue());
        }


    }
}
