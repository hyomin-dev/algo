package com.multi.baekjoon.tmp;

import java.io.*;
import java.util.*;

public class P_18110 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n+1];

        for(int i=1;i<=n;i++)
            array[i] = Integer.parseInt(br.readLine());

        Arrays.sort(array);

        int excludedNum = (int)Math.round(n*0.15);

        int sum = 0;
        for(int i=excludedNum+1;i<=n-excludedNum;i++)
            sum+=array[i];

        int result = (int)Math.round((double)sum/(n-2*excludedNum));

        bw.write(result+"");

        bw.flush();
        bw.close();
        br.close();

    }
}
