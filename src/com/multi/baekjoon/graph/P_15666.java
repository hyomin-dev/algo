package com.multi.baekjoon.graph;

import java.io.*;
import java.util.*;

public class P_15666 {
    static int n,m;
    static int[] array;
    static Stack<Integer> stack = new Stack<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        array = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            array[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(array);

        search(0,0);

        bw.flush();
        bw.close();
        br.close();

    }

    static void search(int curr, int depth) throws IOException{
        if(depth==m){
            ArrayList<Integer> list = new ArrayList<>(stack);
            for(int num: list){
                bw.write(num+" ");
            }

            bw.newLine();
            return;
        }

        for(int i=curr;i<n;i++){
            if(i!=0&&array[i]<=array[i-1])
                continue;

            stack.push(array[i]);
            search(i,depth+1);
            stack.pop();
        }
    }
}
