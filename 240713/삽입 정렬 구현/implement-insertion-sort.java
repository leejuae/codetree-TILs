import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken()); 
        }

        for(int i = 1; i < n; i++){
            int j = i-1;
            int key = arr[i];
            while(j>=0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }

        for(int i = 0; i < n; i++){
            bw.write(String.valueOf(arr[i]) + " ");
        }
        

        br.close();
        bw.flush();
        bw.close();
    }
}