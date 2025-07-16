import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[][] graph;
    public static void main(String[] args) throws IOException {

        final int INF = (int)1e9;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n+1][n+1];

        for(int i=1;i<=n;i++)
            Arrays.fill(graph[i], INF);

        for(int i=1;i<=n;i++)
            graph[i][i] = 0;

        while(m>0){
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph[node1][node2] = 1;
            graph[node2][node1] = 1;

            m--;
        }

        for(int k=1;k<=n;k++){
            for(int y=1;y<=n;y++){
                for(int x=1;x<=n;x++){
                    graph[y][x] = Math.min(graph[y][x],graph[y][k]+graph[k][x]);
                }
            }
        }

        ArrayList<Node1389> relations = new ArrayList<>();

        for(int y=1;y<=n;y++){
            int count = 0;
            for(int x=1;x<=n;x++){
                if(graph[y][x]!=INF)
                    count+=graph[y][x];
            }

            relations.add(new Node1389(y,count));

        }

        Collections.sort(relations);

        bw.write(String.valueOf(relations.get(0).getIndex()));
        bw.flush();
        bw.close();
        br.close();

    }

}

class Node1389 implements Comparable<Node1389>{
    private int index;
    private int count;

    public Node1389(int index, int count){
        this.index = index;
        this.count = count;
    }

    int getIndex(){
        return this.index;
    }

    int getCount(){
        return this.count;
    }

    @Override
    public int compareTo(Node1389 o){
        if(this.count!=o.getCount())
            return this.count - o.getCount();

        if(this.index==o.getIndex()){
            return this.index - o.getIndex();
        }

        return 0;
    }
}