package com.multi.baekjoon.brute_force;


import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class P_14889 {
    static int n;
    static int[][] matrix;
    static boolean[] visited;
    static int minValue = Integer.MAX_VALUE;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());

        matrix = new int[n][n];
        visited = new boolean[n];
        for(int y=0;y<n;y++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int x=0;x<n;x++){
                matrix[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        //stack.push(0);
        visited[0] = true;
        dfs(0,1);

        bw.write(String.valueOf(minValue));
        bw.flush();
        bw.close();
        br.close();

    }

    static void dfs(int node,int depth){
        if(depth==n/2){
            ArrayList<Integer> team1 = new ArrayList<>();
            ArrayList<Integer> team2 = new ArrayList<>();
            for(int i=0;i<n;i++){
                if(visited[i])
                    team1.add(i);
                else
                    team2.add(i);
            }
            int team1Score = 0;
            int team2Score = 0;
            for(int y=0;y<n/2;y++){
                for(int x=0;x<n/2;x++){
                    if(y==x)
                        continue;
                     // y와 x가 같은 팀, team1
                    team1Score +=matrix[team1.get(y)][team1.get(x)];
                     // y와 x가 같은 팀, team2
                    team2Score +=matrix[team2.get(y)][team2.get(x)];
                }
            }
            int result = Math.abs(team1Score-team2Score);
            if(result<minValue)
                minValue = result;
            return;
        }

        for(int i=node+1;i<n;i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i,depth+1);
                visited[i] =false;
            }
        }

    }
}
