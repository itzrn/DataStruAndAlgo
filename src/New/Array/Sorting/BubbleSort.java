package DSAJAVA.Array.Sorting;

public class BubbleSort<T extends Number> {

    public T[] bubbleSort(T[] array){
        T temp;
        for (int i=0;i< array.length-1;i++){
            for (int j=0;j< array.length-i-1;j++){
                temp=array[j];
                if (array[j].doubleValue()>array[j+1].doubleValue()){
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        return array;
    }

    public static void main(String[] args) {
        BubbleSort<Integer> bubbleSort=new BubbleSort<>();
        Integer[] array = {3,5,2,6,1,8,9,4,7};
        array=bubbleSort.bubbleSort(array);

        for (Integer integer : array) {
            System.out.println(integer);
        }
    }
}
