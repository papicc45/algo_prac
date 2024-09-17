package prefixsum;

import javax.naming.AuthenticationNotSupportedException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_2632 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] p1 = new int[m*2+1];
        int[] p2 = new int[n*2+1];
        for(int i=1 ; i<=m ; i++) {
            p1[i] = p1[i+m] = Integer.parseInt(br.readLine());
        }
        for(int i=1 ; i<=n ; i++) {
            p2[i] = p2[i+n] = Integer.parseInt(br.readLine());
        }

        for(int i=1 ; i<m*2+1 ; i++) {
            p1[i] += p1[i-1];
        }

        for(int i=1 ; i<n*2+1 ; i++) {
            p2[i] += p2[i-1];
        }

        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        if(p1[m] == size) result++;
        if(p2[n] == size) result++;
        map.put(p1[m], 1);

        for(int i=1 ; i<=m ; i++) {
            for(int j=i ; j<i+m-1 ; j++) {
                int sum = p1[j] - p1[i-1];
                if(sum > size) continue;
                if(sum == size) result++;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        result += map.getOrDefault(size - p2[n], 0);

        for(int i=1 ; i<=n ; i++) {
            for(int j=i ; j<i+n-1 ; j++) {
                int sum = p2[j] - p2[i-1];
                if(sum > size) continue;
                if(sum == size) result++;

                result += map.getOrDefault(size - sum, 0);
            }
        }
        System.out.println(result);
    }
}
