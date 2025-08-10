package com.multi.baekjoon.cumulative_sum_analysis;

import java.io.*;
import java.util.*;

public class P_2143 {

    static int t, n, m;
    static long[] sumA, sumB;
    static HashMap<Long,Long> mapA = new HashMap<>();
    static HashMap<Long,Long> mapB = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        t = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        sumA = new long[n+1];
        sumA[0] = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++)
            sumA[i] = Integer.parseInt(st.nextToken())+sumA[i-1];

        m = Integer.parseInt(br.readLine());
        sumB = new long[m+1];
        sumB[0] = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=m;i++)
            sumB[i] = Integer.parseInt(st.nextToken())+sumB[i-1];

        for(int i=1;i<=n;i++){
            for(int j=i;j<=n;j++){
                long subtotal = sumA[j] - sumA[i-1];
                mapA.put(subtotal, mapA.getOrDefault(subtotal,0L)+1);
            }
        }

        for(int i=1;i<=m;i++){
            for(int j=i;j<=m;j++){
                long subtotal = sumB[j] - sumB[i-1];
                mapB.put(subtotal, mapB.getOrDefault(subtotal,0L)+1);
            }
        }

        long count = 0;
        Set<Long> keySet = mapA.keySet();
        for(long keyA: keySet){
            long countA = mapA.get(keyA);
            long countB = mapB.getOrDefault(t-keyA,0L);
            count +=countA*countB;
        }

        bw.write(count+"");

        bw.flush();
        bw.close();
        br.close();
    }
}
/*


1. 각 배열의 누적합을 구한다

2. 누적합을 이용해 각 배열의 전체 부분합을 HashMap에 담는다.

3. HashMap A와 HashMap B에서 합이 T가 되는 것들을 구한다.
* */
