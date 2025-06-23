package com.multi.baekjoon.brute_force;


import java.io.*;
import java.util.StringTokenizer;

public class P_2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] cards = new int[n];

        st = new StringTokenizer(br.readLine());
        int i = 0;
        while(st.hasMoreTokens())
            cards[i++] = Integer.parseInt(st.nextToken());

        int sum = 0;

        for(int a=0;a<n-2;a++){
            for(int b=a+1;b<n-1;b++){
                for(int c=b+1;c<n;c++){
                    int tmp =cards[a]+cards[b]+cards[c];
                    if(sum<tmp && tmp<=m)
                        sum = tmp;
                }
            }
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
        br.close();

    }
}


/*
* 참가자: 김정인, 상근, 창영
*
* 양의 정수, N장의 카드
* */

