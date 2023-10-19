import com.sun.source.tree.MethodInvocationTree;

import javax.naming.directory.DirContext;
import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.Console;
import java.lang.module.ResolutionException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.logging.Level;
import java.util.zip.CheckedInputStream;

public class Main {
    public static void main(String[] args) {
    }


    public int solution(int x, int y, int n) {

        int answer = 0;
        int[] dp = new int[y+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[x] = 0;
        for(int i=x ; i<=y ; i++) {
            if(dp[i] == y + 1)
                continue;
            if(i + n <= y) {
                dp[i+n] = Math.min(dp[i] + 1, dp[i+n]);
            }

            if(i * 2 <= y) {
                dp[i*2] = Math.min(dp[i] + 1, dp[i*2]);
            }

            if(i * 3 <= y) {
                dp[i*3] = Math.min(dp[i] + 1, dp[i*3]);
            }
        }

        return dp[y] == Integer.MAX_VALUE ? -1 : dp[y];
    }

}



