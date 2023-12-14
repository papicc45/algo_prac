package search.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<m ; i++) {
            int target = Integer.parseInt(st.nextToken());

            int start = 0;
            int end = n-1;
            boolean isFind = false;
            while(start < end) {
                int mid = (start + end) / 2;
                if(arr[mid] > target) {
                    end = mid-1;
                } else if(arr[mid] < target) {
                    start = mid+1;
                } else {
                    isFind = true;
                    break;
                }
            }
            if(isFind)
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
