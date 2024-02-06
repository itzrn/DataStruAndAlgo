package DSAJAVA.Array;

public class Searching<T>{
    public int binarySearch(int[] array, int high, int low , int element){
        int mid=(high+low)/2;
        if (low>high)
            return -1;
//        else if (array[high]==element)
//            return high+1;
//        else if (array[low]==element)
//            return low+1;
        else if (array[mid]==element)
            return mid+1;
        else if (array[mid]>element)
            return binarySearch(array,mid-1,low,element);
        else if (array[mid]<element)
            return binarySearch(array,high,mid+1,element);
        else
            return -1;
    }

    public int linerSearch(T[] array, int element){
        for (T t : array) {
            if (t.equals(element)) {
                return 1;
            }
        }
        return -1;
    }
}
