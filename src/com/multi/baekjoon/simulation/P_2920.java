package com.multi.baekjoon.simulation;


import java.io.*;
import java.util.StringTokenizer;

public class P_2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] array = new int[8];

        for(int i=0;i<8;i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        String result = "mixed";
        if(array[0]==1){
            for(int i=1;i<8;i++){
                if(array[i]!=array[i-1]+1)
                    break;
                if(i==7)
                    result = "ascending";

            }
        }else if(array[0]==8){
            for(int i=1;i<8;i++){
                if(array[i]+1 !=array[i-1])
                    break;
                if(i==7)
                    result="descending";
            }
        }

        bw.write(result);

        bw.flush();
        bw.close();
        br.close();

    }
}
