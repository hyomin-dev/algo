package com.multi.baekjoon._2DArray;


import java.io.*;
import java.util.StringTokenizer;

public class P_2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int maxValue = -1;
        int maxValueRow = 0;
        int maxValueCol = 0;

        int i=1;
        int j=1;

        while(i<=9){
            StringTokenizer st = new StringTokenizer(br.readLine());
            j=1;
            while(st.hasMoreTokens()){
                int num = Integer.parseInt(st.nextToken());

                if(maxValue<num){
                    maxValue = num;
                    maxValueRow = i;
                    maxValueCol = j;
                }
                j++;
            }
            i++;
        }

        bw.write(String.valueOf(maxValue));
        bw.newLine();
        bw.write(String.valueOf(maxValueRow+" "+maxValueCol));
        bw.flush();
        bw.close();
        br.close();


    }
}
