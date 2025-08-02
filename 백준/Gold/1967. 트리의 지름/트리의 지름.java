import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int maxRadius = Integer.MIN_VALUE;
    static int maxNode = 0;
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        for(int i=0;i<=n;i++)
            graph.add(new ArrayList<>());

        for(int i=0;i<n-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(node1).add(new int[]{node2, weight});
            graph.get(node2).add(new int[]{node1, weight});

        }
        
        //임의의 노드
        visited = new boolean[n+1];
        visited[1] = true;
        dfs(0,1);
        
        // 트리의 정점 중 하나
        visited = new boolean[n+1];
        visited[maxNode] = true;
        maxRadius = Integer.MIN_VALUE;
        dfs(0,maxNode);

        bw.write(maxRadius+"");

        bw.flush();
        bw.close();
        br.close();

    }

    static void dfs(int sum,int node){
        if(sum>maxRadius) {
            maxRadius = sum;
            maxNode = node;
        }

        for(int i=0;i<graph.get(node).size();i++){
            int[] adjcencyNode = graph.get(node).get(i);
            if(!visited[adjcencyNode[0]]){
                visited[adjcencyNode[0]] = true;
                dfs(sum+adjcencyNode[1],adjcencyNode[0]); // adjcencyNode[0]를 방문했을 때 추가 되는 지름
            }
        }

    }
}
/*
임의의 점에서 가장 먼 거리: 트리의 정점 2개 중 하나

트리의 정점에서 가장 먼 거리: 다른 트리의 정점 --> 이것이 트리의 지름

* */
