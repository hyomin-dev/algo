package com.multi.baekjoon.cumulative_sum_analysis;

import java.io.*;
import java.util.*;

public class P_10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] valueArray = new long[n]; // i행: 자신 뒤에 숫자가 몇개 있는지,
        long[] restArray = new long[m];

        st = new StringTokenizer(br.readLine());

        long count = 0;
        for(int i=0;i<n;i++) {
            int num = Integer.parseInt(st.nextToken());

            if(i==0){
                valueArray[i] = (num%m)%m;
            }else{
                valueArray[i] = (valueArray[i-1] + num%m)%m;
            }

            if(valueArray[i]==0)
                count++;

            restArray[(int)valueArray[i]] +=1;
        }

        for(int i=0;i<m;i++){
            long num = restArray[i];
            count += num*(num-1)/2;
        }

        bw.write(count+"");

        bw.flush();
        bw.close();
        br.close();

    }
}
/*


* */
