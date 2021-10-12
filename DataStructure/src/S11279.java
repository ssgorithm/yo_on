//백준 우선순위 큐 Q11279 최대 힙 (실버2)
//https://www.acmicpc.net/problem/11279

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class S11279 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < N; i++){
            int temp = Integer.parseInt(br.readLine());
            if(temp == 0){
                if(pq.size() == 0) sb.append('0').append('\n');
                else sb.append(pq.poll()).append('\n');
            }else{
                pq.offer(temp);
            }
        }

        System.out.print(sb.toString());
    }
}
