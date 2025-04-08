package com.multi.algo.day01.a_basic;


import java.util.Arrays;
import java.util.Random;

public class E_MaxArray {
    public static void main(String[] args) {

        // 랜덤한 값  발생시켜 배열에 넣어 최소값을 구하기 //1~999범위값!
        Random r = new Random();

        int[] arrays = new int[1000];
        for(int i =0;i<arrays.length;i++) {
            r.setSeed(i+System.currentTimeMillis());
            arrays[i] = r.nextInt(999)+1;
        }
        int maxIdx = 0;
        for(int i=1;i<arrays.length;i++) {
            if (arrays[i] < arrays[maxIdx])
                maxIdx = i;
        }
        System.out.println(Arrays.toString(arrays));

        System.out.println("최소 값: "+arrays[maxIdx]);





    }
}
