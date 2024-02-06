package DSAJAVA.Array.Sorting;

public class SelectionSort<T extends Number> {

    public T[] selectionSort(T[] array){
        T temp;
        for (int i=0;i<array.length-1;i++){
            for (int j=i+1;j< array.length;j++){
                temp=array[i];
                if (array[i].doubleValue()>array[j].doubleValue()){
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        SelectionSort<Integer> selectionSort=new SelectionSort<>();
        Integer[] array={2, 3, 1, 5, 4, -1, -99, 88, -56};
        array=selectionSort.selectionSort(array);

        for (Integer integer : array) {
            System.out.println(integer);
        }
    }
}
