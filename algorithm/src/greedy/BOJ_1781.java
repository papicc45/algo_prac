package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1781 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0 ; i<=n ; i++) {
            list.add(new ArrayList<>());
        }

        for(int i=0 ; i<n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int deadline = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            list.get(deadline).add(count);
        }

        for(int i=1;  i<=n ; i++) {
            Collections.sort(list.get(i), Collections.reverseOrder());
        }

        long result = 0;
        for(int i=1 ; i<=n ; i++) {
            int index = 0;
            int max = Integer.MIN_VALUE;
            for(int j=i ; j<=n ; j++) {
                if(list.get(j).size() != 0) {
                    if(max < list.get(j).get(0)) {
                        index = j;
                        max = list.get(j).get(0);
                    }
                }
            }
            if(index != 0) {
                result += max;
                list.get(index).remove(0);
            }
        }

        System.out.println(result);
    }
}

class Ramen {
    int deadline;
    int cnt;

    public Ramen(int deadline, int cnt) {
        this.deadline = deadline;
        this.cnt = cnt;
    }
}
