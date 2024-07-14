import java.util.*;
import java.io.*;

public class Main {
    public static int[] sorted;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(arr, 0, n-1);

        for(int i = 0;i<n;i++){
            bw.write(String.valueOf(arr[i] + " "));
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static void merge_sort(int[] arr, int low, int high){
        if(low < high){
            int mid = (low + high) /2;
            merge_sort(arr, low, mid);
            merge_sort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high){
        int[] tmp = new int[arr.length];
        int i = low;
        int j = mid+1;
        int k = low;

        while(i <= mid && j <= high){
            if(arr[i] < arr[j]){
                tmp[k] = arr[i];
                k++;
                i++;
            }else{
                tmp[k] = arr[j];
                k++;
                j++;
            }
        }

        while(i<=mid){
            tmp[k] = arr[i];
            k++;
            i++;
        }
        while(j <= high){
            tmp[k] = arr[j];
            k++;
            j++;
        }

        for(int n = low; n <= high; n++){
            arr[n] = tmp[n];
        }
    }
}