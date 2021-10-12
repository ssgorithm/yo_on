//백준 우선순위 큐 Q1655 가운데를 말해요 (골드2)
//https://www.acmicpc.net/problem/1655

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class G1655 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //작은값이 우선인 minHeap
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((o1,o2) -> o1 - o2);
        //큰값이 우선인 maxHeap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());

            //최소힙, 최대힙 개수가 같다면 maxHeap에 추가
            if(minHeap.size() == maxHeap.size()) maxHeap.offer(num);
            //다르다면 minHeap에 추가
            else minHeap.offer(num);

            if(!minHeap.isEmpty() && !maxHeap.isEmpty()){
                //최소힙의 루트보다 최대힙의 루트가 크다면 둘의 값을 바꿈
                if(minHeap.peek() < maxHeap.peek()){
                    int tmp = minHeap.poll();
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(tmp);
                }
            }
            sb.append(maxHeap.peek()).append("\n");
        }
        System.out.print(sb.toString());
    }
}
