package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_30205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long p = Integer.parseInt(st.nextToken());

        boolean result = true;
        for(int i=0 ; i<n ; i++) {

            st = new StringTokenizer(br.readLine());
            int[] arr = new int[m];
            int cnt = 0;
            for(int j=0 ; j<m ; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                if(arr[j] == -1)
                    cnt++;
            }

            Arrays.sort(arr);
            for(int j=0 ; j<m ; j++) {
                if(arr[j] == -1) continue;
                if(p >= arr[j]) {
                    p += arr[j];
                } else {
                    if(cnt > 0) {
                        cnt--;
                        p *= 2;
                        if(p >= arr[j]) {
                            p += arr[j];
                        } else {
                            result = false;
                            break;
                        }
                    } else {
                        result = false;
                        break;
                    }
                }
            }
            if(cnt != 0) {
                for(int j=0 ; j<cnt ; j++) {
                    p *= 2;
                }
            }
            if(!result)
                break;
        }

        System.out.println(result ? "1" : "0");
    }
}
