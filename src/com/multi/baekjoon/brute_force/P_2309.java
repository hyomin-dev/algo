package com.multi.baekjoon.brute_force;


import java.io.*;
import java.util.Arrays;

public class P_2309 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] heights = new int[9];
        int sum = 0;

        for(int i=0;i<9;i++){
            heights[i] = Integer.parseInt(br.readLine());
            sum +=heights[i];
        }

        Arrays.sort(heights);

        for(int i=0;i<8;i++){
            for(int j=i+1;j<9;j++){
                int tmp = sum - heights[i] - heights[j];
                if(tmp==100){
                    for(int k=0;k<9;k++){
                        if(k==i || k==j)
                            continue;
                        bw.write(String.valueOf(heights[k]));
                        bw.newLine();

                    }
                    bw.flush();
                    bw.close();
                    br.close();
                    return;
                }
            }
        }



    }
}
