package com.multi.algo.day05.etc;


import java.util.*;

public class H_FindWinner3 {
    public static void main(String[] args) {
        String[] all = {"김길동","홍길동", "김길동", "정길동", "홍길동", "김길동", "홍길동"};
       //찾아야할 명단 이 주어지는경우

        Map<String, Integer> map = new HashMap<>();

//        for(String x:find){
//            map.put(x,0);
//        }

        for(String str:all){
            map.put(str,map.getOrDefault(str,0)+1);
        }

        // 1. 전체 명단안 프린트
        Set<String> set = map.keySet();
        System.out.println(set);
        // 2. 각 명단의 사람이 몇 표씩을 획득했는가?
        Set<Map.Entry<String,Integer>> entries = map.entrySet();
        for(Map.Entry<String, Integer> entry : entries)
            System.out.println("이름: "+entry.getKey()+", "+"투표수: "+entry.getValue());

        // 3. 여러명일 때
        int maxVotes = 0;
        for(String str : map.keySet()){
            if(map.get(str)>maxVotes)
                maxVotes = map.get(str);
        }

        List<String> winners = new ArrayList<>();
        for(String str: map.keySet()){
            if(map.get(str)==maxVotes)
                winners.add(str);
        }
        System.out.println("최고 득표수: " +maxVotes);
        System.out.println("우승자들: "+winners);



//        String maxStr = find[0];
//        for(int i=1;i<find.length;i++){
//            if(map.get(maxStr)<map.get(find[i]))
//                maxStr = find[i];
//        }

        //System.out.println("우승 "+maxStr);


    }
}
