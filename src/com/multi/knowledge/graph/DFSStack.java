package com.multi.knowledge.graph;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFSStack {

    public static boolean[] visited = new boolean[9];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) {
        for(int i=0;i<9;i++)
            graph.add(new ArrayList<Integer>());

        // 1번 노드에 인접한 노드들
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);

        // 2번 노드에 인접한 노드들
        graph.get(2).add(1);
        graph.get(2).add(7);

        //3번 노드에 인접한 노드들
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);

        //4번 노드에 인접한 노드들
        graph.get(4).add(3);
        graph.get(4).add(5);

        //5번 노드에 인접한 노드들
        graph.get(5).add(3);
        graph.get(5).add(4);

        //6번 노드에 인접한 노드들
        graph.get(6).add(7);

        //7번 노드에 인접한 노드들
        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);

        //8번 노드에 인접한 노드들
        graph.get(8).add(1);
        graph.get(8).add(7);

        dfs(1);

    }

    static void dfs(int node){
        Stack<Integer> stack = new Stack<>();
        stack.push(node);

        while(!stack.isEmpty()){

            int visitedNode = stack.pop();
            if(!visited[visitedNode]){
                // 방문했을 때, 방문 처리
                visited[visitedNode] = true;
                System.out.println(visitedNode);
                for(int i=graph.get(visitedNode).size()-1;i>=0;i--){
                    int adjacentNode = graph.get(visitedNode).get(i);
                    if(!visited[adjacentNode])
                        stack.push(adjacentNode);
                }
            }
        }
    }
}
