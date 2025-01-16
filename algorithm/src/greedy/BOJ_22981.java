package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_22981 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        ArrayList<Long> boxes = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++) {
            boxes.add(Long.parseLong(st.nextToken()));
        }

        Collections.sort(boxes);
        long max = 0;
        for(int i=0 ; i<n-1 ; i++) {
            long left = boxes.get(0) * (i + 1);
            long right = boxes.get(i+1) * (n - i -1);
            max = Math.max(max, left + right);
        }

        long result = k / max;
        if(k % max == 0) {
            System.out.println(result);
        } else {
            result++;
            System.out.println(result);
        }
    }
}
