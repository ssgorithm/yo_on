//백준 해시맵 Q4358 생태학 (골드5)
// https://www.acmicpc.net/problem/4358

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class G4358 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        HashMap<String, Integer> map = new HashMap<>();
        int index = 0;

        //계속 입력받기
        while(true) {
            input = br.readLine();
            //입력끝이면 종료
            if(input == null || input.equals("")) break;
            //같은이름이면 + 1
            map.put(input, map.getOrDefault(input, 0) + 1);
            index++;
        }

        //map 정렬
        Object[] mapkey = map.keySet().toArray();
        Arrays.sort(mapkey);

        //소수점 4자리 까지 구해서 key와 value 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < mapkey.length; i++) {
            int value = map.get(mapkey[i]);
            double percent = ((double)value /(double) index) * 100;
            sb.append(mapkey[i] + " " + String.format("%.4f", percent)).append("\n");
        }
        System.out.println(sb.toString());

    }
}
