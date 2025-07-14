package com.multi.baekjoon.simulation;


import java.io.*;
import java.util.StringTokenizer;

public class P_16931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 세로
        int m = Integer.parseInt(st.nextToken()); // 가로

        if(n==1&&m==1) {
            br.readLine();
            bw.write("6");
        }
        else{
            int[][] matrix = new int[n][m];
            for(int y=0;y<n;y++){
                st = new StringTokenizer(br.readLine());
                for(int x=0;x<m;x++){
                    matrix[y][x] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 2*n*m; // 밑에서 봤을 때 + 위에서 봤을 때

            // 왼쪽에서 봤을 때
            for(int y=0;y<n;y++){
                int init = matrix[y][0]; // 왼쪽에서 봤을 때, 가장 앞에 있는 것의 겉넓이
                for(int x=1;x<m;x++){
                    if(matrix[y][x]>matrix[y][x-1]){ // 뒤에 있는 것이 앞에 있는 것보다 큰 경우 --> 차이만큼 겉넓이에 추가
                        init += matrix[y][x] - matrix[y][x-1];
                    }
                }
                count +=init;
            }

            //위쪽에서 봤을 때
            for(int x=0;x<m;x++){
                int init = matrix[0][x]; // 위쪽에서 봤을 때, 가장 앞에 있는 것의 겉넓이
                for(int y=1;y<n;y++){
                    if(matrix[y][x]>matrix[y-1][x]){ // 뒤에 있는 것이 앞에 있는 것보다 큰 경우 --> 차이만큼 겉넓이에 추가
                        init += matrix[y][x] - matrix[y-1][x];
                    }
                }
                count += init;
            }

            //오른쪽에서 봤을 때
            for(int y=0;y<n;y++){
                int init = matrix[y][m-1]; // 오른쪽에서 봤을 때, 가장 앞에 있는 것의 겉넓이
                for(int x=m-2;x>=0;x--){
                    if(matrix[y][x]>matrix[y][x+1]) // 뒤에 있는 것이 앞에 있는 것보다 큰 경우 --> 차이만큼 겉넓이에 추가
                        init +=matrix[y][x] - matrix[y][x+1];
                }
                count+=init;
            }

            //아래쪽에서 봤을 때
            for(int x=0;x<m;x++){
                int init = matrix[n-1][x]; // 아래쪽에서 봤을 때, 가장 앞에 있는 것의 겉넓이
                for(int y=n-2;y>=0;y--){
                    if(matrix[y][x]>matrix[y+1][x]) { // 뒤에 있는 것이 앞에 있는 것보다 큰 경우 --> 차이만큼 겉넓이에 추가
                        init += matrix[y][x] - matrix[y+1][x];
                    }
                }
                count +=init;
            }

            bw.write(String.valueOf(count));
        }

        bw.flush();
        bw.close();
        br.close();

    }
}

