package com.multi.baekjoon.binary_search_tree;


import java.io.*;

public class P_5639 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String str;
        Node5639 head = null;
        while((str=br.readLine())!=null&&!str.equals("")){

            int value = Integer.parseInt(str);
            if(head==null){
                head = new Node5639(value);
            }else{
                insertNode(head, value);
            }
        }

        postOrder(head);

        bw.flush();
        bw.close();
        br.close();
    }

    static void insertNode(Node5639 now, int value){

        if(value<=now.value){
            if(now.left==null)
                now.left = new Node5639(value);
            else
                insertNode(now.left,value);
        }else{
            if(now.right==null)
                now.right = new Node5639(value);
            else
                insertNode(now.right,value);
        }
    }

    static void postOrder(Node5639 now) throws IOException{

        if(now.left!=null)
            postOrder(now.left);
        if(now.right!=null)
            postOrder(now.right);
        bw.write(now.value+"\n");

    }

}

class Node5639{
    int value;
    Node5639 left;
    Node5639 right;

    public Node5639(int value){
        this.value = value;

    }
}
