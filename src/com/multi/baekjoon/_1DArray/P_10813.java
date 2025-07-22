package com.multi.baekjoon._1DArray;


import java.io.*;
import java.util.*;

public class P_10813 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] array = new int[n+1];
        for(int i=1;i<=n;i++)
            array[i] = i;

        while(m>0){

            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            int tmp = array[num1];
            array[num1] = array[num2];
            array[num2] = tmp;

            m--;
        }

        for(int i=1;i<=n;i++)
            bw.write(array[i]+" ");

        bw.flush();
        bw.close();
        br.close();

    }
}
