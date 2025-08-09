package com.multi.baekjoon.data_structure;

import java.io.*;
import java.util.*;

public class P_1918 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        /*
        * (: stack에 넣는다
        * ): (를 만날 때 까지 stack에서 pop해서 queue에 넣는다.
        * 연산자: stack의 최상단과 연산자의 우선순위가 같거나 낮다면 --> stack이 비거나 stack의 최상단이 연산자보다 우선순위가 낮을 때까지, stack의 최상단이 '('일때까지 stack에서 꺼내서 queue에 넣는다.
        * */


        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);

            if('A'<=c&&c<='Z')
                queue.offer(c);
            else{
                if(stack.isEmpty()){
                    stack.push(c);
                }else if(c=='(')
                    stack.push(c);
                else if(c==')'){
                    while(stack.peek()!='(')
                        queue.offer(stack.pop());
                    stack.pop(); // '('를 스택에서 제거
                }else if(c=='+'||c=='-'){
                    // 스택이 비거나, stack 상단이 '('
                    while(!stack.isEmpty()){
                        if(stack.peek()=='(')
                            break;
                        queue.offer(stack.pop());
                    }
                    stack.push(c);
                }else if(c=='*'||c=='/'){
                    while(!stack.isEmpty()){
                        if(stack.peek()=='(')
                            break;
                        else if(stack.peek()=='+'||stack.peek()=='-')
                            break;
                        queue.offer(stack.pop());
                    }
                    stack.push(c);
                }
            }
        }

        while(!stack.isEmpty()){
            queue.offer(stack.pop());
        }

        while(!queue.isEmpty())
            bw.write(queue.poll()+"");

        bw.flush();
        bw.close();
        br.close();

    }
}
