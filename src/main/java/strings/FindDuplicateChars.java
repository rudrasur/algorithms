package strings;

public class FindDuplicateChars {

    public static void main(String[] args) {
        System.out.println(solution1("abcd"));
    }

    /**
     * Checks if string as duplicate chars
     * @param s
     * @return true if no duplicate, false if duplicate char exists.
     */
    private static boolean solution1(String s) {
        int max = 0;
        for (int i=0; i<s.length(); i++) {
            if (max < s.charAt(i) ) {
                max = s.charAt(i);
            }
        }
        boolean charArray[] = new boolean[max+1];
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (charArray[c]) return false;
            charArray[c] = true;
        }
        return true;
    }
}
