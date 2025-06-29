package com.multi.baekjoon.binary_search;


import java.io.*;
import java.util.StringTokenizer;

public class P_2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 지방의 수 3<= n <= 10,000

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[n];

        int maxBudget = 1;
        for(int i=0;i<n;i++) {
            array[i] = Integer.parseInt(st.nextToken()); // 각 지방의 예산
            if(maxBudget < array[i])
                maxBudget = array[i];
        }

        int m = Integer.parseInt(br.readLine()); // 총 예산 n <= m <= 1,000,000,000(십억)

        int start = 1;
        int end = maxBudget;
        int maximumBudget = 1; // 최대 상한액

        while(start<=end){

            int mid = (start+end)/2; // 상한액 후보(mid)

            int sum = 0;
            for(int i=0;i<n;i++){
                sum += Math.min(array[i],mid);
            }

            if(sum<=m){ // 계산한 예산이 총 예산보다 작거나 같은 경우 --> 상한액을 늘려도됨
                start = mid+1;
                if(maximumBudget <mid) // 상한액 후보(mid)가 최대 상한액보다 큰 경우
                    maximumBudget = mid;

            }else{ // 계산한 예산이 총 예산보다 큰 경우 --> 상한액을 줄여야됨
                end = mid-1;
            }

        }

        bw.write(String.valueOf(maximumBudget));
        bw.flush();
        bw.close();
        br.close();

    }
}
