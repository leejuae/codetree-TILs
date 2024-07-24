import java.util.*;
import java.io.*;

class Edge{
    int x, y, weight;
    public Edge(int x, int y, int weight){
        this.x = x;
        this.y = y;
        this.weight = weight;
    }
};

class Node{
    int dist, index;
    public Node(int dist, int index){
        this.dist = dist;
        this.index = index;
    }
};

class Element implements Comparable<Element>{
    int dist, index;

    public Element(int dist, int index){
        this.dist = dist;
        this.index = index;
    }

    @Override
    public int compareTo(Element e){
        return this.dist - e.dist;
    }
};

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] dist = new int[n+1];
        ArrayList<Node>[] graph = new ArrayList[n+1];
        PriorityQueue<Element> pq = new PriorityQueue<>();

        int k = Integer.parseInt(br.readLine());

        Edge[] edges = new Edge[m+1];
        edges[0] = new Edge(-1, -1, -1);
        for(int i = 1 ; i <= m; i++){
            st = new StringTokenizer(br.readLine());
            edges[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for(int i = 1 ; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 1; i <= m; i++) {
            int x = edges[i].x;
            int y = edges[i].y;
            int weight = edges[i].weight;
            graph[x].add(new Node(weight, y));
            graph[y].add(new Node(weight, x));
        }

        for(int i = 1 ; i <= n; i++){
            dist[i] = (int)1e9;
        }

        dist[k] = 0;

        pq.add(new Element(0, k));

        while(!pq.isEmpty()){
            int minIndex = pq.peek().index;
            int minDist = pq.peek().dist;
            pq.poll();

            // 이미 최솟값으로 초기화된 상태
            if(minDist != dist[minIndex])
                continue;

            for(int i = 0; i < graph[minIndex].size() ; i++){
                int targetIndex = graph[minIndex].get(i).index;
                int targetDist = graph[minIndex].get(i).dist;

                int newDist = targetDist + dist[minIndex];
                if(dist[targetIndex] > newDist){
                    dist[targetIndex] = newDist;
                    pq.add(new Element(newDist, targetIndex));
                }
            }
        }

        for(int i = 1 ; i <= n; i++){
            if(dist[i] == (int)1e9){
                bw.write("-1\n");
            } else {
                bw.write(String.valueOf(dist[i]) + "\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}