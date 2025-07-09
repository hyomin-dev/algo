package com.multi.baekjoon.brute_force;


import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class P_1182 {
    static int[] array;
    static boolean[] visited;
    static int n, s;
    static int count = 0;
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        array = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            array[i] = Integer.parseInt(st.nextToken());

        for(int size=1;size<=n;size++){
            visited = new boolean[n];
            for(int idx=0;idx<n;idx++){
                visited[idx] = true;
                dfs(idx,size,array[idx],1);
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();

    }

    static void dfs(int node, int size, int sum, int depth){

        if(depth==size){
            if(sum==s)
                count++;
            return;
        }

        for(int idx=node;idx<n;idx++){
            if(!visited[idx]){
                visited[idx] = true;
                sum +=array[idx];
                dfs(idx,size,sum,depth+1);
                sum -=array[idx];
                visited[idx] = false;
            }
        }
    }
}
