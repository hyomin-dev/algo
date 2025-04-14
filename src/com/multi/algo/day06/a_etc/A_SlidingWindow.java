package com.multi.algo.day06.a_etc;


import java.util.HashMap;
import java.util.Map;

public class A_SlidingWindow {
    /* 슬라이딩 윈도우는 배열이나 문자열 같은 데이터 구조를 일정한 크기의 ＇윈도우＇ 또는 ＇창＇을 이동시켜가며 주어진 문제를 해결하는 기법
     * 이 윈도우는 데이터의 특정 범위를 가리키며, 시작점과 끝점  (투포인터)이 함께 오른쪽으로(또는 필요에 따라 왼쪽으로) 이동하면서 문제의 조건을 만족하는지를 확인 ,
     * 아나그램은 두 문자열이 서로 같은 문자를 동일한 횟수만큼 포함하고 있지만, 순서가 다를 수 있는관계 , adbabda 과 aaabbdd  는 아나그램
     *
     *  즉, 슬라이딩 윈도우는 문제의 해결을 위해 데이터를 순차적으로 탐색하는 방법
     *      윈도우의 시작과 끝을 조절하면서 전체 데이터를 한 번만 훑으면서 문제 해결,
     *      윈도우 = 연속된 부분을 탐색하는 시작점과 끝점의 범위
     *
     *      아나그램(애너그램)은 같은 문자들을 가지고 있지만 순서만 다른 단어
     */

    public static void main(String[] args) {
        String data = "adbabda"; // 4번 나온다.
        String ana = "abd";

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = null;

        //map1.equals(map2)
        // key가 같은지 비교


        for (char c : ana.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }


        System.out.println("map1 -->" + map1);

        // count 변수
        int count = 0;
// data 를 인덱스0 부터 데이터길이에서 찾을문자열 길이만큼 뺀 크기만금 for문 돌면서 비교, 길이가 작으면 어차피 틀린거니까
        for (int i = 0; i <= data.length() - ana.length(); i++) {
            // for문 안에서
            // data 를 잘라서 비교 할 맵을 만들어줌
            map2 = new HashMap<>();


            // 찾을 문자열 을 for 문 돌리면서 비교 -> 문자가 일치하면 map2 에 담고 밸류 증가
            for (int j = i; j < i + ana.length(); j++) {
                char ch = data.charAt(j);
                map2.put(ch, map2.getOrDefault(ch, 0) + 1);
            }
            System.out.println("윈도우 [" + i + " ~ " + (i + ana.length() - 1) + "] → map2: " + map2);
            // map1과 map2 비교 해서 일치하면 count 증가
            if(map1.equals(map2))
                count++;


            // for 문끝

        }
        // count 출력
        System.out.println(count);
        System.out.println("========================================================");


//        int length = ana.length();
//        int dataLength = data.length();
//        int count= 0;
//
//
//        // substring(0,size)
//        // substring(1, size+1)
//        // substring(2, size+2)
//        // 길이가 5라면
//        // 0 1 2 3 4 --> 5-3> size-length<i
//
//        for(int i=0;i<dataLength;i++){
//            if(dataLength-length<i)
//                break;
//
//
//
//        }
//
//        for(int i=0;i<ana.length();i++)
//            map1.put(ana.charAt(i),map1.getOrDefault(ana.charAt(i),0));
//
//        for(int i=0;i<data.length();i++)
//            map1.put(data.charAt(i),map1.getOrDefault(data.charAt(i),0)+1);
//
//        System.out.println();



    }
}
