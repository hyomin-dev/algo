package com.multi.baekjoon.tmp;


import java.io.*;
import java.util.StringTokenizer;

public class P_9063 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        while(n>0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y= Integer.parseInt(st.nextToken());

            if(x<minX)
                minX = x;

            if(x>maxX)
                maxX = x;

            if(y<minY)
                minY = y;

            if(y>maxY)
                maxY = y;

            n--;
        }

        bw.write(String.valueOf((maxX-minX)*(maxY-minY)));
        bw.flush();
        bw.close();
        br.close();

    }
}
