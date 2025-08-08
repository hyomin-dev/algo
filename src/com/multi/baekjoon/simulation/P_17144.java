package com.multi.baekjoon.simulation;

import java.io.*;
import java.util.*;

public class P_17144 {
    static int r,c,t;
    static int[][] map;
    static ArrayList<int[]> machine = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken()); // 행
        c = Integer.parseInt(st.nextToken()); // 열
        t = Integer.parseInt(st.nextToken()); // t초 후

        map = new int[r][c];

        for(int y=0;y<r;y++){
            st = new StringTokenizer(br.readLine());
            for(int x=0;x<c;x++){
                map[y][x] = Integer.parseInt(st.nextToken());
                if(map[y][x]==-1)
                    machine.add(new int[]{x,y});
            }
        }

        step();

        int totalDust = 0; // t초 후에 남아 있는 미세먼지 양

        for(int y=0;y<r;y++){
            for(int x=0;x<c;x++){
                if(map[y][x]!=-1)
                    totalDust +=map[y][x];
            }
        }

        bw.write(totalDust+"");

        bw.flush();
        bw.close();
        br.close();

    }

    static void step(){

        for(int time=1;time<=t;time++){
            spread(); // 미세먼지 확산
            purify(); // 공기 청정기 작동
        }

    }

    static void spread(){
        int[][] dust = new int[r][c];
        int[] dx = new int[]{0,0,-1,1}; // 상 하 좌 우
        int[] dy = new int[]{-1,1,0,0}; // 상 하 좌 우

        for(int y=0;y<r;y++){
            for(int x=0;x<c;x++){
                if(map[y][x]==-1) // 공기 청정기인 경우
                    dust[y][x] = -1;
                else if(map[y][x]<5) // 미세먼지가 5미만이면 확산이 안됨
                    dust[y][x] += map[y][x];
                else{
                    int spreadQuantity = map[y][x]/5; // 상 하 좌 우 각 칸에 확산되는 미세먼지의 양
                    int count = 0; // 상 하 좌 우 확산 개수
                    for(int i=0;i<4;i++){
                        int moveX = x+dx[i];
                        int moveY = y+dy[i];
                        if(moveX<0 || moveX>=c || moveY <0 || moveY>=r) // 범위를 벗어난 경우
                            continue;
                        if(map[moveY][moveX]==-1) // 해당 칸이 공기 청정기 칸인 경우
                            continue;
                        dust[moveY][moveX] +=spreadQuantity;
                        count++;
                    }

                    dust[y][x] += map[y][x]-count*spreadQuantity; // 남아 있는 미세 먼지양
                }
            }
        }
        map = dust;

    }

    static void purify(){

        // 위쪽 공기 청정기
        int[] up = machine.get(0);

        // 공기 순환 왼쪽
        for(int y=up[1]-1;y>0;y--){
            map[y][up[0]] = map[y-1][up[0]];
        }

        // 공기 순환 위쪽
        for(int x=0;x<c-1;x++){
            map[0][x] = map[0][x+1];
        }

        // 공기 순환 오른쪽
        for(int y=0;y<up[1];y++)
            map[y][c-1] = map[y+1][c-1];

        // 공기 순환 아랫쪽
        for(int x=c-1;x>1;x--)
            map[up[1]][x] = map[up[1]][x-1];

        map[up[1]][1] = 0; // 공기 정화 0

        // 구분

        // 아래쪽 공기 청정기
        int[] down = machine.get(1);

        // 공기 순환 왼쪽
        for(int y=down[1]+1;y<r-1;y++)
            map[y][0] = map[y+1][0];

        // 공기 순환 아래쪽
        for(int x=0;x<c-1;x++)
            map[r-1][x] = map[r-1][x+1];

        // 공기 순환 오른쪽
        for(int y=r-1;y>down[1];y--)
            map[y][c-1] = map[y-1][c-1];

        // 공기 순환 위쪽
        for(int x=c-1;x>1;x--)
            map[down[1]][x] = map[down[1]][x-1];

        map[down[1]][1] = 0; // 공기 정화 0

    }
}
