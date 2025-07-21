package com.multi.baekjoon.brute_force;

import java.util.*;
import java.io.*;

public class P_7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Map<Integer, int[]> map = new HashMap<>();
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            map.put(i,new int[]{weight, height});
        }

        Set<Integer> keySet = map.keySet();

        for(int selfKey:keySet){
            int count = 0;
            for(int otherKey:keySet){
                if(selfKey==otherKey)
                    continue;

                // 자신보다 크면 카운트

                int[] selfValue = map.get(selfKey);
                int[] otherValue = map.get(otherKey);

                if(selfValue[0]<otherValue[0]&&selfValue[1]<otherValue[1])
                    count++;
            }
            bw.write(count+1+" ");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
