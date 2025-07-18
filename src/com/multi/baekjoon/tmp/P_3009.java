package com.multi.baekjoon.tmp;


import java.io.*;
import java.util.StringTokenizer;

public class P_3009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] xArray = new int[3];
        int[] yArray = new int[3];
        for(int i=0;i<3;i++){
            StringTokenizer st  = new StringTokenizer(br.readLine());

            xArray[i] = Integer.parseInt(st.nextToken());
            yArray[i] = Integer.parseInt(st.nextToken());

        }

        if(xArray[0]==xArray[1])
            bw.write(xArray[2]+" ");
        else if(xArray[0]==xArray[2])
            bw.write(xArray[1]+" ");
        else
            bw.write(xArray[0]+" ");

        if(yArray[0]==yArray[1])
            bw.write(yArray[2]+"");
        else if(yArray[0]==yArray[2])
            bw.write(yArray[1]+"");
        else
            bw.write(yArray[0]+"");

        bw.flush();
        bw.close();
        br.close();
    }
}
