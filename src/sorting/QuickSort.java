package src.sorting;
// time complexity is nlogn
// worst time complexity is O(n^2)
public class QuickSort {
    public void quickSort(int[] arr, int low, int high){  // low->0, high->arr.length-1 (doing zero indexing)
        if(low < high){ // if low less than high then only we will go for quick sort
            int pivot = partition(arr,low,high);

            quickSort(arr,low,pivot-1);  // applying quick sort on the left array of pivot
            quickSort(arr,pivot+1,high);  // applying quick sort on the right array of pivot
        }
    }

    public int partition(int[]arr, int low, int high){  // this will return the index of pivot after making al the
        // small element in the left array and the bigger element in the right array

        int pivot = arr[high];  // making pivot to end index of the array
        int i = low-1; // this will track how many smaller element will come in array, before pivot

        for(int j = low;j<high;j++){  // j<high, we will not run loop for pivot bcz we already know at index high we have pivot.
            if(arr[j] < pivot){
                i++;

                //swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++; // making space for pivot
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;
        return i;  // pivot index
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = {6,3,9,5,2,8};
        quickSort.quickSort(arr,0,arr.length-1);

        for (int j : arr) {
            System.out.println(j);
        }
    }
}
