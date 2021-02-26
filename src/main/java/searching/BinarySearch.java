package searching;

public class BinarySearch {

    public static void main(String[] args) {
        int[] input = new int[]{2, 4, 5, 7, 8, 9, 12, 15};
        for (int key : input) {
            System.out.println("LOOPING: Element: " + key + " found at: " + looping(input, key));
            System.out.println("RECURSIVE: Element: " + key + " found at: " + recursive(input, key, 0, input.length-1));
        }
        System.out.println("LOOPING: Element: " + 20 + " found at: " + looping(input, 20));
        System.out.println("RECURSIVE: Element: " + 20 + " found at: " + recursive(input, 20, 0, input.length-1));
    }

    private static int looping(int[] array, int key) {
        int low = 0, high = array.length - 1;
        while (low <= high) {
            int mid = (low+high) / 2;
            if (array[mid] == key) {
                return mid;
            }
            if (array[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private static int recursive(int[] array, int key, int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == key) {
                return mid;
            }
            if (array[mid] > key) {
                return recursive(array, key, low, mid-1);
            }
            return recursive(array, key, mid+1, high);
        }
        return -1;
    }
}
