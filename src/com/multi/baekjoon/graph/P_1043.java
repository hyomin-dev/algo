package com.multi.baekjoon.graph;

import java.io.*;
import java.util.*;

public class P_1043 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> party = new ArrayList<>();
        for(int i=0;i<=m;i++) // 0는 초기 진실을 아는 사람들
            party.add(new ArrayList<>());

        st = new StringTokenizer(br.readLine());

        int truthNum = Integer.parseInt(st.nextToken());
        if(truthNum==0){
            for(int i=0;i<m;i++)
                br.readLine();
            bw.write(m+"");
        }else{
            int[] parents = new int[n+1];
            for(int i=1;i<=n;i++) // 자기 자신을 부모로
                parents[i] = i;

            // 진실을 아는 사람들을 모두 같은 루트 노드를 가리키도록
            int last = Integer.parseInt(st.nextToken());
            party.get(0).add(last);
            for(int i=0;i<truthNum-1;i++){
                int next = Integer.parseInt(st.nextToken());
                party.get(0).add(next);
                unionParent(parents,last, next);
                last = next;
            }



            // 파티 정보를 저장하면서 서로소 집합을 만든다.

            for(int i=1;i<=m;i++){
                st = new StringTokenizer(br.readLine());

                int participants = Integer.parseInt(st.nextToken());

                int partiLast = Integer.parseInt(st.nextToken());
                party.get(i).add(partiLast);
                for(int j=1;j<participants;j++){
                    int partiNext = Integer.parseInt(st.nextToken());
                    party.get(i).add(partiNext);
                    unionParent(parents, partiLast, partiNext);
                    partiLast = partiNext;
                }

            }

            // 파티 정보를 다시 불러와서 해당 파티에서 과장되게 말할 수 있으면 카운트
            int count = 0;

            int truthRoot = findParent(parents,party.get(0).get(0)); // 초기에 진실을 아는 사람의 루트 노드를 가져옴

            for(int i=1;i<=m;i++){
                boolean isPossible = true;
                for(int num: party.get(i)){ // i번째 파티에 참여한 사람들
                    if(findParent(parents,num)==truthRoot){
                        isPossible = false;
                        break;
                    }
                }
                if(isPossible)
                    count++;
            }

            bw.write(count+"");

        }

        bw.flush();
        bw.close();
        br.close();

    }

    static int findParent(int[] parents, int x){
        if(x!=parents[x])
            parents[x] = findParent(parents, parents[x]);
        return parents[x];
    }

    static void unionParent(int[] parents,int n1, int n2){

        int n1Root = findParent(parents, n1);
        int n2Root = findParent(parents, n2);

        if(n1Root<n2Root)
            parents[n2Root] = n1Root;
        else if(n1Root > n2Root)
            parents[n1Root] = n2Root;
    }
}

/*

진실을 아는 사람 + 진실을 아는 사람과 같은 파티에 있는 사람 --> 진실을 말해야됨

그외 --> 과장해서 말해도 됨

파티 정보를 통해 서로소 집합을 만든다

파티 정보는 따로 저장한 뒤 서로소 집합을 만들고 활용
* */
