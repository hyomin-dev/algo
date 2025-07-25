package com.multi.baekjoon.greedy;


import java.io.*;
import java.util.StringTokenizer;

public class P_13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 도시의 개수, 2 <= n <= 100,000

        long[] roadArray = new long[n-1];
        long[] priceArray = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n-1;i++)
            roadArray[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++)
            priceArray[i] = Integer.parseInt(st.nextToken());

        // 현재 위치보다 리터당 가격이 낮은 곳 까지 기름을 채움

        long lowPrice = priceArray[0];

        long sum = lowPrice*roadArray[0];

        for(int i=1;i<n-1;i++){
            long price = priceArray[i];
            if(price<lowPrice)
                lowPrice = price;

            sum += roadArray[i]*lowPrice;
        }

        bw.write(sum+"");

        bw.flush();
        bw.close();
        br.close();

    }
}
/*

기름 통의 크기는 무한

1km 당 1L의 기름을 사용

각 도시에는 하나의 주요소 존재,

주유소마다 리터당 가격이 다를 수 있음

가격의 단위는 원



* */
