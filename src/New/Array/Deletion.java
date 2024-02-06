package DSAJAVA.Array;

import java.util.Scanner;

public class Deletion {
    public static void main(String[] args) {
        System.out.print("Enter the number of element you want in the Array ---> ");
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        System.out.println();
        System.out.println("Add Your All Elements(Integer) --->");
        String[] array=new String[a];
        for (int i=0;i<a;i++){
            array[i]= sc.next();
        }
        InsertionDeletion<Object> objectInsertionDeletion=new InsertionDeletion<>(array,a);
        boolean check=true;

        while (check) {
            System.out.print("Would you like to delete an element from your array ---> ");
            check = sc.nextBoolean();
            if (check) {
                System.out.println("Enter the index of that particular element is to be delete ---> ");
                objectInsertionDeletion.deletingElementByOrder(sc.nextInt());
                a--;
            } else {
                for (int i = 0; i < a; i++) {
                    System.out.print(objectInsertionDeletion.array[i] + " ");
                }
            }
        }
    }
}
