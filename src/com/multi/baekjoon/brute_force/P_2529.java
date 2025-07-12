package com.multi.baekjoon.brute_force;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P_2529 {

    static int k;
    static boolean[] visited = new boolean[10];
    static ArrayList<Integer> list = new ArrayList<>();
    static long maxValue = Long.MIN_VALUE;
    static long minValue = Long.MAX_VALUE;
    static char[] soi;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        soi = new char[k];
        for(int i=0;i<k;i++)
            soi[i] = st.nextToken().charAt(0);

        for(int i=0;i<10;i++){
            list.add(i);
            search(i,1);
            list.remove(0);
            visited[i] = false;
        }

        String strMax = String.valueOf(maxValue);
        String strMin = String.valueOf(minValue);

        if(strMax.length()<k+1){
            int zeroNum = k+1 - strMax.length();
            for(int i=0;i<zeroNum;i++)
                bw.write("0");
        }
        bw.write(String.valueOf(maxValue));

        bw.newLine();

        if(strMin.length()<k+1){
            int zeroNum = k+1 - strMin.length();
            for(int i=0;i<zeroNum;i++)
                bw.write("0");
        }
        bw.write(String.valueOf(minValue));
        bw.flush();
        bw.close();
        br.close();

    }

    static void search(int node, int depth){
        visited[node] = true;

        if(depth==k+1){
            for(int i=0;i<k;i++){
                if(soi[i]=='<'){
                    if(list.get(i)>=list.get(i+1))
                        return;
                }else{
                    if(list.get(i)<=list.get(i+1))
                        return;
                }
            }
            StringBuilder sb = new StringBuilder();

            for(int num:list){
                sb.append(num);
            }
            long result = Long.parseLong(sb.toString());

            if(result>maxValue)
                maxValue = result;

            if(result<minValue)
                minValue = result;

            return;
        }

        for(int i=0;i<10;i++){
            if(!visited[i]){
                list.add(i);
                search(i,depth+1);
                list.remove(list.size()-1);
                visited[i] =false;
            }
        }
    }
}
