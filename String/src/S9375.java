//백준 문자열 Q9375 패션왕 신해빈 (실버3)
//https://www.acmicpc.net/problem/9375

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class S9375 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;
    //테스트 케이스, 옷 개수 변수
    public static int tc, cnum;

    public static void main(String args[]) throws IOException {
        sb = new StringBuilder();

        //테스트 케이스 입력받기
        tc = Integer.parseInt(br.readLine());
        //테스트 케이스만큼 반복
        for(int i = 0; i < tc; i++){
            //가능한 개수
            int result = 1;
            HashMap<String, Integer> hashmap = new HashMap<>();
            cnum = Integer.parseInt(br.readLine());
            for(int c = 0; c < cnum; c++){
                st = new StringTokenizer(br.readLine());
                String type = st.nextToken();
                String clothes = st.nextToken();

                if(hashmap.containsKey(clothes)) hashmap.put(clothes, hashmap.get(clothes) + 1);
                else hashmap.put(clothes, 1);
            }

            Iterator<String> keys = hashmap.keySet().iterator();
            while(keys.hasNext()){
                String key = keys.next();
                result *= (hashmap.get(key) + 1);
            }
            //각각의 개수 + 1해서 곱한 후 1 빼주기
            sb.append(result-1).append('\n');
        }
        System.out.print(sb.toString());
    }
}
