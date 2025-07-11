package com.multi.baekjoon.brute_force;


import java.io.*;
import java.util.StringTokenizer;

public class P_14500 {
    static int n,m;
    static int[][] matrix;
    static int maxValue = 0;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 4<=n
        m = Integer.parseInt(st.nextToken()); // m<=500

        matrix = new int[n][m];
        visited = new boolean[n][m];

        for(int y=0;y<n;y++){
            st = new StringTokenizer(br.readLine());
            for(int x=0;x<m;x++){
                matrix[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        for(int y=0;y<n;y++){
            for(int x=0;x<m;x++){
                visited[y][x] = true;
                search(new int[]{x,y}, matrix[y][x],1);
            }
        }

        bw.write(String.valueOf(maxValue));
        bw.flush();
        bw.close();
        br.close();

    }

    static void search(int[] node,int sum, int depth){

        if(depth==4){
            if(sum>maxValue)
                maxValue=sum;
            return;
        }

        for(int y=0;y<n;y++){
            for(int x=0;x<m;x++){
                if(!visited[y][x]&&isSide(node, new int[]{x,y})){
                    visited[y][x] = true;
                    search(new int[]{x,y},sum +matrix[y][x],depth+1);
                    visited[y][x] = false; // 취소를 해줘야 다음에도 다시 방문할 수 있음
                }
            }
        }
    }

    static boolean isSide(int[] node, int[] side){
        int nodeX = node[0];
        int nodeY = node[1];

        int sideX = side[0];
        int sideY = side[1];

        if(nodeY-1==sideY&&nodeX==sideX) // top
            return true;
        else if(nodeX+1==sideX&&nodeY==sideY) // right
            return true;
        else if(nodeY+1==sideY&&nodeX==sideX) // bottom
            return true;
        else if(nodeX-1==sideX&&nodeY==sideY) // left
            return true;
        else
            return false;

    }
}
