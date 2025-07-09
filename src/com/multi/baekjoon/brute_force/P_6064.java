package com.multi.baekjoon.brute_force;


import java.io.*;
import java.util.StringTokenizer;

public class P_6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for(int i=0;i<t;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int lcm = findLCM(m,n);

            int result = -1;

           for(int j=x;j<=lcm;j=j+m){
              if((j-y)%n==0){
                  result = j;
                  break;
              }
           }

            bw.write(String.valueOf(result));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();

    }

    static int findLCM(int n1, int n2){
        int lcm = n1*n2;

        for(int i=n1;i<n1*n2;i+=n1){
            if(i%n2==0){
                return i;
            }
        }
        return lcm;
    }
}
/*
* x+M*idx1
* y+N*idx2
* x+M*idx1 == y+N*idx2인 것을 찾으면됨
* 즉 반복문을 돌면서 j == y+N*idx2를 만족하는 것을 찾으면 됨
* ===> j-y == N*idx2
* ===> (j-y)는 N의 배수
* (j-y)%N ==0이면 idx2가 존재
*
* */