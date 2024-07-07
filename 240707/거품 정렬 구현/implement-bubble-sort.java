import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        boolean isSorted = true;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        do{
            isSorted = true;
            for(int i = 0; i < n; i++){
                for(int j = i; j < n-1; j++){
                    if(arr[i] > arr[i+1]){
                        int tmp = arr[i+1];
                        arr[i+1] = arr[i];
                        arr[i] = tmp;
                        isSorted = false;
                    }
                }
            }
        }while(!isSorted);

        for(int i = 0; i < n; i++){
            bw.write(String.valueOf(arr[i]) + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}