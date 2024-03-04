package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_18234 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long t = Long.parseLong(st.nextToken());

        long result = 0;
        long[][] arr = new long[n][2];
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Long.parseLong(st.nextToken());
            arr[i][1] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return (int)o2[1] - (int)o1[1];
            }
        });

        for(int i=0 ; i<n ; i++) {
            long sum = arr[i][0] + arr[i][1] * --t;
            result += sum;
        }

        System.out.println(result);
    }
}
