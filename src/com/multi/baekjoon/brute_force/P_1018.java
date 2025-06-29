package com.multi.baekjoon.brute_force;


import java.io.*;
import java.util.StringTokenizer;

public class P_1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 세로
        int m = Integer.parseInt(st.nextToken()); // 가로

        char[][] array = new char[n][m];

        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<m;j++)
                array[i][j] = str.charAt(j);
        }

        int minValue = 8*8; // 최악의 경우

        for(int nn=0;nn<=(n-8);nn++){ // 세로
            for(int mm=0;mm<=(m-8);mm++){ // 가로
                int val = calBox(array, nn, mm);
                if(val<minValue)
                    minValue = val;
            }
        }

        bw.write(String.valueOf(minValue));
        bw.flush();
        bw.close();
        br.close();

    }
    static int calBox(char[][] array, int row, int col){

        int countB = 0;
        char startB = 'B';
        for(int i=row;i<row+8;i++){
            for(int j=col;j<col+8;j++){

                if((i+j-row-col)%2==0){
                    //(0,0)과 같아야됨
                    if(!(startB == array[i][j]))
                        countB++;
                }else{
                    // (0,0)과 달라야됨
                    if(startB==array[i][j])
                        countB++;
                }
            }
        }

        int countW = 0;
        char startW = 'W';
        for(int i=row;i<row+8;i++){
            for(int j=col;j<col+8;j++){

                if((i+j-row-col)%2==0){
                    //(0,0)과 같아야됨
                    if(!(startW == array[i][j]))
                        countW++;
                }else{
                    // (0,0)과 달라야됨
                    if(startW==array[i][j])
                        countW++;
                }
            }
        }


        return countB > countW ? countW : countB;
    }
}

/*
*
* 0~9: 세로(n), 0~7, 1~8, 2~9까지는 가능 --> 0~(n-8)
* 0~12: 가로(m), 0~7, 1~8, 2~9, 3~10, 4~11, 5~12까지는 가능 --> 0~(m-8)까지는 가능
*
* 가로의 좌표와 세로의 좌표의 합이 짝수인 것과 홀수 인 것으로 구분하면 됨
*
* */