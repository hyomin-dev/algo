package com.multi.baekjoon.dp;

import java.io.*;
import java.util.*;

public class P_1912 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 정수의 개수
        int[] array = new int[n];
        int[] dpTable = new int[n];

        int maxValue = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;

        for(int i=0;i<n;i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        //양수: 누적해서 더해줌
        //음수: 음수를 더했을 때 음수면 다음부터 다시 시작

        dpTable[0] = array[0];
        maxValue = dpTable[0];

        for(int i=1;i<n;i++){
            int tmp = dpTable[i-1] + array[i];
            if(dpTable[i-1]>=0&&array[i]>0) // 이전 누적합 양수, 현재 값도 양수
                dpTable[i] = tmp;
            else if(dpTable[i-1]<0&&array[i]>0) { // 이전 누적값 음수, 현재 값 양수
                dpTable[i] = array[i];
            }
            else if(tmp>0&&array[i]<=0){ //현재 값이 0이하
                dpTable[i] = tmp;
            }else
                dpTable[i] = array[i];

            if(dpTable[i]>maxValue)
                maxValue = dpTable[i];
        }

        bw.write(maxValue+"");

        bw.flush();
        bw.close();
        br.close();

    }


}
