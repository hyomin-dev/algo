package com.multi.baekjoon.brute_force;


import java.io.*;
import java.util.*;

public class P_18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 세로
        int m = Integer.parseInt(st.nextToken()); // 가로
        int b = Integer.parseInt(st.nextToken()); // 인벤토리 블록 개수

        int[][] map = new int[n][m];
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        for(int y=0;y<n;y++){
            st = new StringTokenizer(br.readLine());
            for(int x=0;x<m;x++){
                map[y][x] = Integer.parseInt(st.nextToken());

                if(minValue>map[y][x])
                    minValue = map[y][x];

                if(maxValue<map[y][x])
                    maxValue = map[y][x];
            }
        }

        int minTime = Integer.MAX_VALUE;
        ArrayList<Integer> hList = new ArrayList<>();
        for(int h=minValue;h<=maxValue;h++){
            int time = calTime(b,h,n,m,map);

            if(time<minTime) {
                minTime = time;
                hList = new ArrayList<>();
                hList.add(h);
            }else if(time == minTime)
                hList.add(h);
        }

        if(hList.size()>1){
            Collections.sort(hList,Collections.reverseOrder());
        }

        bw.write(minTime + " "+hList.get(0));

        bw.flush();
        bw.close();
        br.close();

    }

    static int calTime(int inventory,int target, int n, int m ,int[][] map){

        int spendTime = 0;
        for(int y=0;y<n;y++){
            for(int x=0;x<m;x++){
                if(map[y][x]==target)
                    continue;
                else if(map[y][x]>target){ // 1번 연산
                    int diff = map[y][x] - target;
                    inventory += diff;
                    spendTime +=2*diff;
                }else{ // 2번 연산
                    int diff = target - map[y][x];
                    inventory -= diff;
                    spendTime +=diff;
                }

            }
        }

        if(inventory>=0)
            return spendTime;
        else
            return Integer.MAX_VALUE;
    }
}
