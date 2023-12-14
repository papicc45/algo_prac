package search.binarysearch;

import javax.sound.midi.MidiChannel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6236 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        int start = 0;
        int end = 10000;
        int min = Integer.MIN_VALUE;
        for(int i=0 ; i<n ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            min = Math.max(min, arr[i]);
        }
        int result = 0;
        start = min;
        while(start <= end) {
            int mid = (start + end) / 2;

            int cnt = 1;
            int money = mid;

            for(int val : arr) {
                money -= val;

                if(money < 0) {
                    cnt++;
                    money = mid - val;
                }
            }

            if(cnt <= m) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(result);
    }
}
