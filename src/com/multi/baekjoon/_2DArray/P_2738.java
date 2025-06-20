package com.multi.baekjoon._2DArray;


import java.io.*;
import java.util.StringTokenizer;

public class P_2738 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());


        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] array1 = new int[n][m];
        int[][] array2 = new int[n][m];

        int i=0;
        while(i<n){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                array1[i][j] = Integer.parseInt(st.nextToken());
            }

            i++;
        }

        i=0;
        while(i<n){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                array2[i][j] = Integer.parseInt(st.nextToken());
            }
            i++;
        }

        for(i=0;i<n;i++){
            for(int j=0;j<m;j++){
                bw.write(String.valueOf(array1[i][j]+array2[i][j]));
                bw.write(" ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
