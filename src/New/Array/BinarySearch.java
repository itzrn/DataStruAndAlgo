package DSAJAVA.Array;

import java.util.Scanner;

public class BinarySearch {//Provided Array Should be Sorted
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Searching<Object> searching=new Searching<>();
        System.out.print("Enter the Number of element you Want in the array ---> ");
        int[]array=new int[sc.nextInt()];
        System.out.println();
        System.out.println("Enter your all element ---> ");
        for (int i=0;i<array.length;i++){
            array[i]= sc.nextInt();
        }
        System.out.println();
        System.out.print("Enter the element you Want to search from the element ---> ");
        int element= sc.nextInt();
        System.out.println(searching.binarySearch(array,array.length-1,0,element));
    }
}
