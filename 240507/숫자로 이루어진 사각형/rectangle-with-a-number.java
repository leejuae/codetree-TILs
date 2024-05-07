import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        square(n);
    }

    public static void square(int n){
        int cnt = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(cnt == 10) cnt = 1;
                System.out.print(cnt+" ");
                cnt++;
            }
            System.out.println();
        }
    }
}