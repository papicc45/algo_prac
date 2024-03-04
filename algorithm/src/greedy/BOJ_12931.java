package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        while (!checkResult(arr)) {
            boolean[] check = new boolean[n];
            boolean allEven = true;
            for(int i=0 ; i<n ; i++) {
                if(arr[i] != 0 && arr[i] % 2 != 0) {
                    check[i] = true;
                    allEven = false;
                }
            }
            if(allEven) {
                for(int i=0 ; i<n ; i++) {
                    arr[i] = arr[i] / 2;
                }
                result++;
            } else {
                for(int i=0 ; i<n ; i++) {
                    if(check[i]) {
                        arr[i] = arr[i] - 1;
                        result++;
                    }
                }
            }
        }
        System.out.println(result);
    }
    private static boolean checkResult(int[] arr) {
        for(int i=0 ; i<arr.length ; i++) {
            if(arr[i] != 0)
                return false;
        }
        return true;
    }
}
