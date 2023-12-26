package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19939 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int count = k;
        int sum = 0;
        int[] arr = new int[k+1];
        for(int i=k ; i>0 ; i--) {
            arr[i] = count;
            count--;

            sum += arr[i];
        }

        if(sum > n) {
            System.out.println(-1);
            return;
        }

        int mod = (n - sum) % k;
        int index = k;
        while(mod != 0) {
            arr[index--]++;
            mod--;
        }

        System.out.println(arr[k] - arr[1]);

    }
}
