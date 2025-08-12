package com.multi.knowledge.sort;

import java.io.*;
import java.util.*;

public class LowerBound {
    public static void main(String[] args){
        int[] array = new int[]{1,2,3,4,5,5,5,6,7,8,9}; // size: 11

        Arrays.sort(array);

        System.out.println(lowerBound(array,5));

    }

    static int lowerBound(int[] array, int key){
        // key보다 크거나 같은 값이 처음 나타나는 위치

        int start = 0;
        int end = array.length;

        while(start<end){
            int mid = (start+end)/2;
            if(array[mid]<key){  // start~mid에서는 lowerBound가 존재하지 않음
                start = mid+1;
            }else{
                // array[mid] >= key,
                // array[mid] > key --> start~mid에 lowerBound가 존재
                // array[mid] == key --> start~mid사이에 lowerBound가 존재
                end = mid;
            }
        }

        return start;

    }
}
