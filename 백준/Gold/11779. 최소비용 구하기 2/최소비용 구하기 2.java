import java.io.*;
import java.util.*;

public class Main {

    static int n, m, start, dest;
    static ArrayList<ArrayList<Node11779>> graph = new ArrayList<>();
    static int[] distArray;
    static final int INF = (int)1e9;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        distArray = new int[n+1];
        Arrays.fill(distArray, INF);

        for(int i=0;i<=n;i++)
            graph.add(new ArrayList<>());

        while(m>0){

            StringTokenizer st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken()); // 출발
            int e = Integer.parseInt(st.nextToken()); // 도착
            int c = Integer.parseInt(st.nextToken()); // 비용

            graph.get(s).add(new Node11779(e,c,null));

            m--;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        dest = Integer.parseInt(st.nextToken());

        ArrayList<Integer> record = dijkstra(start);

        bw.write(distArray[dest]+"\n");

        if(record==null){ // 출발지와 도착지가 같은 경우
            bw.write("1\n");
            bw.write(start+"");
        }else{
            bw.write(record.size()+"\n");
            for(int city: record)
                bw.write(city+" ");
        }

        bw.flush();
        bw.close();
        br.close();

    }

    static ArrayList<Integer> dijkstra(int start){
        PriorityQueue<Node11779> pq = new PriorityQueue<>();
        ArrayList<Integer> record = new ArrayList<>();
        record.add(start);
        pq.offer(new Node11779(start, 0, record));
        distArray[start] = 0;

        while(!pq.isEmpty()){
            Node11779 now = pq.poll();

            int nowIndex = now.getIndex();
            int nowCost = now.getCost();

            if(distArray[nowIndex]<nowCost)
                continue;

            if(nowIndex == dest)
                return now.getRecord();

            for(int i=0;i<graph.get(nowIndex).size();i++){
                Node11779 adjcency = graph.get(nowIndex).get(i);
                int cost = nowCost + adjcency.getCost();

                if(distArray[adjcency.getIndex()]>cost){
                    distArray[adjcency.getIndex()] = cost;
                    record = new ArrayList<>();
                    for(int city: now.getRecord()){
                        record.add(city);
                    }
                    record.add(adjcency.getIndex());

                    pq.offer(new Node11779(adjcency.getIndex(),cost, record));
                }

            }
        }

        return null;

    }
}

class Node11779 implements Comparable<Node11779>{
    private int index;
    private int cost;
    private ArrayList<Integer> record;

    public Node11779(int index, int cost, ArrayList<Integer> record){
        this.index = index;
        this.cost = cost;
        this.record = record;
    }

    public int getIndex(){
        return this.index;
    }

    public int getCost(){
        return this.cost;
    }

    public ArrayList<Integer> getRecord(){
        return this.record;
    }

    @Override
    public int compareTo(Node11779 o){
        return this.cost - o.cost;
    }


}
