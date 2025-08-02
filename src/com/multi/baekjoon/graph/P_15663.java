package com.multi.baekjoon.graph;

import java.io.*;
import java.util.*;

public class P_15663 {
    static int n, m;
    static int[] array;
    static boolean[] visited;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Stack<Integer> stack = new Stack<>();
    static int[] countArray = new int[10000+1];
    public static void main(String[] args) throws IOException{

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        array = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            array[i] = Integer.parseInt(st.nextToken());
            countArray[array[i]] +=1;
        }

        Arrays.sort(array);
        search(0);

        bw.flush();
        bw.close();

    }

    static void search(int depth) throws IOException{

        if(depth==m){
            ArrayList<Integer> list = new ArrayList<>(stack);
            for(int num: list)
                bw.write(num+" ");
            bw.newLine();
            return;
        }

        for(int i=0;i<n;i++){
            if(i!=0&&array[i]<=array[i-1]){
                continue;
            }
            if(countArray[array[i]]!=0){
                countArray[array[i]] -=1;
                stack.push(array[i]);
                search(depth+1);
                stack.pop();
                countArray[array[i]] +=1;
            }
        }
    }
}
