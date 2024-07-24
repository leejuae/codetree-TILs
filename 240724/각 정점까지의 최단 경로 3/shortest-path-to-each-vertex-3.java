// class Edge{
//     int x, y, weight;
//     public Edge(int x, int y, int weight){
//         this.x = x;
//         this.y = y;
//         this.weight = weight;
//     }
// }
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n+1][n+1];
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];

        for(int i = 0; i <= n; i++){
            dist[i] = (int)1e9;
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[x][y] = weight;
        }

        dist[1] = 0;

        for(int i = 1; i <= n; i++){
            int minIndex = -1;
            for(int j = 1; j <= n; j++){
                if(visited[j]) continue;
                if(minIndex == -1 || dist[minIndex] > dist[j]){
                    minIndex = j;
                }
            }
            visited[minIndex] = true;

            for(int j = 1; j <= n; j++) {
                // 간선이 존재하지 않는 경우에는 넘어갑니다.
                if(graph[minIndex][j] == 0)
                    continue;

                dist[j] = Math.min(dist[j], dist[minIndex] + graph[minIndex][j]);
            }
        }

        for(int i = 2; i <= n; i++)
            if(dist[i] == (int)1e9){
                bw.write("\n");
            }else{
                bw.write(String.valueOf(dist[i])+ "-1\n");
            }

        bw.flush();
        bw.close();
        br.close();
    }
}