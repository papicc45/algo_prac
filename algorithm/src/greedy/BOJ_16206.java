package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_16206 {
    static int n, m;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        ArrayList<Integer> remain = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        for(int i=0 ; i<n ; i++) {
            if(arr[i] == 10)
                result++;
            else if(arr[i] > 10) {
                if(arr[i] % 10 == 0)
                    cut(arr[i]);
                else
                    remain.add(arr[i]);
            }
        }
        if(m > 0) {
            for(Integer i : remain) {
                cut(i);
            }
        }
        System.out.println(result);
    }
    private static void cut(int length) {
        if(m <= 0)
            return;

        result++;
        m--;
        length -= 10;
        if(length > 10)
            cut(length);
        else if(length == 10) {
            result++;
            return;
        }
    }
}
