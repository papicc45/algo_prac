package dynamicprogramming;


import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_2313 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long result = 0;
        StringBuilder sb = new StringBuilder();
        for(int k=0 ; k<n ; k++) {
            int l = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            long[] prefix = new long[l+1];
            for(int i=1 ; i<=l ; i++) {
                    prefix[i] += prefix[i-1] + Integer.parseInt(st.nextToken());
            }

            long max = prefix[0];
            int maxS = 0, maxE = 0;

            long min = prefix[0];
            int minIdx = 0;

            for(int i=1 ; i<=l ; i++) {
                long cur = prefix[i] - min;

                /*
                    반례 테스트 다시
                 */
                if(cur > max) {
                    max = cur;
                    maxS = minIdx;
                    maxE = i - 1;
                } else if(cur == max) {
                    int curLen = i - minIdx;
                    int maxLen = maxE - maxS + 1;
                    if(curLen < maxLen) {
                        maxS = minIdx;
                        maxE = i - 1;
                    }
                }

                if(prefix[i] < min) {
                    min = prefix[i];
                    minIdx = i;
                } else if(prefix[i] == min) {
                    minIdx = i;
                }
            }
            result += max;
            sb.append(maxS + 1).append(" ").append(maxE + 1).append("\n");
        }
        System.out.println(result);
        System.out.println(sb.toString());

    }
}
