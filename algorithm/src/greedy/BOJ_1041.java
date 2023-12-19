package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1041 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long result = 0;

        long[] dice = new long[6];
        long minOne = Long.MAX_VALUE;
        for(int i=0 ; i<6 ; i++) {
            dice[i] = Long.parseLong(st.nextToken());
            minOne = Math.min(minOne, dice[i]);
        }

        if(n == 1) {
            Arrays.sort(dice);
            for(int i=0 ; i<5 ; i++) {
                result += dice[i];
            }

            System.out.println(result);
            return;
        }

        long minTwo = Long.MAX_VALUE;
        for(int i=0 ; i<6 ; i++) {
            for(int j=0 ; j<6 ; j++) {
                if((i == 0 && j == 5) || (i == 5 && j == 0))
                    continue;

                if((i == 1 && j == 4) || (i == 4 && j == 1))
                    continue;

                if((i == 2) && (j == 3) || (i == 3 && j == 2))
                    continue;

                if(i == j)
                    continue;
                minTwo = Math.min(minTwo, dice[i] + dice[j]);
            }
        }

        long minTop = Math.min(dice[2], dice[3]);
        long minSide = Math.min(dice[4] + dice[0], Math.min(dice[0] + dice[1], Math.min(dice[1] + dice[5], dice[4] + dice[5])));
        long minThree = minTop + minSide;

        result = (minThree * 4L) + ((n - 2) * 4 * minTwo) + ((n - 1) * 4 * minTwo) + ((n - 2) * (n-1) * 4 * minOne) + ((n-2) * (n-2) * minOne);

        System.out.println(result);
    }
}
