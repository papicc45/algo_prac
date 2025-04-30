package search.binarysearch;

import javax.naming.ldap.StartTlsRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14575 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int l = 0, r = 0;
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());

            l += arr[i][0];
            r += arr[i][1];
        }

        if(l > t || r < t) {
            System.out.println("01");
            return;
        }

        int left = 0;
        int right = t;
        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;
            boolean check = false;

            for(int i=0 ; i<n ; i++) {
                if(arr[i][0] > mid) {
                    check = true;
                    break;
                }
                sum += Math.min(arr[i][1], mid);
            }

            if(check || sum < t) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left);
    }
}
