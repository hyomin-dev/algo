package com.multi.algo.day05.etc;


import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class G_KthNumber_tree {
    public static void main(String[] args) {
        int[] num = {3, 4, 5, 1, 2, 3, 5};

        TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder());
        for(int n : num)
            treeSet.add(n);

        int[] num2 = treeSet.stream().mapToInt(v->v.intValue()).toArray();

        int k = 3;

        System.out.println(num2[k-1]);


    }
}
