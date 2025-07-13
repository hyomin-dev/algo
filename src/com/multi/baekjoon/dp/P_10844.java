package com.multi.baekjoon.dp;


import java.io.*;

public class P_10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        long[][] matrix = new long[n][10];

        for(int i=0;i<10;i++){
            matrix[0][i] = 1;
        }

        for(int y=1;y<n;y++){
            for(int x=0;x<10;x++){
                if(x==0)
                    matrix[y][x] = matrix[y-1][x+1]%1000000000;
                else if(x==9)
                    matrix[y][x] = matrix[y-1][x-1]%1000000000;
                else
                    matrix[y][x] = matrix[y-1][x-1]%1000000000 + matrix[y-1][x+1]%1000000000;
            }
        }

        long result = 0;
        for(int x=1;x<10;x++)
            result += matrix[n-1][x];

        bw.write(String.valueOf(result%1000000000));
        bw.flush();
        bw.close();
        br.close();

    }
}

/*

0 1 2 3 4 5 6 7 8 9 --> 각 숫자로 시작하는 경우의 수

n=1 인 경우 1 1 1 1 1 1 1 1 1 1
n=2 인 경우 1 2 2 2 2 2 2 2 2 1
n=3 인 경우 2 3 4 4 4 4 4 4 3 2
n=4 인 경우 3 6 7 8 8 8 8 7 6 3

n=3인 경우 1로 숫자가 시작하는 경우--> n=2일 때 0으로 시작하는 경우 + n=2일 때 2로 시작하는 경우를 더한 것

최종 계산은 1로 시작하는 경우 ~ 9로 시작하는 경우를 더한 것임
*
* */
