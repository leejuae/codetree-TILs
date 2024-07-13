import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean sorted = true;
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
        }

        do{
            sorted = true;
            for(int i = 0; i < n-1; i++){
                if(arr[i+1] < arr[i]){
                    int tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                    sorted = false;
                }
            }
        }while(!sorted);

        for(int i = 0; i<n; i++){
            bw.write(arr[i]+ " ");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}