package com.multi.baekjoon.pratice;


import java.io.*;
import java.util.StringTokenizer;

public class P_25304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int totalPrice = Integer.parseInt(br.readLine());
        int count = Integer.parseInt(br.readLine());

        int i=0;
        int sum=0;
        while(i<count){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int Eachprice = Integer.parseInt(st.nextToken());
            int EachNum = Integer.parseInt(st.nextToken());
            sum += (Eachprice*EachNum);
            i++;
        }

        if(totalPrice==sum)
            bw.write("Yes");
        else
            bw.write("No");

        bw.close();
        br.close();
    }
}
