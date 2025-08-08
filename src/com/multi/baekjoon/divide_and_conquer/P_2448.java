package com.multi.baekjoon.divide_and_conquer;

import java.io.*;
import java.util.*;

public class P_2448 {
    static int n;
    static char[][] matrix;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        matrix = new char[n+1][2*n+1]; // 인덱스 1부터 시작하기 위함

        // 중앙: n
        // start:n에서 하나씩 뺌
        // end: n에서 하나씩 증가

        for(int i=1;i<=n;i++) // 빈칸 채우기
            Arrays.fill(matrix[i],' ');

        int start = n;
        int end = n;

        for(int y=1;y<=n;y++){ // 별로 채우기
            for(int x=start;x<=end;x++)
                matrix[y][x] = '*';
            start--;
            end++;
        }

        star(n,n/2+1,n);

        for(int y=1;y<=n;y++){
            for(int x=1;x<=2*n;x++){
                bw.write(String.valueOf(matrix[y][x]));
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();

    }
    /*

    높이: n/2+1
    중앙
    * */
    static void star(int n, int h, int mid){

        int halfN = n/2;
        //빈 칸
        int start = mid-(halfN-1); // 시작열
        int end = mid +(halfN-1); // 끝나는 열
        for(int y=h;y<h+halfN;y++){
            for(int x=start;x<=end;x++)
                matrix[y][x] = ' ';
            start++;
            end--;

        }
        if(n==3)
            return;

        // 위쪽
        if(n==6)
            star(halfN,h-2,mid);
        else
            star(halfN,h-(halfN/2),mid);

        // 왼쪽
        star(halfN, h+(halfN/2),mid-halfN);

        // 오른쪽
        star(halfN,h+(halfN/2),mid+halfN);

    }
}

/*
별을 찍을 생각하지말고 matrix만들어서 채워서 한번에 출력

n= 6
높이: 6
밑변: 12-1
빈 곳: 4~8, 5~7, 6
빈 곳 시작 위치: 6-2 --> 6/2 -1

n=12
높이: 12
밑변: 24-1
빈 곳: 7~17, 8~16, 9~15, 10~14, 11~13, 12~12,
빈곳 시작 위치: 12-5 --> 12/2 -1

n=24
높이: 24
밑변: 48-`
빈 곳: 13~35, 14~34, 15~33, 16~32, 17~31, 18~30, 19~29, 20~28, 21~27, 22~26, 23~25, 24~24
빈 곳 시작 위치: 24-11 --> 24/2-1
* */
