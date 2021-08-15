//백준 해시맵 Q1764 듣보잡 (실버4)
// https://www.acmicpc.net/problem/1764

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class S1764 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<String> dbj = new ArrayList<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //듣지 못한 사람 hashset에 넣기
        HashSet<String> hs = new HashSet<>();
        for(int i = 0; i < N; i++){
            String name = br.readLine();
            hs.add(name);
        }

        //듣지 못한 사람 명단에 있으면 듣보잡에 추가
        for(int i = 0; i < M; i++){
            String name = br.readLine();
            if(hs.contains(name)){
                dbj.add(name);
            }
        }

        //정렬
        Collections.sort(dbj);

        System.out.println(dbj.size());
        for(String name : dbj){
            System.out.println(name);
        }
    }
}
