package dynamicprogramming;

import javax.sql.rowset.spi.TransactionalWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2602 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String scroll = br.readLine();
        String devil = br.readLine();
        String angel = br.readLine();
        int sl = scroll.length();
        int dl = devil.length();
        int[][] devilDP = new int[dl][sl];
        int[][] angelDP = new int[dl][sl];


        if(scroll.charAt(0) == angel.charAt(0))
            angelDP[0][0] = 1;

        if(scroll.charAt(0) == devil.charAt(0))
            devilDP[0][0] = 1;

        for(int i=1 ; i<dl ; i++) {

            angelDP[i][0] = angel.charAt(i) == scroll.charAt(0) ? angelDP[i-1][0] + 1 : angelDP[i-1][0];
            for(int j=1 ; j<sl ; j++) {
                angelDP[i][j] = angel.charAt(i) == scroll.charAt(j) ? angelDP[i-1][j] + devilDP[i-1][j-1] : angelDP[i-1][j];
            }

            devilDP[i][0] = devil.charAt(i) == scroll.charAt(0) ? devilDP[i-1][0] + 1 : devilDP[i-1][0];
            for(int j=1 ; j<sl ; j++) {
                devilDP[i][j] = devil.charAt(i) == scroll.charAt(j) ? devilDP[i-1][j] + angelDP[i-1][j-1] : devilDP[i-1][j];
            }
        }
        System.out.println(angelDP[dl-1][sl-1] + devilDP[dl-1][sl-1]);
    }
}
