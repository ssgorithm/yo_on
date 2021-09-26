//백준 정렬 Q2822 점수계산 (실버5)
//https://www.acmicpc.net/problem/2822

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S2822 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i = 0; i < 8; i++){
            hm.put(i+1, Integer.parseInt(br.readLine()));
        }

        List<Integer> keySetList = new ArrayList<>(hm.keySet());
        Collections.sort(keySetList, (o1, o2) -> (hm.get(o2).compareTo(hm.get(o1))));

        int sum = 0;
        int index = 0;
        int[] k = new int[5];
        for(Integer key : keySetList){
            index++;
            sum += hm.get(key);
            k[index-1] = key;
            if(index == 5) break;
        }

        Arrays.sort(k);

        System.out.println(sum);
        for(int i : k){
            System.out.print(i + " ");
        }
    }
}
