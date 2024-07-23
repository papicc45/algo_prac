package search.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_18114 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        HashSet<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            set.add(arr[i]);
            if(arr[i] == c) {
                System.out.println(1);
                return;
            }

        }
        Arrays.sort(arr);
        int left = 0;
        int right = n-1;

        boolean check = false;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if(sum == c) {
                check = true;
                break;
            } else if(sum < c) {
                if(set.contains(c - sum) && c-sum != arr[left] && c - sum != arr[right]) {
                    check = true;
                    break;
                }
                left++;
            } else {
                right--;
            }
        }
        if(check)
            System.out.println(1);
        else
            System.out.println(0);
    }
}
