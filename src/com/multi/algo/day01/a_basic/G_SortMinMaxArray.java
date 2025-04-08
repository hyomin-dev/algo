package com.multi.algo.day01.a_basic;


import java.util.Arrays;
import java.util.Random;

public class G_SortMinMaxArray {
    public static void main(String[] args) {
        int[] arrays = new int[1000];
        Random r = new Random(42);

        for(int i =0;i< arrays.length;i++){
            arrays[i] = r.nextInt(999)+1;
        }

        System.out.println(Arrays.toString(arrays));

        System.out.println("==============================================================================");
        //정렬
        Arrays.sort(arrays); // 원본 배열이 바뀐다. 시간 복잡도: O(NlogN)
        System.out.println(Arrays.toString(arrays));

        //최소값
        System.out.println("최소값: "+arrays[0]);

        //최대값
        System.out.println("최대값: "+arrays[arrays.length-1]);

    }
}
