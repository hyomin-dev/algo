package com.multi.baekjoon.pratice;



import java.io.*;
import java.util.StringTokenizer;

public class P_2525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int hour = Integer.parseInt(st1.nextToken());
        int miniute = Integer.parseInt(st1.nextToken());

        int duration = Integer.parseInt(st2.nextToken());

        int endMiniute = (miniute+duration)%60;

        int endHour = (hour+(miniute+duration)/60) %24;

        bw.write(endHour+"");
        bw.write(" "+endMiniute);
        bw.close();
        br.close();


    }
}
