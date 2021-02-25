package strings;

import java.util.Arrays;

public class IsPermutation {

    public static void main(String[] args) {
        System.out.println(solution2("dog", "god"));
        System.out.println(solution1("dog", "god"));
    }

    private static String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    /**
     * If the string is permutation, sorted string would be equal.
     * @param s1
     * @param s2
     * @return
     */
    private static boolean solution2(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        return sort(s1).equals(sort(s2));
    }

    /**
     * Takes the ASCII array, adds the index of char for s1, subtracts for s2,
     * if array of char in second iteration is less than 0  means it's not permuation.
     * @param s1
     * @param s2
     * @return
     */
    private static boolean solution1(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int[] arr = new int[256]; //assuming that ASCII won't go beyond 256
        for (int i =0; i<s1.length(); i++) {
            char idx = s1.charAt(i);
            arr[idx] += 1;
        }
        for (int i=0; i<s2.length(); i++) {
            char idx = s2.charAt(i);
            arr[idx] -= 1;
            if (arr[idx] < 0) return false;
        }
        return true;
    }
}
