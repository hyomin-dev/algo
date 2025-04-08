package com.multi.algo.day01.a_basic;


public class D_MinArray {
    public static void main(String[] args) {
        int[] s = {90,80,20,60,70};

        int minIdx = 0;
        for(int i=1;i<s.length;i++){
            if(s[i]<s[minIdx])
                minIdx = i;
        }
        System.out.println("최소 값: "+s[minIdx]);

    }
}
