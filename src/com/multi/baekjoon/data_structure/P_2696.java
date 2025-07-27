package com.multi.baekjoon.data_structure;

import java.io.*;
import java.util.*;

public class P_2696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while(t>0){


            // 중앙값보다 작거나 같으면 왼쪽 --> 최대힙
            // 중앙값보다 크면 오른쪽 --> 최소 힙
            // 최대힙과 최소 힙 다르면 중앙 값 갱신

            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

            int m = Integer.parseInt(br.readLine());
            int q = 0;
            if(m%10==0){
                q = m/10;
            }else{
                q = m/10 +1;
            }

            int idx = 1;
            int midCount = 1;

            bw.write((m+1)/2+"\n");
            int mid = 0;
            for(int i=0;i<q;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                while(st.hasMoreTokens()){
                    int num = Integer.parseInt(st.nextToken());

                    if(minHeap.isEmpty()&&maxHeap.isEmpty()) { // 처음 값이 아무것도 없을 때
                        mid = num;
                        maxHeap.offer(mid);
                        bw.write(mid+" ");
                    } else if(num<=mid){
                        maxHeap.offer(num);
                    }else { //
                        minHeap.offer(num);
                    }

                    if(idx!=1&&idx%2!=0){
                        //최대 힙이 최소 힙보다 1개 적도록
                        while(true){
                            if(maxHeap.size()+1==minHeap.size()){
                                mid = minHeap.peek();
                                midCount++;
                                bw.write(mid+" ");
                                if(midCount%10==0)// 10번 중앙값을 출력하고 다음줄을 시작하는 경우
                                    bw.newLine();
                                break;
                            }

                            //최대 힙이 더 많은 경우
                            if(maxHeap.size()>minHeap.size()){
                                int tmp = maxHeap.poll();
                                minHeap.offer(tmp);
                            }else{
                                int tmp = minHeap.poll();
                                maxHeap.offer(tmp);
                            }
                        }
                    }
                    idx++;

                }
            }
            if(midCount%10!=0)
                bw.newLine();

            t--;
        }

        bw.flush();
        bw.close();
        br.close();

    }
}

