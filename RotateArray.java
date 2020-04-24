import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] A = {3, 8, 9, 7, 6};
        int K = 3;
        int N = A.length;
        int[] result = solution(A, N, K);
        System.out.println(Arrays.toString(result));
    }

    private static int[] solution(int A[], int N, int K) {
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[(i + K) % N] = A[i]; 
        }
        return result;
    }
}