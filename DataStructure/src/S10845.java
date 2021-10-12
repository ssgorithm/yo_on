//백준 큐 Q10845 큐 (실버4)
//https://www.acmicpc.net/problem/10845

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S10845 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> queue = new ArrayList<Integer>();
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        for(int i = 0; i <  N; i++){
            st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();

            if(tmp.equals("push")){
                queue.add(Integer.parseInt(st.nextToken()));
            }else{
                if(tmp.equals("size")) sb.append(queue.size()).append("\n");
                else if(tmp.equals("front")) {
                    sb.append(queue.size() == 0 ? -1 : queue.get(0)).append("\n");
                }
                else if(tmp.equals("back")){
                    sb.append(queue.size() == 0 ? -1 : queue.get(queue.size()-1)).append("\n");
                }
                else if(tmp.equals("empty")) sb.append(queue.size() == 0 ? 1 : 0).append("\n");
                else{
                    sb.append(queue.size() == 0 ? -1 : queue.get(0)).append("\n");
                    if(queue.size() != 0) queue.remove(0);
                }
            }
        }
        System.out.print(sb.toString());
    }
}
