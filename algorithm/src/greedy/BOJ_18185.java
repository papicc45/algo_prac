package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18185 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] ramens = new long[n];
        String[] str = br.readLine().split(" ");
        for(int i=0 ; i<n ; i++) {
            ramens[i] = Long.parseLong(str[i]);
        }
        long sum = 0;
        int index = n-1;
        while (index >= 0) {
            if(ramens[index] == 0) {
                index--;
                continue;
            }
            sum += ramens[index] * 3;
            long min = ramens[index];
            int i = index-1;
            while (i > index -  3 && i >= 0) {
                if(min > ramens[i]) {
                    min = ramens[i];
                }
                sum += min * 2;
                ramens[i] -= min;
                i--;
            }
            index--;
        }
        System.out.println(sum);
    }
}
