package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.concurrent.CountDownLatch;

public class BOJ_1456 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int[] arr = new int[10000001];

        for(int i=2 ; i<10000001 ; i++) {
            arr[i] = i;
        }

        for(int i=2 ; i<10000001 ; i++) {
            if(arr[i] == 0)
                continue;

            for(int j=i+i ; j<10000001 ; j+=i) {
                arr[j] = 0;
            }
        }

        long result = 0;
        for(int i=2 ; i<10000001 ; i++) {
            long temp = arr[i];
            if(arr[i] != 0) {
                while((double)arr[i] <= (double)b/(double)temp) {
                    if((double)arr[i] >= (double)a/(double)temp) {
                        result++;
                    }
                    temp *= arr[i];
                }
            }
        }

        System.out.println(result);
    }
}
