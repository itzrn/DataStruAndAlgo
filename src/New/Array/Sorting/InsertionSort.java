package DSAJAVA.Array.Sorting;

public class InsertionSort<T extends Number> {

    public T[] insertionSort(T[] array){
        T temp;
        for (int i=1;i< array.length;i++){
            temp = array[i];
            for (int j = i-1;j>=0;j--){
                if (temp.doubleValue()>array[j].doubleValue()){
                    break;
                }
                array[j+1] = array[j];
                array[j] = temp;
            }
        }

        return array;
    }

    public static void main(String[] args) {
        InsertionSort<Integer> insertionSort=new InsertionSort<>();
        Integer[] array = {2, 3, 1, 5, 4, -1, -99, 88, -56};
        array=insertionSort.insertionSort(array);

        for (Integer integer : array) {
            System.out.println(integer);
        }
    }
}
