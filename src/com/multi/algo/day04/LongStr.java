package com.multi.algo.day04;


public class LongStr {
    public static void main(String[] args) {
        String s = "i am a java programmer! i am a body.";

        String[] sArr = s.split(" ");
        int maxIdx = 0;
        for(int i=1;i<sArr.length;i++){
            if(sArr[maxIdx].length()<sArr[i].length())
                maxIdx = i;
        }

        System.out.println(sArr[maxIdx]);
     }
}
