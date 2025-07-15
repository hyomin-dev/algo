package com.multi.knowledge.shortest_path_problem;


import java.util.Collections;
import java.util.PriorityQueue;

public class PracPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());

        pq.offer(1);
        pq.offer(6);
        pq.offer(3);
        pq.offer(2);

        System.out.println("PriorityQueue 오름 차순");
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }

        System.out.println("====================================================");
        pq2.offer(1);
        pq2.offer(6);
        pq2.offer(3);
        pq2.offer(2);
        System.out.println("PriorityQueue 내림차순");
        while(!pq2.isEmpty()){
            System.out.println(pq2.poll());
        }


    }
}
