package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2262 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        int result = 0;
        while (list.size() != 1) {
            int index = list.indexOf(n);

            if(index == 0) {
                result += Math.abs(list.get(index) - list.get(index+1));
            } else if(index == list.size() - 1) {
                result += Math.abs(list.get(index) - list.get(index-1));
            } else {
                int min = Integer.MAX_VALUE;
                min = Math.min(min, Math.abs(list.get(index) - list.get(index - 1)));
                min = Math.min(min, Math.abs(list.get(index) - list.get(index+1)));
                result += min;
            }

            list.remove(index);
            n--;
        }
        System.out.println(result);
    }
}
