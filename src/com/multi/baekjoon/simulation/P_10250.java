package com.multi.baekjoon.simulation;


import java.io.*;
import java.util.StringTokenizer;

public class P_10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while(t>0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int yy,xx;
            if(n%h==0) {
                yy = h;
                xx = n/h;
            }
            else {
                yy = n % h;
                xx = n/h+1;
            }


            if(xx<10){
                bw.write(yy+"0"+xx);
            }else{
                bw.write(String.valueOf(yy)+String.valueOf(xx));
            }
            bw.newLine();

            t--;
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
