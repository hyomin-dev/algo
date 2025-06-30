package com.multi.baekjoon.graph;


import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P_2178 {

    static ArrayList<ArrayList<ArrayList<Integer>>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 2<=n
        int m = Integer.parseInt(st.nextToken()); // m<=100

        int[][] maze = new int[n][m];

        for(int i=0;i<n;i++){
            String s = br.readLine();
            for(int j=0;j<m;j++)
                maze[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
        }

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
            for(int j=0;j<=m;j++){
                graph.get(i).add(new ArrayList<>());
            }
        }

        for(int i=0;i<=n;i++){

            for(int j=0;j<=m;j++){

            }
        }


        System.out.println("test");
    }
}
