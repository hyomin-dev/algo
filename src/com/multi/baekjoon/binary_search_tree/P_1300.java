package com.multi.baekjoon.binary_search_tree;

import java.io.*;
import java.util.*;

public class P_1300 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[] array = new int[n*n];
        int idx =0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++)
                array[idx++] = i*j;
        }

        Arrays.sort(array);

        System.out.println(array[k-1]);


    }
}

/*
n=3

1 2 3
2 4 6
3 6 9

--> 1 2 2 3 3 4 6 6 9
* */
