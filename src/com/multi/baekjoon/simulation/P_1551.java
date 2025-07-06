package com.multi.baekjoon.simulation;


import java.io.*;
import java.util.StringTokenizer;

public class P_1551 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 1 <= n <= 20
        int k = Integer.parseInt(st.nextToken()); // 0<= k <= n-1

        int[] array1 = new int[n];
        int[] array2 = new int[n-1];

        boolean isArray1 = true; // array1을 출력하는지 여부

        st = new StringTokenizer(br.readLine(),",");

        for(int i=0;i<n;i++)
            array1[i] = Integer.parseInt(st.nextToken());

        for(int i=1;i<=k;i++){

            if(isArray1){
                array2 = new int[array1.length-1];
                for(int j=0;j<array1.length-1;j++){
                    array2[j] = array1[j+1]-array1[j];
                }

            }else{
                array1 = new int[array2.length-1];
                for(int j=0;j<array2.length-1;j++){
                    array1[j] = array2[j+1]-array2[j];
                }
            }

            isArray1 = !isArray1;

        }

        if(isArray1){ // array1 출력
            bw.write(String.valueOf(array1[0]));
            for(int i=1;i<array1.length;i++)
                bw.write(","+array1[i]);

        }else{
            bw.write(String.valueOf(array2[0]));
            for(int i=1;i<array2.length;i++)
                bw.write(","+array2[i]);
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
