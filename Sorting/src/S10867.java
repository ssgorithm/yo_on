//백준 정렬 Q10867 중복 빼고 정렬하기 (실버5)
//https://www.acmicpc.net/problem/10867

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class S10867 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        TreeSet ts = new TreeSet();

        for(int i = 0; i < N; i++){
            ts.add(Integer.parseInt(st.nextToken()));
        }

        for(Object i : ts){
            System.out.print(i + " ");
        }
    }
}
