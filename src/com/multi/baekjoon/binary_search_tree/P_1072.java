package com.multi.baekjoon.binary_search_tree;

import java.io.*;
import java.util.*;

public class P_1072 {
    static long x,y,z;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        if(x==y)
            bw.write("-1");
        else{
            z = (long)((double)y*100/x);

            long count = binarySearch(x,Integer.MAX_VALUE);

            long newZ =(long)((double)(count-x+y)*100/count);

            if(newZ==z)
                bw.write("-1");
            else
                bw.write(count-x+"");

        }

        bw.flush();
        bw.close();
        br.close();

    }

    static long binarySearch(long start, long end){
        if(start>end)
            return start;

        long mid = (start+end)/2;

        long extra = mid-x;

        long newZ = (long)((double)(y+extra)*100/mid);

        if(newZ<=z){ // 새롭게 구한 승률이 기존과 같다면
            return binarySearch(mid+1,end);
        }else // 새롭게 구한 승률이 기존보다 크다면
            return binarySearch(start,mid-1);

    }
}
