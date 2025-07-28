package com.multi.baekjoon.divide_and_conquer;

import java.io.*;
import java.util.*;

public class P_1992 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] matrix = new int[n][n];
        for(int y=0;y<n;y++){
            String s = br.readLine();
            for(int x=0;x<n;x++)
                matrix[y][x] = s.charAt(x) - '0';
        }

        String result = quadTree(matrix,n,0,0);

        bw.write(result);

        bw.flush();
        bw.close();
        br.close();
    }

    static String quadTree(int[][] matrix, int n, int startX, int startY){

        for(int y=startY; y<startY+n;y++){
            for(int x=startX; x<startX+n;x++){
                if(matrix[startY][startX]!=matrix[y][x]){
                    int halfN = n/2;
                    String result = "(";
                    result += quadTree(matrix, halfN, startX,startY);
                    result += quadTree(matrix, halfN, startX+halfN,startY);
                    result += quadTree(matrix, halfN, startX,startY+halfN);
                    result += quadTree(matrix, halfN, startX+halfN, startY+halfN);
                    result +=")";

                    return result;

                }
            }
        }

        return matrix[startY][startX]+"";

    }
}
