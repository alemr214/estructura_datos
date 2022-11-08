package sorting_algorithms;

import java.util.Arrays;

public class Main {

  void bubbleSort(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++)
      for (int j = 0; j < n - i - 1; j++)
        if (arr[j] > arr[j + 1]) {
          // swap arr[j+1] and arr[j]
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
  }

  static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  /*
   * This function takes last element as pivot, places
   * the pivot element at its correct position in sorted
   * array, and places all smaller (smaller than pivot)
   * to left of pivot and all greater elements to right
   * of pivot
   */
  static int partition(int[] arr, int low, int high) {

    // pivot
    int pivot = arr[high];

    // Index of smaller element and
    // indicates the right position
    // of pivot found so far
    int i = (low - 1);

    for (int j = low; j <= high - 1; j++) {

      // If current element is smaller
      // than the pivot
      if (arr[j] < pivot) {

        // Increment index of
        // smaller element
        i++;
        swap(arr, i, j);
      }
    }
    swap(arr, i + 1, high);
    return (i + 1);
  }

  /*
   * The main function that implements QuickSort
   * arr[] --> Array to be sorted,
   * low --> Starting index,
   * high --> Ending index
   */
  static void quickSort(int[] arr, int low, int high) {
    if (low < high) {

      // pi is partitioning index, arr[p]
      // is now at right place
      int pi = partition(arr, low, high);

      // Separately sort elements before
      // partition and after partition
      quickSort(arr, low, pi - 1);
      quickSort(arr, pi + 1, high);
    }
  }

  int shellSort(int arr[]) {
    int n = arr.length;

    // Start with a big gap, then reduce the gap
    for (int gap = n / 2; gap > 0; gap /= 2) {
      // Do a gapped insertion sort for this gap size.
      // The first gap elements a[0..gap-1] are already
      // in gapped order keep adding one more element
      // until the entire array is gap sorted
      for (int i = gap; i < n; i += 1) {
        // add a[i] to the elements that have been gap
        // sorted save a[i] in temp and make a hole at
        // position i
        int temp = arr[i];

        // shift earlier gap-sorted elements up until
        // the correct location for a[i] is found
        int j;
        for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
          arr[j] = arr[j - gap];

        // put temp (the original a[i]) in its correct
        // location
        arr[j] = temp;
      }
    }
    return 0;
  }

  // A utility function to get maximum value in arr[]
  static int getMax(int arr[], int n) {
    int mx = arr[0];
    for (int i = 1; i < n; i++)
      if (arr[i] > mx)
        mx = arr[i];
    return mx;
  }

  // A function to do counting sort of arr[] according to
  // the digit represented by exp.
  static void countSort(int arr[], int n, int exp) {
    int output[] = new int[n]; // output array
    int i;
    int count[] = new int[10];
    Arrays.fill(count, 0);

    // Store count of occurrences in count[]
    for (i = 0; i < n; i++)
      count[(arr[i] / exp) % 10]++;

    // Change count[i] so that count[i] now contains
    // actual position of this digit in output[]
    for (i = 1; i < 10; i++)
      count[i] += count[i - 1];

    // Build the output array
    for (i = n - 1; i >= 0; i--) {
      output[count[(arr[i] / exp) % 10] - 1] = arr[i];
      count[(arr[i] / exp) % 10]--;
    }

    // Copy the output array to arr[], so that arr[] now
    // contains sorted numbers according to current
    // digit
    for (i = 0; i < n; i++)
      arr[i] = output[i];
  }

  // The main function to that sorts arr[] of
  // size n using Radix Sort
  static void radixsort(int arr[], int n) {
    // Find the maximum number to know number of digits
    int m = getMax(arr, n);

    // Do counting sort for every digit. Note that
    // instead of passing digit number, exp is passed.
    // exp is 10^i where i is current digit number
    for (int exp = 1; m / exp > 0; exp *= 10)
      countSort(arr, n, exp);
  }

  void merge(int arr[], int l, int m, int r) {
    // Find sizes of two subarrays to be merged
    int n1 = m - l + 1;
    int n2 = r - m;

    /* Create temp arrays */
    int L[] = new int[n1];
    int R[] = new int[n2];

    /* Copy data to temp arrays */
    for (int i = 0; i < n1; ++i)
      L[i] = arr[l + i];
    for (int j = 0; j < n2; ++j)
      R[j] = arr[m + 1 + j];

    /* Merge the temp arrays */

    // Initial indexes of first and second subarrays
    int i = 0, j = 0;

    // Initial index of merged subarray array
    int k = l;
    while (i < n1 && j < n2) {
      if (L[i] <= R[j]) {
        arr[k] = L[i];
        i++;
      } else {
        arr[k] = R[j];
        j++;
      }
      k++;
    }

    /* Copy remaining elements of L[] if any */
    while (i < n1) {
      arr[k] = L[i];
      i++;
      k++;
    }

    /* Copy remaining elements of R[] if any */
    while (j < n2) {
      arr[k] = R[j];
      j++;
      k++;
    }
  }

  // Main function that sorts arr[l..r] using
  // merge()
  void sort(int arr[], int l, int r) {
    if (l < r) {
      // Find the middle point
      int m = l + (r - l) / 2;

      // Sort first and second halves
      sort(arr, l, m);
      sort(arr, m + 1, r);

      // Merge the sorted halves
      merge(arr, l, m, r);
    }
  }

  private static int nextGap(int gap) {
    if (gap <= 1)
      return 0;
    return (int) Math.ceil(gap / 2.0);
  }

  // Function for swapping

  // Merging the subarrays using shell sorting
  // Time Complexity: O(nlog n)
  // Space Complexity: O(1)
  private static void inPlaceMerge(int[] nums, int start,
      int end) {
    int gap = end - start + 1;
    for (gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {
      for (int i = start; i + gap <= end; i++) {
        int j = i + gap;
        if (nums[i] > nums[j])
          swap(nums, i, j);
      }
    }
  }

  // merge sort makes log n recursive calls
  // and each time calls merge()
  // which takes nlog n steps
  // Time Complexity: O(n*log n + 2((n/2)*log(n/2)) +
  // 4((n/4)*log(n/4)) +.....+ 1)
  // Time Complexity: O(logn*(n*log n))
  // i.e. O(n*(logn)^2)
  // Space Complexity: O(1)
  private static void mergeSort(int[] nums, int s, int e) {
    if (s == e)
      return;

    // Calculating mid to slice the
    // array in two halves
    int mid = (s + e) / 2;

    // Recursive calls to sort left
    // and right subarrays
    mergeSort(nums, s, mid);
    mergeSort(nums, mid + 1, e);
    inPlaceMerge(nums, s, e);
  }

  /* Prints the array */
  void printArray(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n; ++i)
      System.out.print(arr[i] + " ");
    System.out.println();
  }

  // Driver method to test above
  public static void main(String args[]) {
    Main ob = new Main();
    int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
    int n = arr.length;
    // ob.bubbleSort(arr);
    // System.out.println("Sorted array");
    // ob.printArray(arr);
    // quickSort(arr, 0, n - 1);
    // System.out.println("Sorted array: ");
    // ob.printArray(arr);
    // ob.sort(arr);
    // radixsort(arr, n);
    // ob.printArray(arr);
    // System.out.println("Array after sorting");
    // ob.printArray(arr);
    // ob.sort(arr, 0, n - 1);

    // System.out.println("\nSorted array");
    // ob.printArray(arr);
    mergeSort(arr, 0, n - 1);
    ob.printArray(arr);
  }

}
