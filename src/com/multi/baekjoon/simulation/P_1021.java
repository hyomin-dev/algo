package com.multi.baekjoon.simulation;


import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P_1021 {
    static Deque<Integer> deque;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        deque = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int count=0;
        int n = Integer.parseInt(st.nextToken()); // 큐의 크기, 1 <= n <= 50
        int m = Integer.parseInt(st.nextToken()); // 뽑아내려고 하는 수의 개수, 1 <= m <= n

        for(int i=0;i<n;i++)
            deque.offerLast(i);

        int[] searchArray = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++)
            searchArray[i] = Integer.parseInt(st.nextToken())-1;

        /*
        * deque 크기 짝수:
        * 1번 상황: 크기/2 -1 >= 찾는 숫자 인덱스 ===> 2번 연산을 찾는 숫자 인덱스만큼
        * 2번 상황: 크기/2 -1 < 찾는 숫자 인덱스 ===> 3번 연산을 (deque 크기 - 찾는 숫자 인덱스)만큼
        *
        * deque 크기 홀수:
        * 3번 상황: (크기-1)/2 >= 찾는 숫자 인덱스 ===> 2번 연산을 찾는 숫자 인덱스만큼
        * 4번 상황: (크기-1)/2 < 찾는 숫자 인덱스 ===> 3번 연산을 (deque 크기-찾는 숫자 인덱스)만큼
        *
        * */

        for(int num: searchArray){
            int idx = findElement(num); //찾는 숫자 인덱스
            int dequeSize = deque.size();
            if(dequeSize%2==0){
                if(dequeSize/2-1>=idx){ // 1번 상황
                    operation2(idx);
                    count+=idx;
                }else{ // 2번 상황
                    operation3(dequeSize-idx);
                    count += dequeSize-idx;
                }

            }else{
                if((dequeSize-1)/2>=idx) {
                    operation2(idx);
                    count +=idx;
                }
                else{
                    operation3(dequeSize-idx);
                    count +=dequeSize-idx;
                }
            }
            deque.pollFirst();

        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();

    }

    static int findElement(int num){

        /*
        * 숫자 num에 해당하는 index 반환
        * */

        int idx=0;
        for(int ele: deque){
            if(ele==num)
                return idx;
            idx++;
        }
        return -1;
    }

    static void operation2(int iter){

        /*
        * 2번 연산
        * */

        for(int i=0;i<iter;i++){
            if(!deque.isEmpty()) {
                int num = deque.pollFirst();
                deque.offerLast(num);
            }
        }
    }

    static void operation3(int iter){

        /*
        * 3번 연산
        * */

        for(int i=0;i<iter;i++){
            if(!deque.isEmpty()){
                int num = deque.pollLast();
                deque.offerFirst(num);
            }
        }
    }
}
