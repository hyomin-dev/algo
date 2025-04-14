package com.multi.algo.day06.c_queue;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P_104 {
    public static void main(String[] args) {
        String[] wait = {"홍길동","김길동","송길동","정길동","박길동","이길동"};

        Queue<String> queue = new LinkedList<>();

        for(int i =0;i<wait.length;i++)
            queue.offer(wait[i]);

        System.out.println(queue);
        queue.poll();//홍길동
        queue.poll();
        queue.offer(queue.poll());
        System.out.println(queue);

        queue.poll();
        queue.offer(queue.poll());
        System.out.println(queue);
        System.out.println(queue.size());

        System.out.println("===================================");

//        String[] arr = new String[queue.size()];
//        for(int i=0;i<arr.length;i++)
//            arr[i] = queue.poll();
//        System.out.println(Arrays.toString(arr));
//        System.out.println("===================================");

        String[] arr2 = queue.toArray(new String[0]);
        System.out.println(Arrays.toString(arr2));


    }
}
