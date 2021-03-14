package sorting;

public class MergeSort {

    public static void main(String args[]) {
        int[] arr = new int[] {5,4,3,2,1};
        System.out.println("------Before sorting----------");
        printArray(arr);
        System.out.println("------After sorting-----------");
        printArray(mergeSort(arr));
    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int midpoint = arr.length / 2;
        boolean evenLength = arr.length % 2 == 1;
        int[] left = new int[midpoint];
        int[] right = new int[midpoint + (evenLength ? 1 : 0)];
        int i;
        for (i=0; i<midpoint; i++) {
            left[i] = arr[i];
            right[i] = arr[midpoint+i];
        }
        if (evenLength) {
            right[i] = arr[arr.length - 1 ];
        }

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);

    }

    private static int[] merge(int[] left, int[] right) {
        int leftPointer, rightPointer, resultPointer;
        leftPointer=rightPointer=resultPointer=0;
        int m = left.length, n = right.length;
        int[] result = new int[m+n];
        while(leftPointer < m || rightPointer < n) {
            if (leftPointer < m && rightPointer < n) {
                if (left[leftPointer] < right[rightPointer]) {
                    result[resultPointer++] = left[leftPointer++];
                } else {
                    result[resultPointer++] = right[rightPointer++];
                }
            } else if (leftPointer < m) {
                result[resultPointer++] = left[leftPointer++];
            } else if (rightPointer < n) {
                result[resultPointer++] = right[rightPointer++];
            }
        }
        return result;
    }

    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print( i + " ");
        }
        System.out.println();
    }

}