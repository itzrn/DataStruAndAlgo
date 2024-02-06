package DSAJAVA.Array;

import java.util.Scanner;

public class Insertion {
    //try to insert an element in a sorted array
    public static void main(String[] args) {

        System.out.print("Enter the number of element you want in the Array ---> ");
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=a;
        System.out.println();
        System.out.println("Add Your All Elements(Integer) --->");
        String[] array=new String[2*a];
        for (int i=0;i<a;i++){
            array[i]= sc.next();
        }
        InsertionDeletion<Object> objectInsertionDeletion=new InsertionDeletion<>(array,a);
        boolean check=true;
        System.out.println();
        while (check) {
            System.out.print("Would you like to add element to your Array ---> ");
            check = sc.nextBoolean();
            System.out.println();

            if (check) {
                System.out.println("Enter Element and Position at Element to be Added --->");
                objectInsertionDeletion.insertingElementByOrder(sc.next(), sc.nextInt());
                a++;
                b--;
            }
            else {
                for (int i = 0; i < a; i++) {
                    System.out.print(objectInsertionDeletion.array[i] + " ");
                }
                System.out.println();
                System.out.println("\t\tYou can add " + b + " more element to your array");
            }
        }
    }
}
