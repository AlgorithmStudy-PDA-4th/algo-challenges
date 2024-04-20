class Solution {
    static int answer = 0;
    static int N;
    static int[] arr;

    public int solution(int n) {
        arr = new int[n];
        N = n;

        nQueen(0);

        return answer;
    }

    static void nQueen(int depth) {
        if (depth == N) {
            answer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            if (canMove(depth)) {
                nQueen(depth + 1);
            }
        }
    }

    static boolean canMove(int col) {
        for (int i = 0; i < col; i++) {
            if (arr[col] == arr[i]) {
                return false;
            } else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) { //대각
                return false;
            }
        }
        return true;
    }
}