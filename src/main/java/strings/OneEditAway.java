package strings;

public class OneEditAway {

    public static void main(String[] args) {
        System.out.println(oneEditAway("abcd", "xabcd"));
        System.out.println(oneEditAway("abcd", "abdd"));
        System.out.println(oneEditAway("abcd", "abcd"));
    }

    private static boolean oneEditAway(String a, String b) {
        int alen = a.length(), blen = b.length();
        if (alen == blen) {
            return replace(a, b);
        }
        if (alen + 1 == blen) {
            return insert(a, b);
        }
        if (alen == blen + 1) {
            return insert(b, a);
        }
        return false;
    }

    private static boolean insert(String a, String b) {
        int i1=0, i2=0, alen = a.length(), blen = b.length();
        while(i1 < alen && i2 < blen) {
            if (a.charAt(i1) != b.charAt(i2)) {
                if (i1 != i2) {
                    return false;
                }
                i2++;
            } else {
                i1++;
                i2++;
            }
        }
        return true;
    }

    private static boolean replace(String a, String b) {
        boolean foundDif = false;
        for (int i=0; i<a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (foundDif) return false;
                foundDif = true;
            }
        }
        return true;
    }
}
