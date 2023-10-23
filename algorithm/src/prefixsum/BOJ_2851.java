package prefixsum;

import java.io.IOException;
import java.util.Scanner;

public class BOJ_2851 {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        Scanner sc = new Scanner(System.in);

        int[] arr = new int[11];
        for(int i=1 ; i<=10 ; i++) {
            arr[i] = arr[i-1] + sc.nextInt();
        }

        int index = 0;
        for(int i=1 ; i<=10 ; i++) {
            if(arr[i] >= 100) {
                index = i;
                break;
            }
        }
        if(index == 0) {
            System.out.println(arr[10]);
        } else {
            int diffA = 100 - arr[index - 1];
            int diffB = Math.abs(100 - arr[index]);

            if(diffB <= diffA) {
                System.out.println(arr[index]);
            } else {
                System.out.println(arr[index-1]);
            }
        }
    }
}
