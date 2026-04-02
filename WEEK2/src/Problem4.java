import java.util.*;

class Asset {
    String name;
    double returnRate;
    double volatility;

    Asset(String n, double r, double v) {
        name = n;
        returnRate = r;
        volatility = v;
    }
}

class Problem4 {

    // 🔹 Merge Sort (Ascending - Stable)
    static void mergeSort(Asset[] arr, int l, int r) {
        if (l >= r) return;

        int m = (l + r) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);

        merge(arr, l, m, r);
    }

    static void merge(Asset[] arr, int l, int m, int r) {
        Asset[] temp = new Asset[r - l + 1];

        int i = l, j = m + 1, k = 0;

        while (i <= m && j <= r) {
            if (arr[i].returnRate <= arr[j].returnRate) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= m) temp[k++] = arr[i++];
        while (j <= r) temp[k++] = arr[j++];

        for (int x = 0; x < temp.length; x++) {
            arr[l + x] = temp[x];
        }
    }

    // 🔹 Quick Sort (Descending)
    static int partition(Asset[] arr, int l, int r) {
        double pivot = arr[r].returnRate;
        int i = l - 1;

        for (int j = l; j < r; j++) {
            if (arr[j].returnRate > pivot) {
                i++;
                Asset temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Asset temp = arr[i + 1];
        arr[i + 1] = arr[r];
        arr[r] = temp;

        return i + 1;
    }

    static void quickSort(Asset[] arr, int l, int r) {
        if (l < r) {
            int pi = partition(arr, l, r);
            quickSort(arr, l, pi - 1);
            quickSort(arr, pi + 1, r);
        }
    }

    public static void main(String[] args) {
        Asset[] assets = {
                new Asset("AAPL", 12, 5),
                new Asset("TSLA", 8, 7),
                new Asset("GOOG", 15, 4)
        };

        // Merge Sort
        mergeSort(assets, 0, assets.length - 1);
        System.out.println("Ascending (Merge Sort):");
        for (Asset a : assets) {
            System.out.println(a.name + " " + a.returnRate);
        }

        // Quick Sort
        quickSort(assets, 0, assets.length - 1);
        System.out.println("\nDescending (Quick Sort):");
        for (Asset a : assets) {
            System.out.println(a.name + " " + a.returnRate);
        }
    }
}
