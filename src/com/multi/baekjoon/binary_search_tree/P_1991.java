package com.multi.baekjoon.binary_search_tree;



import java.io.*;

import java.util.StringTokenizer;

public class P_1991 {
    static int n;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());

        Node1992 head = new Node1992('A',null,null);

        for(int i=1;i<=n;i++){

            StringTokenizer st = new StringTokenizer(br.readLine());

            char p = st.nextToken().charAt(0);
            char c1 = st.nextToken().charAt(0);
            char c2 = st.nextToken().charAt(0);

            insertNode(head,p,c1,c2);

        }

        preOrder(head);
        bw.newLine();
        inOrder(head);
        bw.newLine();
        postOrder(head);

        bw.flush();
        bw.close();
        br.close();

    }

    static void insertNode(Node1992 now, char parent, char left, char right){

        if(now.value==parent){
            now.left = new Node1992(left,null,null);
            now.right = new Node1992(right,null,null);
        }else{
            if(now.left!=null)
                insertNode(now.left,parent,left,right);
            if(now.right!=null)
                insertNode(now.right,parent,left,right);
        }

    }

    static void preOrder(Node1992 now) throws IOException{
        // 부모 노드→ 왼쪽 자식 → 오른쪽 자식 노드

        if(now.value!='.')
            bw.write(now.value);
        if(now.left!=null)
            preOrder(now.left);
        if(now.right!=null)
            preOrder(now.right);
    }

    static void inOrder(Node1992 now) throws IOException{
        // 왼쪽 자식 노드 → 부모 노드 → 오른쪽 자식 노드

        if(now.left!=null)
            inOrder(now.left);
        if(now.value!='.')
            bw.write(now.value);
        if(now.right!=null)
            inOrder(now.right);

    }

    static void postOrder(Node1992 now) throws IOException{
        // 왼쪽 자식 노드 → 오른쪽 자식 노드 → 부모 노드

        if(now.left!=null)
            postOrder(now.left);

        if(now.right!=null)
            postOrder(now.right);

        if(now.value!='.')
            bw.write(now.value);

    }
}

class Node1992{
    char value;
    Node1992 left;
    Node1992 right;

    public Node1992(char value,Node1992 left, Node1992 right){
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
