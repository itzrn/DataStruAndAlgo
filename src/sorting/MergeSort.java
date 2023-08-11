package src.sorting;

/*
 * here time complexity is nlogn
 * This we apply on two sorted array
 * after comparing element we keep that element in NEW ARRAY(newArr)
 *
 * This follow divide and conquer rule.
 * int[] arr = {6,3,9,5,2,8};
 *                 Divide
 *                   /\
 *                  /  \
 *           {6,3,9}    {5,2,8}
 *             /\         /\
 *            /  \       /  \
 *        {6,3} {9} {5,2}  {8}
 *         /\    |    /\    |
 *        /  \   |   /  \   |
 *      {6} {3} {9} {5} {2} {8} -> base case of the divide recursion
 *                Conquer
 *      {6} {3} {9} {5} {2} {8}
 *       \  /    |    \  /   |
 *        \/     |     \/    |
 *      {3,6}   {9}   {2,5} {8}
 *          \   /        \  /
 *           \ /          \/
 *         {3,6,9}     {2,5,8}
 *               \     /
 *                \   /
 *                 \ /
 *             {2,3,5,6,8,9}
 */

public class MergeSort {
    public void divide(int[]arr, int si, int ei){  // si -> starting index, ei -> ending index
        if(si>=ei){
            return;
        }
        int mid = si + (ei-si)/2;  // (si + ei)/2 ->  this can some time got out of integer bound
        divide(arr,si, mid);
        divide(arr,mid+1,ei);
        conquer(arr,si,mid,ei);
    }

    public void conquer(int[] arr, int si, int mid, int ei){
        int[] newArr = new int[ei-si+1];  // we are doing zero based indexing, therefore using +1 in array size

        int idx1 = si;  // tracking the index of first array
        int idx2 = mid+1; // tracking the index of second array
        int x = 0;  // tracking the index of newArr

        while (idx1<=mid && idx2<=ei){
            if(arr[idx1] <= arr[idx2]){
                newArr[x] = arr[idx1];
                x++;
                idx1++;
            }else {
                newArr[x] = arr[idx2];
                x++;
                idx2++;
            }
        }


        // both while loop will not run at a time
        while (idx1<=mid){  // this loop is for, let first array is still left with some element
            newArr[x] = arr[idx1];
            x++;
            idx1++;
        }

        while (idx2 <=ei){  // this loop is for, let second array is still left with some element
            newArr[x] = arr[idx2];
            x++;
            idx2++;
        }

        // now copying the newArr element in our original array
        for(int i=0, j=si; i< newArr.length;i++,j++){
            arr[j] = newArr[i];
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr = {6,3,9,5,2,8};
        mergeSort.divide(arr,0,arr.length-1);
        for (int j : arr) {
            System.out.println(j);
        }
    }
}
