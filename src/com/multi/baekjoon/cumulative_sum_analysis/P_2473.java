package com.multi.baekjoon.cumulative_sum_analysis;

import java.io.*;
import java.util.*;

public class P_2473 {
    static int n;
    static long[] array;
    static long minValue = Long.MAX_VALUE;
    static long[] result = new long[3];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        array = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            array[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(array);

        long sum;
        boolean isFind = false;
        for(int base=0;base<n-2;base++){
            int mid = base+1;
            int end = n-1;

            while(mid<end){
                sum = array[base] + array[mid] + array[end];

                if(Math.abs(sum)<minValue){
                    minValue = Math.abs(sum);
                    result[0] = array[base];
                    result[1] = array[mid];
                    result[2] = array[end];
                }
                if(sum==0) {
                    isFind = true;
                    break;
                }else if(sum<0){
                    mid++;
                }else // sum>0
                    end--;

            }

            if(isFind)
                break;


        }

        bw.write(result[0]+" "+result[1]+" "+result[2]);

        bw.flush();
        bw.close();
        br.close();

    }

}
/*

산성 용액: 1~ 십억
알칼리성 용액: -십업 ~ -1

목표: 세 가지 용액을 혼합하여 특성값이 0에 가장 가까운 용액 만들기

세 가지 용액을 혼합한 용액의 특성값: 각 용액의 특성값의 합으로 정의

1. 용액 정렬

2. 가장 왼쪽 인덱스 고정

3. 가장 왼쪽 인덱스 이후 ~ 오른쪽 끝을 투포인터로 옮겨 보면서 탐색

4. 가장 왼쪽 인덱스를 한칸 오른쪽으로 이동 후 3번 과정을 반복
* */
