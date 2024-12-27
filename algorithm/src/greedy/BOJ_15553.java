package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_15553 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int e = arr[0] + 1;
        int count = 1;

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1 ; i<n ; i++) {
            if(e != arr[i]) {
                count++;
                list.add(arr[i] - e);
                e = arr[i] + 1;
            } else {
                e = arr[i] + 1;
            }
        }
        Collections.sort(list);

        if(k < count) {
            for(int i=0 ; i<count-k ; i++) {
                n += list.get(i);
            }
        }
        System.out.println(n);
    }
}
