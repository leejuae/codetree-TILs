import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> list = new ArrayList<Integer>();
        int n = Integer.parseInt(st.nextToken());

        for(int i= 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("push_back")){
                int val = Integer.parseInt(st.nextToken());
                list.add(val);
                //bw.write(String.valueOf(val));
            }
            else if(command.equals("pop_back")){
                list.remove(list.size()-1);
                //bw.write(String.valueOf(list.remove(list.size()-1)));
            }
            else if(command.equals("size")){
                bw.write(String.valueOf(list.size()));
                bw.write("\n");
            }
            else if(command.equals("get")){
                bw.write(String.valueOf(list.get(Integer.parseInt(st.nextToken()) - 1)));
                bw.write("\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}