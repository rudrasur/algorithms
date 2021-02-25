package strings;

import java.util.Locale;

public class PolindromePermutation {

    public static void main(String[] args) {
        int[] t = buildCharArray("Tact coa");
        System.out.println(checkOddCount(t));
    }

    /**
     * Polindrome permutation will ultimately have extacly a couple of each char & 1 char would be single.
     * @param t
     * @return
     */
    private static boolean checkOddCount(int[] t) {
        boolean oddFound = false;
        for (int c : t) {
            if (c%2 ==1) {
                if (oddFound) return false;
                oddFound = true;
            }
        }
        return true;
    }

    private static int[] buildCharArray(String s) {
        s = s.toLowerCase();
        int[] t = new int[ Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (int i=0; i<s.length(); i++) {
            int v = getCharNum(s.charAt(i));
            if (v >= 0) {
                t[v] += 1;
            }
        }
        return t;
    }

    private static int getCharNum(char charAt) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(charAt);
        if (a <= val || val <= z) {
            return val - a;
        }
        return -1;
    }
}
