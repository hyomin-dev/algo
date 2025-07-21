package com.multi.baekjoon.tmp;

import java.io.*;
import java.util.*;

public class P_11659 {
    public static void main(String[] args)  throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] array = new int[n+1];

        st = new StringTokenizer(br.readLine());

        array[0] = 0;
        for(int i=1;i<=n;i++)
            array[i] = Integer.parseInt(st.nextToken())+array[i-1];

        while(m>0){

            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int result = array[end] - array[start-1];
            bw.write(result+"\n");
            m--;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
