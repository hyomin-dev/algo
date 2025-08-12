package com.multi.knowledge.sort;

import java.util.*;

public class UpperBound {
    public static void main(String[] args){
        int[] array = new int[]{1,2,3,4,5,5,5,6,7,8,9}; // size: 11
        System.out.println(upperBound(array,5));

    }

    static int upperBound(int[] array, int key){

        // key보다 큰 값이 처음 나타나는 위치

        int start = 0;
        int end = array.length;

        while(start<end){
            int mid = (start+end)/2;
            if(array[mid]<=key){ // start~mid는 upperBound가 존재 하지 않음
                start = mid+1;
            }else{ // array[mid]>key, start~mid는 uppBound가 존재할 수 있음
                end = mid;
            }
        }

        return start;
    }
}
