package com.multi.baekjoon.greedy;


import java.io.*;
import java.util.StringTokenizer;

public class P_1459 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int time = 0;

        if(w*2<s){
            time = (x+y)*w;
        }else{
            int smallPosition = x>y ? y: x;

            int largeposition = x>y ? x: y;

            time = smallPosition*s;

            time += (largeposition-smallPosition)*w;
        }
        bw.write(String.valueOf(time));
        bw.flush();
        bw.close();
        br.close();

    }
}
