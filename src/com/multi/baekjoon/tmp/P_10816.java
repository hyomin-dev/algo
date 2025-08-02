package com.multi.baekjoon.tmp;


/*import java.io.*;
import java.util.*;

public class P_10816 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] array = new int[20000000+1]; // -10000000 --> index는 0

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        while(n>0){
            array[Integer.parseInt(st.nextToken())+10000000]++;
            n--;
        }

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        while(m>0){
            bw.write(array[Integer.parseInt(st.nextToken())+10000000]+" ");
            m--;
        }

        bw.flush();
        bw.close();
        br.close();

    }
}*/

import java.io.*;
import java.util.*;

public class P_10816 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();


        StringTokenizer st = new StringTokenizer(br.readLine());

       for(int i=0;i<n;i++) {
           int num = Integer.parseInt(st.nextToken());
           map.put(num,map.getOrDefault(num,0)+1);
       }

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        while(m>0){
            int num = Integer.parseInt(st.nextToken());
            int result = map.getOrDefault(num,0);
            bw.write(result+" ");
            m--;
        }

        bw.flush();
        bw.close();
        br.close();

    }

}