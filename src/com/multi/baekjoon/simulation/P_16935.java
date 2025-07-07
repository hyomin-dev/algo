package com.multi.baekjoon.simulation;


import java.io.*;
import java.util.StringTokenizer;

public class P_16935 {
    static int n,m;
    static int[][] matrix;
    static int[][] matrixTrans;
    static boolean isOriMatrix = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // row, 짝수, 2 <= n <= 100
        m = Integer.parseInt(st.nextToken()); // col, 짝수, 2 <= m <= 100
        int r = Integer.parseInt(st.nextToken()); // 연산횟수, 1 <= r <=1000

        matrix = new int[n][m]; // nxm 행렬
        matrixTrans = new int[m][n]; // mxn 행렬
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int j=0;
            while(st.hasMoreTokens())
                matrix[i][j++] = Integer.parseInt(st.nextToken());
        }

        int[] operations = new int[r];
        st= new StringTokenizer(br.readLine());
        for(int i=0;i<r;i++)
            operations[i] = Integer.parseInt(st.nextToken());

        for(int num: operations){
            switch(num){
                case 1:{ // 상하 반전
                    reverseTopDown();
                    break;
                }
                case 2:{ // 좌우 반전
                    reverseLeftRight();
                    break;
                }
                case 3:{ // 오른쪽 90도 회전
                    transpose();
                    reverseLeftRight();
                    break;
                }
                case 4:{ // 왼쪽 90도 회전
                    transpose();
                    reverseTopDown();
                    break;
                }
                case 5:{ // 4등분 오른쪽 이동
                    operation5();
                    break;
                }
                case 6:{ // 4등분 왼쪽 이동
                    operation6();
                    break;
                }
            }
        }

        if(isOriMatrix){
            for(int y=0;y<n;y++){
                for(int x=0;x<m;x++){
                    bw.write(matrix[y][x]+" ");
                }
                bw.newLine();
            }
        }else{
            for(int y=0;y<m;y++){
                for(int x=0;x<n;x++){
                    bw.write(matrixTrans[y][x]+" ");
                }
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }

    static void reverseLeftRight(){
        if(isOriMatrix){
            for(int y=0;y<n;y++){
                for(int x=0;x<m/2;x++){
                    int tmp = matrix[y][x];
                    matrix[y][x] = matrix[y][m-x-1];
                    matrix[y][m-x-1] = tmp;
                }
            }
        }else{
            for(int y=0;y<m;y++){
                for(int x=0;x<n/2;x++){
                    int tmp = matrixTrans[y][x];
                    matrixTrans[y][x] = matrixTrans[y][n-x-1];
                    matrixTrans[y][n-x-1] = tmp;
                }
            }
        }
    }

    static void reverseTopDown(){
        if(isOriMatrix){
            for(int y=0;y<n/2;y++){
                for(int x=0;x<m;x++){
                    int tmp = matrix[y][x];
                    matrix[y][x] = matrix[n-y-1][x];
                    matrix[n-y-1][x] = tmp;
                }
            }
        }else{
            for(int y=0;y<m/2;y++){
                for(int x=0;x<n;x++){
                    int tmp = matrixTrans[y][x];
                    matrixTrans[y][x] = matrixTrans[m-y-1][x];
                    matrixTrans[m-y-1][x] = tmp;
                }
            }
        }
    }

    static void transpose(){
        if(isOriMatrix){ // transpose를 짝수번 실행
            if(n==m){
                for(int y=0;y<n;y++){
                    for(int x=y+1;x<m;x++){
                        int tmp = matrix[y][x];
                        matrix[y][x] = matrix[x][y];
                        matrix[x][y] = tmp;
                    }
                }
                matrixTrans = matrix;
            }else{
                for(int y=0;y<n;y++){
                    for(int x=0;x<m;x++){
                        matrixTrans[x][y] = matrix[y][x];
                    }
                }

            }
        }else{ // transpose를 홀 수번 실행
            if(n==m){
                for(int y=0;y<m;y++){
                    for(int x=y+1;x<n;x++){
                        int tmp = matrixTrans[y][x];
                        matrixTrans[y][x] = matrixTrans[x][y];
                        matrixTrans[x][y] = tmp;
                    }
                }
                matrix = matrixTrans;
            }else{
                for(int y=0;y<m;y++){
                    for(int x=0;x<n;x++){
                        matrix[x][y] = matrixTrans[y][x];
                    }
                }
            }
        }
        isOriMatrix = !isOriMatrix;
    }

    static void operation5(){
        /*
        * 4개로 나눈 뒤, 오른쪽으로 이동
        * */
        if(isOriMatrix){
            for(int y=0;y<n/2;y++){
                for(int x=0;x<m/2;x++){
                    int tmp = matrix[y][x];
                    matrix[y][x] = matrix[y+n/2][x];
                    matrix[y+n/2][x] = matrix[y+n/2][x+m/2];
                    matrix[y+n/2][x+m/2] = matrix[y][x+m/2];
                    matrix[y][x+m/2] = tmp;
                }
            }
        }else{
            for(int y=0;y<m/2;y++){
                for(int x=0;x<n/2;x++){
                    int tmp = matrixTrans[y][x];
                    matrixTrans[y][x] = matrixTrans[y+m/2][x];
                    matrixTrans[y+m/2][x] = matrixTrans[y+m/2][x+n/2];
                    matrixTrans[y+m/2][x+n/2] = matrixTrans[y][x+n/2];
                    matrixTrans[y][x+n/2] = tmp;
                }
            }
        }
    }

    static void operation6(){
        /*
        * 4개로 나눈 뒤, 왼쪽으로 이동
        * */
        if(isOriMatrix){
            for(int y=0;y<n/2;y++){
                for(int x=0;x<m/2;x++){
                    int tmp = matrix[y][x];
                    matrix[y][x] = matrix[y][x+m/2];
                    matrix[y][x+m/2] = matrix[y+n/2][x+m/2];
                    matrix[y+n/2][x+m/2] = matrix[y+n/2][x];
                    matrix[y+n/2][x] = tmp;
                }
            }
        }else{
            for(int y=0;y<m/2;y++){
                for(int x=0;x<n/2;x++){
                    int tmp = matrixTrans[y][x];
                    matrixTrans[y][x] = matrixTrans[y][x+n/2];
                    matrixTrans[y][x+n/2] = matrixTrans[y+m/2][x+n/2];
                    matrixTrans[y+m/2][x+n/2] = matrixTrans[y+m/2][x];
                    matrixTrans[y+m/2][x] = tmp;
                }
            }
        }
    }
}

/*
* 1번: 상하반전
* 2번: 좌우반전
* 3번: 오른쪽 90도
* 4번: 왼쪽 90도
* 5번: 4개로 나누고, 오른쪽으로 이동
* 6번: 4개로 나누고, 왼쪽으로 이동
* */
