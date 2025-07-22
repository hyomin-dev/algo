package com.multi.baekjoon._1DArray;


import java.io.*;
import java.util.*;

public class P_10810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] array = new int[n+1];

        while(m>0){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            for(int i=start;i<=end;i++)
                array[i] = value;
            m--;
        }

        for(int i=1;i<=n;i++)
            bw.write(array[i]+" ");

        bw.flush();
        bw.close();
        br.close();

    }
}
