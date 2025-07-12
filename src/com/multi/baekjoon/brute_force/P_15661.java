package com.multi.baekjoon.brute_force;


import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.lang.System.exit;

public class P_15661 {
    static int n;
    static int[][] matrix;
    static boolean[] visited;
    static int minValue = Integer.MAX_VALUE;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {


        n = Integer.parseInt(br.readLine()); // 4 <= n <= 20

        matrix = new int[n][n];
        visited = new boolean[n];

        for(int y=0;y<n;y++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int x=0;x<n;x++)
                matrix[y][x] = Integer.parseInt(st.nextToken());
        }

        for(int t=1;t<=n/2;t++){
            if(t==n/2&&n%2==0){
                search(0,t,1);
            }else{
                for(int i=0;i<n;i++){
                    search(i,t,1);
                    visited[i] = false;
                }
            }
        }

        bw.write(String.valueOf(minValue));
        bw.flush();
        bw.close();
        br.close();

    }

    static void search(int node, int teamN, int depth) throws IOException{

        visited[node] = true;
        if(depth==teamN){
            ArrayList<Integer> team1 = new ArrayList<>();
            ArrayList<Integer> team2 = new ArrayList<>();

            for(int i=0;i<n;i++){
                if(visited[i])
                    team1.add(i);
                else
                    team2.add(i);
            }

            int team1Score =0;
            int team2Score = 0;

            for(int y:team1){
                for(int x:team1){
                    if(y==x)
                        continue;
                    team1Score += matrix[y][x];
                }
            }

            for(int y:team2){
                for(int x:team2){
                    if(y==x)
                        continue;
                    team2Score += matrix[y][x];
                }
            }

            int result = Math.abs(team1Score-team2Score);
            if(result<minValue)
                minValue = result;

            if(minValue==0){
                bw.write("0");
                bw.flush();
                bw.close();
                br.close();
                exit(0);

            }
            return;
        }

        for(int x=node+1;x<n;x++){
            if(!visited[x]){
                search(x,teamN,depth+1);
                visited[x] = false;
            }
        }
    }
}

/*

한 팀에 최소 한명은 있어야 됨

n= 짝수
ex) n=6
1:5 --> 6C1
2:4 --> 6C2
3:3 ---> 반만 고려하면 됨 6C3의 절반만


ex) n=7
1:6 --> 7C1
2:5 --> 7C2
3:4 --> 7C3

*
* */
