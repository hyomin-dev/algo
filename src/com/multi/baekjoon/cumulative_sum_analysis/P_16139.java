package com.multi.baekjoon.cumulative_sum_analysis;

import java.io.*;
import java.util.*;

public class P_16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        int[][] sumArray = new int[26][str.length()];

        char firstC = str.charAt(0);
        sumArray[firstC-'a'][0] = 1;
        for(int i=1;i<str.length();i++){
            char c = str.charAt(i);
            for(int j=0;j<26;j++){
                if(j==c-'a'){
                    sumArray[j][i] =sumArray[j][i-1] + 1;
                }else{
                    sumArray[j][i] = sumArray[j][i-1];
                }
            }

        }
        int q = Integer.parseInt(br.readLine());

        while(q>0){

            StringTokenizer st = new StringTokenizer(br.readLine());

            char c = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if(start==0){
                bw.write(sumArray[c-'a'][end]+"\n");
            }else{
                bw.write(sumArray[c-'a'][end]-sumArray[c-'a'][start-1]+"\n");
            }
            q--;
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
/*

4Byte X 200,000 X 26 = 20,800,000

각 문자마다 누적합을 구해놓음

a 6 10 --> 0~10 - 0~5
* */
