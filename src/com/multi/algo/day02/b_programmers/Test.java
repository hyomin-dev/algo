package com.multi.algo.day02.b_programmers;


import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
       solution(new String[]{"sun", "bed", "car"},1);

    }


    public static String[] solution(String[] strings, int n) {


        // 문자열 정렬(추후 같은 알파벳이면 사전순이므로)
        // TreeMap<Character, Integer> 생성 --> <각 문자열에서 index가 n인 문자 추출, 배열에서의 index>
        // 새로운 문자열에 저장


//        Arrays.sort(strings);
//        Map<Integer, String> map = new TreeMap<>();
//        for(int i =0; i<strings.length;i++){
//            map.put(i, strings[i].charAt(n)+"");
//        }
//        List<String> list = map.values().stream().collect(Collectors.toList()); //value에 대해 정렬
//        String[] answer = new String[map.size()];
//        Collections.sort(list);
//
//        System.out.println(list);
//         Set<Integer> keySet = map.keySet();
//         for(Integer key: keySet){
//             //answer[key] =
//         }
//
//
//        System.out.println();

        // 같으면 0
        // 오름차순 정렬: 음수 리턴
        Arrays.sort(strings,(num1,num2)->{
            if(num1.charAt(n)==num2.charAt(n))
                return num2.compareTo(num2);
            else
                return num1.charAt(n) - num2.charAt(n);
        });
        String[] answer = strings;








        return answer;
    }
}
