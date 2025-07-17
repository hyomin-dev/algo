package com.multi.baekjoon.binary_search_tree;


import java.io.*;
import java.util.StringTokenizer;

public class P_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken()); // 이미 가지고 있는 랜선의 갯수 k<=n
        int n = Integer.parseInt(st.nextToken()); // 필요한 랜선의 갯수, 1<= n <= 1,000,000


        // N개보다 많아도 됨
        // 구해야하는 것: 최대 랜선의 길이, 2^31 -1 보다 작거나 같은 자연수

        int[] array = new int[k];
        int maxLength = 0;
        for(int i=0;i<k;i++){
            array[i] = Integer.parseInt(br.readLine());
            if(maxLength<array[i])
                maxLength = array[i];
        }

        long start = 1;
        long end = maxLength;

        long maximumLength=1;

        while(start<=end){ // 랜선 길이 후보가 1개일 때까지 반복

            long mid = (start+end)/2;

            long count = 0;
            for(int i=0;i<k;i++){
                count = count + array[i]/mid; //랜선 길이가 mid일 때 만들 수 있는 랜선의 갯수
            }

            if(count>=n){ // 필요한 랜선 갯수를 충족한 경우 --> 1개당 랜선 길이를 늘려도 됨
                start = mid+1;
                if(maximumLength<mid) // 랜선 길이 후보(mid)가 현재까지 탐색한 최대 랜선 길이보다 클 경우 교체
                    maximumLength = mid;

            }else{ // 필요한 랜선 갯수가 부족한 경우 --> 1개당 랜선 길이를 줄여야함
                end = mid-1;
            }

        }
        bw.write(String.valueOf(maximumLength));
        bw.flush();
        bw.close();
        br.close();

    }
}

/*
* 2 2
1710480974
1908681832
* */
