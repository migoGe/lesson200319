import java.util.Random;

class QuickSort {

    int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    void sort(int arr[], int low, int high) {
        if (low < high) {

            int pi = partition(arr, low, high);

            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        long startTime = System.nanoTime();
        Random r = new Random();
        int[] ar1 = new int[1000000];
        for (int i = 0; i < ar1.length; i++) {
            ar1[i] = r.nextInt(10);

        }
        int arr[] = { ar1[i] };
        int n = arr.length;

        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, n - 1);

        System.out.println("sorted array");
        printArray(arr);

        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        double d = (totalTime);
        System.out.println("Time in seconds: " + d / 1_000_000_000);

    }
}
