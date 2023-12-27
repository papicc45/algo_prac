package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1105 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int lLen = getLength(l);
        int rLen = getLength(r);

        if(lLen != rLen) {
            System.out.println(0);
            return;
        }
        int[] lArr = seperate(lLen, l);
        int[] rArr = seperate(rLen, r);

        int min = Math.min(lLen, rLen);

        int result = 0;
        for(int i=min-1 ; i>=0 ; i--) {
            if(lArr[i] != rArr[i])
                break;
            if(lArr[i] == 8 && rArr[i] == 8) {
                result++;
            }
        }

        System.out.println(result);


    }
    public static int getLength(int a) {
        int cnt = 0;
        while(a != 0) {
            a = a / 10;
            cnt++;
        }

        return cnt;
    }

    public static int[] seperate(int len, int a) {
        int[] newArr = new int[len];
        int index = 0;
        while(a != 0) {
            int mod = a % 10;
            a = a / 10;

            newArr[index++] = mod;
        }

        return newArr;
    }
}
