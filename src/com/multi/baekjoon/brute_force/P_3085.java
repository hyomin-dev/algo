package com.multi.baekjoon.brute_force;


import java.io.*;

public class P_3085 {

    public static int maxCount = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String[][] box = new String[n][n];

        for(int i=0;i<n;i++){
            String[] items = br.readLine().split("");
            for(int j=0;j<n;j++)
                box[i][j] = items[j];

        }


        for(int r=0;r<n;r++){
            for(int c=0;c<n;c++){

                if(r==n-1 && c==n-1){
                    // 마지막 행 and 마지막 열인 경우 pass
                    continue;
                } else if(r==n-1){

                    // 마지막 행에서는 아랫쪽과 교환할 필요 없음
                    // 오른쪽 하고만 교환하면 됨
                    swap(box,c,r,c+1,r);
                    findMaxCount(box);
                    //다시 원상 복구
                    swap(box, c+1, r, c,r);
                } else if(c==n-1){
                    //마지막 열에서는 오른쪽과 교환할 필요 없음
                    // 아랫쪽 하고만 교환하면 됨
                    swap(box,c,r,c,r+1);
                    findMaxCount(box);

                    // 다시 원상 복구
                    swap(box,c,r+1,c,r);
                }else{
                    // 오른쪽 교환
                    swap(box,c,r,c+1,r);
                    findMaxCount(box);

                    // 다시 원상 복구
                    swap(box, c+1, r, c,r);
                    // 아랫쪽 교환
                    swap(box,c,r,c,r+1);
                    findMaxCount(box);

                    // 다시 원상 복구
                    swap(box,c,r+1,c,r);
                }

            }
        }

        bw.write(String.valueOf(maxCount));
        bw.flush();
        bw.close();
        br.close();


    }

    public static void swap(String[][] box, int oriX, int oriY, int newX, int newY ){

        String tmp = box[oriY][oriX];
        box[oriY][oriX] = box[newY][newX];
        box[newY][newX] = tmp;

    }

    public static void findMaxCount(String[][] box){

        // 행 검사

        for(int r=0;r<box.length;r++){

            for(int c=0;c<box.length-1;c++){
                int tmp = 1;
               for(int checkC=c+1;checkC< box.length;checkC++){
                   if(box[r][c].equals(box[r][checkC])){
                       tmp++;
                   }
                   else
                       break;
               }
               if(tmp>maxCount)
                   maxCount = tmp;

            }
        }

        // 열 검사

        for(int c=0;c<box.length;c++){

            for(int r=0;r<box.length-1;r++){
                int tmp = 1;
                for(int checkR=r+1;checkR< box.length;checkR++){
                    if(box[r][c].equals(box[checkR][c])){
                        tmp++;
                    }
                    else
                        break;
                }
                if(tmp>maxCount)
                    maxCount = tmp;
            }
        }
    }


}

/*
* 중복을 고려해서
* 현재 위치 기준으로 오른쪽 또는 아래쪽만 바꿔보면 됨
*
* */