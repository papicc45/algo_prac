package greedy;

import java.util.Scanner;

public class BOJ_21314 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] arr = sc.nextLine().toCharArray();

        StringBuilder sb = new StringBuilder();
        int index = 0;
        //최대값
        while (index != arr.length) {
            char temp = arr[index];

            if(temp == 'K') {
                sb.append("5");
                index++;
            } else {
                if(index == arr.length - 1) {
                    sb.append("1");
                    index++;
                    continue;
                }

                sb.append("5");
                while (++index != arr.length && arr[index] != 'K') {
                    sb.append("0");
                }
                index++;
                sb.append("0");
            }
        }
        System.out.println(sb.toString());
        sb = new StringBuilder();
        index = 0;
        while (index != arr.length) {
            char temp = arr[index];

            if(temp == 'K') {
                sb.append("5");
                index++;
            } else {
                if(index == arr.length - 1) {
                    sb.append("1");
                    index++;
                    continue;
                }

                sb.append("1");
                while (++index != arr.length && arr[index] == 'M') {
                    sb.append("0");
                }
                index++;
                sb.append("5");
            }
        }
        System.out.println(sb.toString());
    }
}
