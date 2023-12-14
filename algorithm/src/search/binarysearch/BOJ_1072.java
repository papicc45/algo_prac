package search.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int rate = (int)((long)y * 100 / x);

        int start = 0;
        int end = 1000000000;
        int answer = -1;
        while(start <= end) {
            int mid = (start + end) / 2;

            int nx = x + mid;
            int ny = y + mid;

            int nRate = (int)((long)ny * 100 / nx);
            if(nRate == rate) {
                start = mid + 1;
            } else {
                end = mid - 1;
                answer = mid;
            }
        }
        System.out.println(answer);
    }
}
