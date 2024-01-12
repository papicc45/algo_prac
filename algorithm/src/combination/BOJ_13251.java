package combination;

import java.awt.image.ImagingOpException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] stones = new int[m];
        int sum = 0;
        for(int i=0 ; i<m ; i++) {
            stones[i] = Integer.parseInt(st.nextToken());
            sum += stones[i];
        }

        int k = Integer.parseInt(br.readLine());

        double[] result = new double[m];
        double answer = 0.0;

        for(int i=0 ; i<m ; i++) {
            if(stones[i] >= k) {
                result[i] = 1.0;
                for(int j=0 ; j<k ; j++) {
                    result[i] *= (double) (stones[i] - j) / (sum - j);
                }
            }
            answer += result[i];
        }
        System.out.println(answer);
    }
}
