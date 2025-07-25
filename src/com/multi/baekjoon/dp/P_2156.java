package com.multi.baekjoon.dp;


import java.io.*;
import java.util.*;

public class P_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int result = 0;
        if(n==1){
            result = Integer.parseInt(br.readLine());
        }else if(n==2){
            result = Integer.parseInt(br.readLine()) + Integer.parseInt(br.readLine());
        }else{
            int[] array = new int[n+1];
            int[][] dpTable = new int[n+1][2]; // 0: 두번 연속 잔을 선택 한 경우, 1: 한 잔 건너뛰어서 선택한 경우
            for(int i=1;i<=n;i++)
                array[i] = Integer.parseInt(br.readLine());

            dpTable[1][0] = array[1];
            dpTable[2][0] = array[1]+array[2];
            dpTable[2][1] = array[2];

            result = dpTable[2][0];

            for(int i=3;i<=n;i++){
                dpTable[i][0] = dpTable[i-1][1] + array[i];
                dpTable[i][1] = Math.max(dpTable[i-2][0],dpTable[i-2][1]) + array[i];

                if(result<dpTable[i][0])
                    result = dpTable[i][0];

                if(result<dpTable[i][1])
                    result = dpTable[i][1];

            }
        }

        bw.write(result+"");

        bw.flush();
        bw.close();
        br.close();

    }
}
