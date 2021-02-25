package strings;

public class URLify {

    public static void main(String[] args) {
        System.out.println(urlify("ab xy ab   sdf"));
    }

    private static String urlify(String s) {
        int trueLength = s.trim().length();
        int index, i, spaceCount = 0;
        for (i=0; i<trueLength; i++) {
            if (s.charAt(i) == ' ') {
                spaceCount++;
            }
        }
        index = trueLength + spaceCount * 2;
        char[] output = new char[index];
        for (i = trueLength -1; i>=0; i--) {
            if (s.charAt(i) != ' ') {
                output[index - 1] = s.charAt(i);
                index--;
            } else {
                output[index-1] = '0';
                output[index-2] = '2';
                output[index-3] = '%';
                index -= 3;
            }
        }
        return new String(output);
    }
}
