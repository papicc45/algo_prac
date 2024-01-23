package dynamicprogramming;

public class PRO_정수_삼각형 {
    public static void main(String[] args) {
        int[][] triangle = new int[][] {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(triangle[0][2]);
        System.out.println(solution(triangle));
    }
    public static int solution(int[][] triangle) {
        int answer = 0;

        int n = triangle.length;
        int[][] dp = new int[n][n];

        for(int i=0 ; i<n ; i++) {
            dp[n-1][i] = triangle[n-1][i];
        }

        for(int i=n-2 ; i>=0 ; i--) {
            for(int j=0 ; j<=i ; j++) {
                dp[i][j] = Math.max(dp[i+1][j], dp[i+1][j+1]) + triangle[i][j];
            }
        }

        answer = dp[0][0];
        return answer;
    }
}
