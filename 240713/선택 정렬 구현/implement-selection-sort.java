import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        boolean isSorted = true;
        int idx = 0;
        int min = 0;

        for(int i = 0 ; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int j = 0; j < n; j++){
            min = arr[j];

            for(int i = j+1; i<n-1; i++){
                if(arr[i] < min){
                    min = arr[i];
                    idx = i;
                }
            }

            if(min != arr[j]){
                int tmp = arr[j];
                arr[j] = min;
                arr[idx] = tmp;
            }
            
        }

        for(int i = 0; i < n; i++){
            bw.write(String.valueOf(arr[i]) + " ");
        }

        bw.flush();
        bw.close();
        br.close();
        
    }
}