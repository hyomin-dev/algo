package com.multi.baekjoon.pratice;


import java.io.*;
import java.util.StringTokenizer;

public class P_2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        int num3 = Integer.parseInt(st.nextToken());

        //같은 눈이 3개인 경우
        int price = 0;
        if(num1 == num2 && num1 == num3){
            price = 10000+num1*1000;
        }else if(num1!=num2 && num1!=num3 && num2!=num3){
            // num1 이 가장 큰 가?
            if(num1>num2&& num1>num3)
                price = num1*100;
            //num2가 가장 큰가?
            else if(num2>num1&&num2>num3)
                price = num2*100;
            else
                price = num3*100;
        }else if(num1 == num2){
            price = 1000+num1*100;
        }else if(num1==num3){
            price = 1000+num1*100;
        }else if(num2==num3){
            price = 1000+num2*100;
        }

        bw.write(price+"");
        bw.close();
        br.close();



    }
}
