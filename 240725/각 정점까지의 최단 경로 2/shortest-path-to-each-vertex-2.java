import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dist = new int[n+1][n+1];

        for(int i = 0 ; i <= n; i++){
            for(int j = 0 ; j <= n; j++){
                dist[i][j] = (int)1e9;
            }
            dist[i][i] = 0;
        }

        for(int i = 1 ; i <= m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if(dist[x][y]>weight)
                dist[x][y] = weight;
        }

        for(int k = 1 ; k <= n; k++){
            for(int i = 1 ; i <= n; i++){
                for(int j = 1 ; j <= n; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(dist[i][j] == (int)1e9){
                    System.out.print("-1 ");
                }else{
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }

        br.close();
    }
}