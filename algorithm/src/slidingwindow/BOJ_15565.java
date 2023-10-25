package slidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=1 ; i<=n ; i++) {
            if(Integer.parseInt(st.nextToken()) == 1)
                list.add(i);
        }

        if(list.size() < k) {
            System.out.println(-1);
            return;
        }
        int result = Integer.MAX_VALUE;
        for(int i=0 ; i+k-1 < list.size() ; i++) {
            int s = list.get(i);
            int e = list.get(i+k-1);
            result = Math.min(result, (e-s) + 1);
        }
        System.out.println(result);
    }
}
