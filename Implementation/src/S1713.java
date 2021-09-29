// 백준 구현 S14756 후보 추천하기 (실버2)
// https://www.acmicpc.net/problem/1713

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S1713 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int recNum = Integer.parseInt(br.readLine());
        Map<Integer, Integer> lhm = new LinkedHashMap<Integer, Integer>();

        //추천 받은 학생번호 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < recNum; i++){
            int tmp = Integer.parseInt(st.nextToken());
            //사진틀보다 작으면 그냥 lhm에 입력
            if(lhm.size() < N){
                lhm.put(tmp, lhm.getOrDefault(tmp, 0) + 1);
            }
            //사진틀이 다 찼다면
            else{
                //사진틀에 이미 있는 학생번호가 추천을 받으면
                if(lhm.containsKey(tmp)) {
                    //추천수 + 1
                    lhm.put(tmp, lhm.get(tmp) + 1);
                }
                //사진틀에 없는 학생번호가 추천을 받으면
                else{
                    //추천수가 제일 작은 학생번호 중, 가장 오래된 것 제거
                    for(Map.Entry<Integer, Integer> m : lhm.entrySet()){
                        if(m.getValue() == Collections.min(lhm.values())){
                            lhm.remove(m.getKey());
                            lhm.put(tmp, 1);
                            break;
                        }
                    }

                }
            }
        }

        //사진틀에 남은 학생번호 정렬하여 출력
        Object[] mapkey = lhm.keySet().toArray();
        Arrays.sort(mapkey);

        for(Object nkey : mapkey){
            System.out.print(nkey +" ");
        }

    }
}
