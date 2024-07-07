import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n-1; i++){
            int min = i;
            for(int j = i+1; j < n; j++){
                if(arr[min] > arr[j]){
                    min = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }

        for(int i = 0; i < n; i++){
            bw.write(String.valueOf(arr[i]+" "));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}