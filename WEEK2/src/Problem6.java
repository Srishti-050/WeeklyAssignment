import java.util.*;

class Problem6 {

    // 🔹 Linear Search (unsorted)
    static boolean linearSearch(int[] arr, int target) {
        int comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                System.out.println("Linear Comparisons: " + comparisons);
                return true;
            }
        }

        System.out.println("Linear Comparisons: " + comparisons);
        return false;
    }

    // 🔹 Binary Search (sorted)
    static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int comparisons = 0;

        while (low <= high) {
            comparisons++;
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                System.out.println("Binary Comparisons: " + comparisons);
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Binary Comparisons: " + comparisons);
        return -1;
    }

    // 🔹 Floor (largest ≤ target)
    static int floor(int[] arr, int target) {
        int res = -1;
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] <= target) {
                res = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    // 🔹 Ceiling (smallest ≥ target)
    static int ceil(int[] arr, int target) {
        int res = -1;
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= target) {
                res = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] risks = {10, 25, 50, 100};

        int target = 30;

        // Linear Search
        boolean found = linearSearch(risks, target);
        System.out.println("Found (Linear): " + found);

        // Binary Search (array must be sorted)
        int index = binarySearch(risks, target);
        System.out.println("Index (Binary): " + index);

        // Floor & Ceiling
        System.out.println("Floor value: " + floor(risks, target));
        System.out.println("Ceiling value: " + ceil(risks, target));
    }
}