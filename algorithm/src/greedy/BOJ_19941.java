package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[] hamburgerPeople = br.readLine().toCharArray();
        boolean[] eated = new boolean[n];

        int result = 0;
        for(int i=0; i<hamburgerPeople.length ; i++) {
            if(hamburgerPeople[i] == 'P') {
                for(int j=i-k ; j<=i+k ; j++) {
                    if(j>=0 && j<n) {
                        if(hamburgerPeople[j] == 'H' && !eated[j]) {
                            eated[j] = true;
                            result++;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
}
