import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] parent;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        parent = new int[n+1];
        visited = new boolean[n+1];

        for(int i=0;i<=n;i++)
            graph.add(new ArrayList<>());

        for(int i=1;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        bfs(1);

        for(int i=2;i<=n;i++)
            bw.write(parent[i]+"\n");

        bw.flush();
        bw.close();
        br.close();

    }

    static void bfs(int start){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();

            for(int i=0;i<graph.get(node).size();i++){
                int adjcencyNode = graph.get(node).get(i);

                if(!visited[adjcencyNode]){
                    visited[adjcencyNode] = true;
                    parent[adjcencyNode] = node; // adjcencyNode의 부모는 node
                    queue.offer(adjcencyNode);
                }
            }
        }
    }
}
