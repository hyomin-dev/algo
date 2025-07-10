package com.multi.baekjoon.dp;


import java.io.*;

public class P_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            int n = Integer.parseInt(br.readLine());
            int[] array = new int[n+1];
            if(n<=2){
                bw.write(String.valueOf(n));
                bw.newLine();
            }else if(n==3){
                bw.write(String.valueOf(4));
                bw.newLine();
            }
            else{
                array[1] = 1;
                array[2] = 2;
                array[3] = 4;
                for(int num=4;num<=n;num++){
                    array[num] = array[num-1] + array[num-2] + array[num-3];
                }
                bw.write(String.valueOf(array[n]));
                bw.newLine();
            }
            bw.flush();
        }

        bw.close();
        br.close();
    }
}

/*
어떤 정수 n을 1, 2, 3의 합으로 표현하기
f(n) = 정수 n을 만드는 방법의 수
n=1 --> 1 --> f(1)=1
n=2 --> 1+1, 2 --> f(2) =2
n=3 --> 1+1+1, 1+2, 2+1, 3 --> f(4) = 4
n=4 --> 1+3, 1+1+2, 2+2, 1+1+1+1, 1+2+1, 2+1+1, 3+1


*
* */
