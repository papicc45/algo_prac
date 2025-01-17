package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_32945 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> maxList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list, Collections.reverseOrder());

        int start = 0;
        int max = Integer.MAX_VALUE;

        int cnt = 0;
        int result = 0;
        for(int next : list) {
            max = Math.min(max, start + next);
            maxList.add(max);
            if(start < max) {
                cnt++;
            } else {
                cnt--;
                maxList.remove(0);
                if(maxList.get(0) > start)
                    cnt++;
            }
            start++;
            result = Math.max(result, cnt);
        }
        System.out.println(result);
    }
}
