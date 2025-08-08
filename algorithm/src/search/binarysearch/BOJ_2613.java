package search.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2613 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());

        int left = 0;
        int right = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            left = Math.max(left, arr[i]);
            right += arr[i];
        }
        int result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;

            if(check(mid, m)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        int sum = 0;

        for(int i=n-1 ; i>=0 ; i--) {
            if(sum + arr[i] > result) {
                list.add(cnt);
                m--;
                sum = 0;
                cnt = 0;
            }
            if(i + 1 == m) {
                list.add(cnt + 1);
                for(int j=0 ; j<i ; j++) {
                    list.add(1);
                }
                break;
            }

            sum += arr[i];
            cnt++;
        }

        System.out.println(result);
        Collections.reverse(list);
        for(int i : list) {
            System.out.print(i + " ");
        }
    }
    private static boolean check(int mid, int m) {
        int group = 1;
        int sum = 0;

        for(int i=0 ; i<arr.length ; i++) {
            if(sum + arr[i] > mid) {
                group++;
                sum = arr[i];
            } else {
                sum += arr[i];
            }
        }

        return group <= m;
    }
}
