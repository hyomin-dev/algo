package com.multi.algo.day01.b_prac;


import java.util.Arrays;
import java.util.Random;

public class App1 {
    public static void main(String[] args) {
        //배열 크기가 20개

        // problem 1
        int[] arrays = {55,66,77,22,33};
        int minIdx = 0;
        for(int i=1;i<arrays.length;i++)
            if(arrays[i]<arrays[minIdx])
                minIdx = i;
        System.out.println("최소값은: "+arrays[minIdx]);

        System.out.println("=======================================================");
        // problem 2
        Random r = new Random(System.currentTimeMillis());

        int[] arrays2 = new int[20];
        for(int i=0;i<arrays2.length;i++){
            arrays2[i] = r.nextInt(900);
        }

        Arrays.sort(arrays2);

        System.out.println("최대값은: "+arrays2[arrays2.length-1]);
        System.out.println("=======================================================");
        // problem 3

        String s1 = "참좋다";
        String s2 = "진짜좋다";

        System.out.println("s1 == s2 = "+s1.equals(s2));
        System.out.println("s1 length == s2 length = "+(s1.length()==s2.length()));

        System.out.println("=======================================================");
        // problem 4

        String s3 = "나는 진짜 java programmer가 되었어";
        String sub = "java programmer";
        int idx = s3.indexOf(sub);

        System.out.println(s3.substring(idx,idx+sub.length()).toUpperCase());

        System.out.println("=======================================================");
        // problem 5

//        String s4 = "2056521";
//        System.out.println(s4.substring(s4.indexOf("2"),s4.indexOf("2")+1));
//        if(s4.substring(s4.indexOf("2")).equals("2"))
//            System.out.println("여자");
//        else
//            System.out.println("남자");



    }
}
