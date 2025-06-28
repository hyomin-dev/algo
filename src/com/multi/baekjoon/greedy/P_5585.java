package com.multi.baekjoon.greedy;


import java.io.*;

public class P_5585 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int[] money = new int[]{500, 100, 50, 10, 5, 1};

        int price = Integer.parseInt(br.readLine());

        int change = 1000-price;

        int count = 0;

        for(int i=0;i<money.length;i++){

            int n = change/money[i]; // 거스름돈 개수
            count += n;

            change = change - n*money[i];

        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();

    }
}
