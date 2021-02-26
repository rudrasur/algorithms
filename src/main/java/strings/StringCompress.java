package strings;

public class StringCompress {

    public static void main(String[] args) {
        System.out.println(compress("aabbbbbbbbbbbcd"));
    }

    private static String compress(String s) {
        StringBuilder output = new StringBuilder(s.length());
        int consecutiveCount=0;
        char[] arr = s.toCharArray();
        for (int i=0; i<s.length(); i++) {
            consecutiveCount++;
            if (i+1 >= s.length() || s.charAt(i) != s.charAt(i+1)) {
                output.append(s.charAt(i));
                if (consecutiveCount > 1) {
                    output.append(consecutiveCount);
                }
                consecutiveCount = 0;
            }
        }
        return  output.length() > s.length() ? s : output.toString();
    }

    private static String decompress(String s) {
        //TODO: Write decompress logic
        return null;
    }
}
