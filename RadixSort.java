
import java.util.*;
import java.util.Random;

class Radix {

    static int getMax(int arr[], int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    static void countSort(int arr[], int n, int exp) {
        int output[] = new int[n];
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    static void radixsort(int arr[], int n) {

        int m = getMax(arr, n);

        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

    static void print(int arr[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        Random r = new Random();
        int[] ar1 = new int[1000000];
        for (int i = 0; i < ar1.length; i++) {
            ar1[i] = r.nextInt(10);

            int arr[] = { ar1[i] };
            int n = arr.length;
            radixsort(arr, n);
            print(arr, n);

        }
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        double d = (totalTime / 10000000);
        System.out.println("Time in seconds: " + d / 1_000_000_000);
    }

}
