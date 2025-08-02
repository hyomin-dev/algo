package com.multi.baekjoon.binary_search_tree;


import java.io.*;
import java.util.*;

public class P_2110 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 2 <= n <= 200,000
        int c = Integer.parseInt(st.nextToken()); // 2 <= c <= n

        int[] array = new int[n];

        for(int i=0;i<n;i++)
            array[i] = Integer.parseInt(br.readLine());

        Arrays.sort(array);

        int maxLength = array[n-1] - array[0];

        int result = binarySearch(array,1,maxLength,c);

        bw.write(result+"");

        bw.flush();
        bw.close();
        br.close();

    }

    static int binarySearch(int[] array, int start, int end,int c){

        while(start<=end){

            int mid = (start+end)/2;

            if(calNum(array, mid)<c)
                end = mid-1;
            else
                start = mid+1;
        }

        return end;

    }

    static int calNum(int[] array, int length){
        int count = 1;
        int lastPosition = array[0]; // 첫 집은 무조건 설치

        for(int i=1;i<array.length;i++){

            int l = array[i]-lastPosition;
            if(l>=length){
                lastPosition = array[i];
                count++;
            }

        }

        return count;
    }
}
/*

가장 가까운 공유기 사이의 거리가 최대가 되도록

첫 집은 공유기를 설치 --> 설정한 최대거리로 설치할 수 있는 최대의 공유기를 구할 수 있기 때문

설치 가능한 공유기가 C보다 작다면 --> 설정한 최대 거리를 줄인다.

설치 가능한 공유기가 C보다 크다면 --> 설정한 최대 거리를 늘린다.

설치 가능한 공유기가 C와 같다면 --> 설정한 최대 거리를 늘린다.
* */