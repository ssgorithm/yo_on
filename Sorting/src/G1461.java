//백준 정렬 Q1461 도서관 (골드 5)
//https://www.acmicpc.net/problem/1461

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G1461 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //음수와 양수 우선순위 큐를 만듦
        PriorityQueue<Integer> pos = new PriorityQueue<>((p1, p2) -> p2 - p1);
        PriorityQueue<Integer> neg = new PriorityQueue<>((p1, p2) -> p2 - p1);

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int tmp = Integer.parseInt(st.nextToken());
            if(tmp > 0) pos.offer(tmp);
            else neg.offer(Math.abs(tmp));
        }

        //가장 큰 값 구하기
        //가장 큰 수일 떄 0으로 돌아오지 않고 끝나는게 최소 거리이기 떄문
        int max = 0;
        if(pos.isEmpty()) max = neg.peek();
        else if(neg.isEmpty()) max = pos.peek();
        else max = Math.max(pos.peek(), neg.peek());

        int num = 0;

        while(!pos.isEmpty()){
            int tmp = pos.poll();
            for(int i = 0; i < M-1; i++){
                pos.poll();
                if(pos.isEmpty()) break;
            }
            num += tmp * 2;
        }

        while(!neg.isEmpty()){
            int tmp = neg.poll();
            for(int i = 0; i < M-1; i++){
                neg.poll();
                if(neg.isEmpty()) break;
            }
            num += tmp * 2;
        }
        num -= max;
        System.out.print(num);
    }
}
