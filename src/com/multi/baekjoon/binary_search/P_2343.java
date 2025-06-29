package com.multi.baekjoon.binary_search;


import java.io.*;
import java.util.StringTokenizer;

public class P_2343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 강의 수, 1<= n <= 100,000
        int m = Integer.parseInt(st.nextToken()); // 강의 수 1 <= m <= n

        st = new StringTokenizer(br.readLine());
        int[] array = new int[n];

        int totalLength = 0;
        int maxLength = 1; // n개의 강의에서 가장 긴 강의의 길이를 저장
        for(int i=0;i<n;i++){
            array[i] = Integer.parseInt(st.nextToken());
            totalLength +=array[i];
            if(maxLength<array[i])
                maxLength = array[i];
        }

        int start = maxLength;
        int end = totalLength;

        int minimumLength = totalLength; // 가능한 최소 크기의 강의 길이

        while(start<=end){
            int mid = (start+end)/2; // 강의 최소 길이 후보

            int count = 1;
            int sum = 0;
            for(int i=0;i<n;i++){
                if(sum+array[i]>mid){ // 추가하는 강의를 더했을 때, 강의 최소 길이 후보보다 크면 다음 강의에 넣음
                    count++;
                    sum  = array[i];
                }else{ // 추가하는 강의를 더해도, 강의 최소 길이 후보보다 작거나 같은 경우
                    sum +=array[i];
                }
            }

            if(count <=m){ // 구한 강의 수가 m과 같은 경우 --> mid를 줄여봐도 됨 또는 // 구한 강의 수가 m보다 작은 경우 --> mid를 줄여서 한 곳에 더 적은 강의를 넣어야됨
                end = mid -1;
                if(minimumLength >mid)
                    minimumLength = mid;
            }else if(count>m){ // 구한 강의 수가 m보다 큰 경우 --> mid를 키워서 한 곳에 더 많은 강의를 넣어야됨
                start = mid+1;
            }

        }
        bw.write(String.valueOf(minimumLength));
        bw.flush();
        bw.close();
        br.close();


    }
}

/*
* 빈 블루레이가 있어도 m의 갯수만 충족하면 됨
* */
