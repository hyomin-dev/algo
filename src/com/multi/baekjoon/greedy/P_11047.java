package com.multi.baekjoon.greedy;


import java.io.*;
import java.util.*;

public class P_11047 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] array = new int[n];

        for(int i=0;i<n;i++)
            array[i] = Integer.parseInt(br.readLine());

        int count = 0;
        for(int i=n-1;i>=0;i--){
            if(array[i]>k)
                continue;
            count += k/array[i];
            k = k%array[i];
            if(k==0)
                break;
        }

        bw.write(count+"");

        bw.flush();
        bw.close();
        br.close();

    }
}
