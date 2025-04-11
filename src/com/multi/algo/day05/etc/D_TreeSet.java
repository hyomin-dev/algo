package com.multi.algo.day05.etc;


import java.util.Collections;
import java.util.TreeSet;

public class D_TreeSet {
    public static void main(String[] args) {
        TreeSet<Integer> tree = new TreeSet<>();

        tree.add(4);
        tree.add(5);
        tree.add(1);
        tree.add(2);
        tree.add(4);
        tree.add(3);

        System.out.println(tree);

        System.out.println(tree.last());

        Integer[] iArr = tree.toArray(new Integer[0]);
        System.out.println(iArr[iArr.length-1]);


        //내림 차순
        TreeSet<Integer> tree2 = new TreeSet<>(Collections.reverseOrder());

        tree2.add(4);
        tree2.add(5);
        tree2.add(1);
        tree2.add(2);
        tree2.add(4);
        tree2.add(3);
        System.out.println(tree2.last());

    }
}
