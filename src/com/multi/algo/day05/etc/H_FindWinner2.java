package com.multi.algo.day05.etc;


import java.util.HashMap;
import java.util.Map;

public class H_FindWinner2 {
    public static void main(String[] args) {
        String[] all = {"홍길동", "김길동", "정길동", "홍길동", "김길동", "홍길동"};
       //찾아야할 명단 이 주어지는경우

        Map<String, Integer> map = new HashMap<>();

//        for(String x:find){
//            map.put(x,0);
//        }

        for(String str:all){
            map.put(str,map.getOrDefault(str,0)+1);
        }

//        String maxStr = find[0];
//        for(int i=1;i<find.length;i++){
//            if(map.get(maxStr)<map.get(find[i]))
//                maxStr = find[i];
//        }

        //System.out.println("우승 "+maxStr);


    }
}
