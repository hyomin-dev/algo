package com.multi.algo.day06.c_queue;

import java.util.Iterator;
import java.util.LinkedList;

public class A_Queue {
    public static void main(String[] args) {
        //Queue<String> queue = new LinkedList<>(); // q가 더 상위, 하위 LinkedList 에서 더 제공되는 메서드가 많아서 LinkedList 로 받아주는것이 좋다
        LinkedList<String> queue = new LinkedList<>();

        queue.add("추가1");
        queue.add("추가2");
        System.out.println(queue);
        System.out.println(queue.peek()); //peek 메소드로 큐의 맨 앞에 있는 요소를 조회하지만 제거는안함
        System.out.println(queue.isEmpty());
        System.out.println(queue.get(0));
        //queue.remove();
        queue.add(queue.remove());
        System.out.println(queue);
        System.out.println(queue.peek());
        for (String x : queue) {
            System.out.println(x);
        }
        for (int i = 0; i < queue.size(); i++) {
            System.out.println(queue.get(i));
        }
        Iterator<String> iter = queue.iterator();
        for (int i = 0; i < queue.size(); i++) {
            if(iter.hasNext()) {
                System.out.println(iter.next());
            }
        }
    }
}
