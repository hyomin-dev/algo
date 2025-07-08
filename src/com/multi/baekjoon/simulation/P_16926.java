package com.multi.baekjoon.simulation;


import java.io.*;
import java.util.StringTokenizer;

public class P_16926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 2 <= n, m <= 300
        int n = Integer.parseInt(st.nextToken()); // row
        int m = Integer.parseInt(st.nextToken()); // col

        int r = Integer.parseInt(st.nextToken()); // 회전의 수, 1 <= r <= 1000

        int[][] matrix = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int j=0;
            while(st.hasMoreTokens())
                matrix[i][j++] = Integer.parseInt(st.nextToken());
        }

        int shortSide = n > m ? m: n;
        while(r>0) {
            for (int i = 0; i < shortSide / 2; i++) { // 00, 11, 22, ... < n/2
                int tmp = matrix[i][i];

                // 위쪽 ii~위쪽 오른쪽 끝 원소까지 한칸씩 이동함
                for (int x = i + 1; x < m - i; x++) {
                    matrix[i][x - 1] = matrix[i][x];
                }

                // 오른쪽의 원소들을 한칸 씩 위로 이동
                for (int y = i + 1; y < n - i; y++) {
                    matrix[y - 1][m - i-1] = matrix[y][m - i-1];
                }

                //아랫쪽
                for (int x = m - i - 2; x >= i; x--) {
                    matrix[n - i - 1][x + 1] = matrix[n - i - 1][x];
                }

                //왼쪽
                for (int y = n - i - 2; y > i; y--) {
                    matrix[y + 1][i] = matrix[y][i];
                }
                matrix[i + 1][i] = tmp;
            }
            r--;
        }

        for(int y=0;y<n;y++){
            for(int x=0;x<m;x++){
                bw.write(matrix[y][x]+" ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();

    }

}
