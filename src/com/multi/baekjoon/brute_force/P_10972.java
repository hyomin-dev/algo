package com.multi.baekjoon.brute_force;


import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class P_10972 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static boolean[] visited;
    static Stack<Integer> stack;
    static ArrayList<String> strList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        String findArrayStr = br.readLine();

        for(int i=1;i<=n;i++){

            visited = new boolean[n+1];
            stack = new Stack<>();
            stack.push(i);
            dfs(i);
        }

        if(strList.contains(findArrayStr)){
            int findIdx = -1;
            for(int i=0;i<strList.size();i++){
                if(strList.get(i).equals(findArrayStr)) {
                    findIdx = i + 1;
                    break;
                }
            }
            if(findIdx!=-1&&findIdx<strList.size())
                bw.write(strList.get(findIdx));
            else
                bw.write("-1");
        }else{
            bw.write("-1");
        }

        bw.flush();
        bw.close();
        br.close();

    }

    static void dfs(int node) throws IOException{
        visited[node] = true;


        if(stack.size()==n){
            ArrayList<Integer> list = new ArrayList<>(stack);
            StringBuilder sb = new StringBuilder();
            sb.append(list.get(0));
            for(int i=1;i<list.size();i++)
                sb.append(" "+list.get(i));
            strList.add(sb.toString());
            return;
        }
        for(int i=1;i<=n;i++){
            if(!visited[i]){
                stack.push(i);
                dfs(i);
                visited[i] = false;
                stack.pop();
            }
        }
    }
}
