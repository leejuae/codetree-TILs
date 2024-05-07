import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        lcm(n, m);

        br.close();
    }

    public static void lcm(int n, int m){
        int min = Math.min(n, m);
        for(int i = min; i > 0; i--){
            if(n%i == 0 && m%i == 0){
                System.out.print(i);
                return;
            }
        }
    }
}