package com.multi.baekjoon.simulation;

import java.io.*;
import java.util.*;

public class P_30802 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] array = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<6;i++)
            array[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int sum = 0;
        for(int i=0;i<6;i++){
            if(array[i]%t==0){
                sum +=array[i]/t;
            }else
                sum +=array[i]/t +1;
        }

        bw.write(sum+"\n");

        bw.write(n/p+" "+n%p);

        bw.flush();
        bw.close();
        br.close();

    }
}
/*
참가자들에게 티셔츠 한 장과 펜 한 자루 나눠줌

* */