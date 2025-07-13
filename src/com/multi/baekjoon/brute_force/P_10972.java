package com.multi.baekjoon.brute_force;

import java.io.*;
import java.util.*;

import static java.lang.System.exit;

public class P_10972 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static boolean[] visited;
    static ArrayList<Integer> list;
    static boolean isFind = false;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens())
            q.offer(Integer.parseInt(st.nextToken()));
        list = new ArrayList<>();
        visited = new boolean[n+1];

        int qNum = q.poll();
        for(int i=1;i<=n;i++){
            if(!isFind){
                if(qNum==i) {
                    list.add(qNum);
                    dfs(qNum);
                    visited[i] = false;
                    list.remove(0);
                }
                else
                    continue;
            }else{
                list.add(i);
                dfs(i);
                list.remove(0);
                visited[i] = false;
            }


        }

        bw.write("-1");

        bw.flush();
        bw.close();
        br.close();

    }

    static void dfs(int node) throws IOException{
        visited[node] = true;

        if(!isFind&&q.isEmpty()) {
            isFind = true;
            return;
        }

        if(isFind&&list.size()==n){
            for(int num:list)
                bw.write(num+" ");
            bw.flush();
            bw.close();
            br.close();
            exit(0);
        }

        for(int i=1;i<=n;i++){
            if(visited[i])
                continue;
            if(!isFind){
                if(q.peek()!=i)
                    continue;
                int x = q.poll();
                list.add(x);
                dfs(x);
                visited[x] = false;
                list.remove(list.size()-1);
            }else{
                if(!visited[i]){
                    list.add(i);
                    dfs(i);
                    visited[i] = false;
                    list.remove(list.size()-1);
                }
            }

        }
    }
}
