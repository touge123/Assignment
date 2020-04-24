import java.util.*;

public class Permutation {
    public static void main(String[] args) {
        int[] A = {4, 1, 3, 2};
        int N = A.length;
        int[] ATest = {4, 1, 2, 3};
        int result = solution(A, N, ATest);
        System.out.println(result);
    }

    private static int solution(int[] A, int N, int[] ATest) {
        if (ATest.length != N) {
            return 0;
        }

        Map<Integer, Integer> mapping = new HashMap<>();
        for (int num : A) {
            if (mapping.containsKey(num)) {
                mapping.put(num, mapping.get(num) + 1);
            } else {
                mapping.put(num, 1);
            }
        }

        for (int num : ATest) {
            if (mapping.containsKey(num)) {
                mapping.put(num, mapping.get(num) - 1);
            } else {
                return 0;
            }
        }

        for (int value : mapping.values()) {
            if (value != 0) {
                return 0;
            }
        }

        return 1;
        

    }
}