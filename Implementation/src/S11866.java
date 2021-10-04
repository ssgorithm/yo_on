//백준 구현 Q11866 요세푸스 문제0 (실버4)
//https://www.acmicpc.net/problem/11866

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S11866 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        //숫자 큐에 다 넣기
        for(int i = 1; i <=N; i++){
            q.offer(i);
        }

        sb.append("<");

        //k번째가 아니면 빼서 뒤에 다시 넣기
        while(q.size() > 1){
            for(int i = 0; i < K - 1; i++){
                q.offer(q.poll());
            }
            sb.append(q.poll()).append(", ");
        }
        sb.append(q.poll()).append(">");

        System.out.print(sb.toString());
    }
}
