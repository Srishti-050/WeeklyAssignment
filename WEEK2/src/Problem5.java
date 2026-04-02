import java.util.*;

class Problem5 {

    // 🔹 Linear Search (first occurrence)
    static int linearSearch(String[] arr, String target) {
        int comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                System.out.println("Linear Comparisons: " + comparisons);
                return i;
            }
        }

        System.out.println("Linear Comparisons: " + comparisons);
        return -1;
    }

    // 🔹 Binary Search
    static int binarySearch(String[] arr, String target) {
        int low = 0, high = arr.length - 1;
        int comparisons = 0;

        while (low <= high) {
            comparisons++;
            int mid = (low + high) / 2;

            if (arr[mid].equals(target)) {
                System.out.println("Binary Comparisons: " + comparisons);
                return mid;
            }
            else if (arr[mid].compareTo(target) < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }

        System.out.println("Binary Comparisons: " + comparisons);
        return -1;
    }

    // 🔹 Count occurrences
    static int countOccurrences(String[] arr, String target) {
        int count = 0;
        for (String s : arr) {
            if (s.equals(target)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String[] logs = {"accB", "accA", "accB", "accC"};

        // Sort before binary search
        Arrays.sort(logs);

        int first = linearSearch(logs, "accB");
        System.out.println("First occurrence index: " + first);

        int bin = binarySearch(logs, "accB");
        System.out.println("Binary search index: " + bin);

        int count = countOccurrences(logs, "accB");
        System.out.println("Total occurrences: " + count);
    }
}