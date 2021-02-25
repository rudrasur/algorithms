package strings;

public class PowersOf2 {

    public static void main(String[] args) {
        powerOf(50);
    }

    /**
     * Output of 50 would be 1, 2, 4, 8, 16, 32
     * @param i
     * @return
     */
    private static int powerOf(int i) {
        if (i <=0 )
            return 0;
        if (i == 1) {
            System.out.println(1);
            return 1;
        }
        int pw = powerOf( i / 2);
        int val = pw * 2;
        System.out.println(val);
        return val;
    }
}
