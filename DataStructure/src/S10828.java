//백준 스택 Q10828 스택 (실버4)
////https://www.acmicpc.net/problem/10828

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S10828 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> stack = new ArrayList<Integer>();
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        for(int i = 0; i <  N; i++){
            st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();

            if(tmp.equals("push")){
                stack.add(0, Integer.parseInt(st.nextToken()));
            }else{
                if(tmp.equals("size")) sb.append(stack.size()).append("\n");
                else if(tmp.equals("top")) {
                    sb.append(stack.size() == 0 ? -1 : stack.get(0)).append("\n");
                }
                else if(tmp.equals("empty")) sb.append(stack.size() == 0 ? 1 : 0).append("\n");
                else{
                    sb.append(stack.size() == 0 ? -1 : stack.get(0)).append("\n");
                    if(stack.size() != 0) stack.remove(0);
                }
            }
        }
        System.out.print(sb.toString());
    }
}
