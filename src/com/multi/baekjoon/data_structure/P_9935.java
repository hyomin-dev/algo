package com.multi.baekjoon.data_structure;

import java.io.*;
import java.util.*;

public class P_9935 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String bomb = br.readLine();

        Stack<Character> stack = new Stack<>();
        for(int i=0;i<str.length();i++){
            stack.push(str.charAt(i));

            if(stack.peek()==bomb.charAt(bomb.length()-1)){
                Stack<Character> tmp = new Stack<>(); //탐색할 문자들을 담아놓는 스택, 임시 폭탄 저장소
                if(!stack.isEmpty())
                    tmp.push(stack.pop()); //임시 폭탄 저장소에 문자 저장
                boolean isBomb = true;

                for(int j=bomb.length()-2;j>=0;j--){ // 폭탄의 마지막 문자는 검사했으니 그 다음 마지막 문자부터 검사
                    if(stack.isEmpty()) { // 폭탄 검사 전부하기 전에 비었으니, 폭탄이 아님
                        isBomb = false;
                        break;
                    }
                    if(stack.peek()==bomb.charAt(j))
                        tmp.push(stack.pop());
                    else{ // 탐색하다가 폭탄의 문자와 다르다면 다시 스택에 넣는다.
                        isBomb = false;
                        break;
                    }
                }

                if(!isBomb) {
                    while (!tmp.isEmpty())
                        stack.push(tmp.pop());
                }

            }
        }

        if(stack.isEmpty())
            bw.write("FRULA");
        else{
            ArrayList<Character> list = new ArrayList<>(stack);
            for(char c: list)
                bw.write(String.valueOf(c));
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
