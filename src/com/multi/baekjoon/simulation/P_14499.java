package com.multi.baekjoon.simulation;


import java.io.*;
import java.util.StringTokenizer;

public class P_14499 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dice = new int[6]; // 0: 위쪽, 1: 북쪽, 2: 동쪽, 3: 서쪽, 4: 남쪽, 5: 아래쪽

        // 1<= n, m <= 20
        int n = Integer.parseInt(st.nextToken()); // 세로 크기
        int m = Integer.parseInt(st.nextToken()); // 가로 크기


        // 기존에 알던 x와 y가 바뀜
        int x = Integer.parseInt(st.nextToken()); // 0 <= x <= n-1
        int y = Integer.parseInt(st.nextToken()); // 0 <= y <= m-1

        int k = Integer.parseInt(st.nextToken());
        int[] commands = new int[k];

        int[][] map = new int[n][m];

        for(int r=0;r<n;r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0;c<m;c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<k;i++)
            commands[i] = Integer.parseInt(st.nextToken());

        for(int command: commands){
            switch (command){
                case 1:{ // 동쪽 이동
                    if(y+1<m){
                        y = y+1;
                        // 주사위 동쪽으로 이동
                        moveEast(dice);
                        if(map[x][y]==0)
                            map[x][y] = dice[5];
                        else{
                            dice[5] = map[x][y];
                            map[x][y] = 0;
                        }
                        bw.write(String.valueOf(dice[0]));
                        bw.newLine();

                    }
                    break;
                }
                case 2:{ // 서쪽 이동
                    if(y-1>=0){
                        y = y-1;
                        //주사위 동쪽 이동
                        moveWest(dice);
                        if(map[x][y]==0)
                            map[x][y] = dice[5];
                        else{
                            dice[5] = map[x][y];
                            map[x][y] = 0;
                        }

                        bw.write(String.valueOf(dice[0]));
                        bw.newLine();

                    }
                    break;
                }
                case 3:{ // 북쪽 이동
                    if(x-1>=0){
                        x=x-1;

                        // 주사위 북쪽으로 이동
                        moveNorth(dice);
                        if(map[x][y]==0)
                            map[x][y] = dice[5];
                        else{
                            dice[5] = map[x][y];
                            map[x][y] = 0;
                        }
                        bw.write(String.valueOf(dice[0]));
                        bw.newLine();

                    }
                    break;
                }
                case 4:{ // 남쪽 이동
                    if(x+1<n){
                        x = x+1;

                        // 주사위 남쪽으로 이동
                        moveSouth(dice);
                        if(map[x][y]==0)
                            map[x][y] = dice[5];
                        else{
                            dice[5] = map[x][y];
                            map[x][y] = 0;
                        }
                        bw.write(String.valueOf(dice[0]));
                        bw.newLine();

                    }
                    break;
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }

    static void moveEast(int[] dice){

        int tmp = dice[0];
        dice[0] = dice[3];
        dice[3] = dice[5];
        dice[5] = dice[2];
        dice[2] = tmp;

    }

    static void moveWest(int[] dice){
        int tmp = dice[0];
        dice[0] = dice[2];
        dice[2] = dice[5];
        dice[5] = dice[3];
        dice[3] = tmp;
    }

    static void moveNorth(int[] dice){
        int tmp = dice[0];
        dice[0] = dice[1];
        dice[1] = dice[5];
        dice[5] = dice[4];
        dice[4] = tmp;
    }

    static void moveSouth(int[] dice){
        int tmp = dice[0];
        dice[0] = dice[4];
        dice[4] = dice[5];
        dice[5] = dice[1];
        dice[1] = tmp;
    }
}

/*
r: y좌표
c: x좌표

초기 주사위
전개도:
  2
4 1 3
  5
  6
위치: 1 2 3 4 5 6
값:   a b c d e f

동쪽 이동
전개도:
  2
6 4 1
  5
  3
위치: 1 2 3 4 5 6
값:   d b a f e c

서쪽 이동
전개도:
  2
1 3 6
  5
  4
위치: 1 2 3 4 5 6
값:   c b f a e d

남쪽 이동
전개도:
  6
4 2 3
  1
  5
위치: 1 2 3 4 5 6
값:   b f c d a e

북쪽 이동
전개도:
  1
4 5 3
  6
  2
위치: 1 2 3 4 5 6
값:   e a c d f b

*
* */