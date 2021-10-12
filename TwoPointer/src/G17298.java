//백준 우선순위 큐 Q17298 오큰수 (골드4)
//https://www.acmicpc.net/problem/17298

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G17298 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = start + 1;

        while(end < N){
            //System.out.println("start : " + start +  " end : " + end);
            if(arr[start] < arr[end]){
                sb.append(arr[end]).append(" ");
                start++;
                end = start+1;
            }
            else{
                if(end == N-1){
                    sb.append("-1").append(" ");
                    start++;
                    end = start + 1;
                }
                else end++;
            }

            if(start >= end) break;
        }
        System.out.println(sb.toString() + "-1");
    }
}
