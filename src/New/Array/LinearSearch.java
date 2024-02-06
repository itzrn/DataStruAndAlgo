package DSAJAVA.Array;

import java.util.Scanner;

public class LinearSearch{//applicable on sorted or unsorted array
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Searching<Object>objectSearching=new Searching<>();

        System.out.print("Enter The Number fo element you want in the array ---> ");
        Integer[]array=new Integer[sc.nextInt()];
        for (int i=0;i< array.length;i++){
            array[i]= sc.nextInt();
        }

        System.out.println();
        System.out.print("Enter the element you want to search ---> ");
        System.out.println(objectSearching.linerSearch(array, sc.nextInt()));
    }
}

