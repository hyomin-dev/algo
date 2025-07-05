package com.multi.baekjoon.brute_force;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class P_1759 {
    static boolean[] visited;
    static int l, c;
    static Stack<Character> stack;
    static char[] array;
    static ArrayList<Character> vowelList= new ArrayList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{


        StringTokenizer st = new StringTokenizer(br.readLine());

        // 3 <= l <= c <= 15
        l = Integer.parseInt(st.nextToken()); // 암호 개수
        c = Integer.parseInt(st.nextToken()); // 암호로 가능한 문자 개수

        array = new char[c];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<c;i++) {
            array[i] = st.nextToken().charAt(0);
            if(array[i]=='a' || array[i] == 'e' || array[i] == 'i' || array[i] =='o' || array[i]=='u')
                vowelList.add(array[i]);
        }
        Arrays.sort(array);

        for(int i=0;i<=c-l;i++){
            visited = new boolean[c];
            visited[i] = true;
            stack = new Stack<>();
            stack.push(array[i]);
            dfs(i);
        }

        bw.flush();
        bw.close();
        br.close();
    }
    static void dfs(int node) throws IOException{
        visited[node] = true;
        if(stack.size()==l){
            int countVowel = 0;
            ArrayList<Character> list = new ArrayList<>(stack);
            for(char elem:vowelList){
                if(list.contains(elem))
                    countVowel++;
            }
            if(countVowel>=1 && l-countVowel>=2 ) {
                for (char elem : list) {
                    bw.write(elem);
                }
                bw.newLine();
            }
            return;
        }

        for(int i=node+1;i<c;i++){
            if(!visited[i]){
                stack.push(array[i]);
                dfs(i);
                stack.pop();
                visited[i] = false;
            }
        }
    }
}
/*
* 아스키 코드:
* a: 97
* z: 97+25
* a c i s t w
* */