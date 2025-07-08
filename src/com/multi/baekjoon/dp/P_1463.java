package com.multi.baekjoon.dp;


import java.io.*;

public class P_1463 {
    static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 1 <= n <= 1,000,000
        array = new int[n+1];
        array[0] = 0;
        array[1] = 0;

        for(int i=2;i<=n;i++){
            if(i%2==0&&i%3==0){
                array[i] = Math.min(array[i/2],Math.min(array[i/3],array[i-1]))+1;
            }else if(i%2 ==0){
                array[i] = Math.min(array[i/2],array[i-1]) +1 ;
            }else if(i%3 ==0){
                array[i] = Math.min(array[i/3],array[i-1]) +1;
            }else
                array[i] = array[i-1]+1;
        }

        bw.write(String.valueOf(array[n]));
        bw.flush();
        bw.close();
        br.close();
    }



}
