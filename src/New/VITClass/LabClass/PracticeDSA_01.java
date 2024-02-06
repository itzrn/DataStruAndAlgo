package DSAJAVA.VITClass.LabClass;

import java.util.Scanner;

public class PracticeDSA_01 {
    Scanner scanner =new Scanner(System.in);
    int[] array;
    int length;
    int filledIndex;

    PracticeDSA_01(int length){
        array=new int[length];
        this.length= length;
        filledIndex=-1;
    }

    public void addFirst(int data){
        if (filledIndex == -1){
            array[0] = data;
            filledIndex = 0;
            return;
        }

        for (int i=filledIndex;i>=0;i--){
            array[i+1] = array[i];
        }
        array[0] = data;
        filledIndex++;
    }

    public void addLast(int data){
        array[filledIndex+1] = data;
        filledIndex++;
    }

    public void addAt(int index, int data){
        if (index<=filledIndex || (filledIndex == -1 && index == 0)) {
            for (int i = filledIndex; i >= index; i--) {
                array[i + 1] = array[i];
            }
            array[index] = data;
            filledIndex++;
        }else {
            System.out.println("Enter Valid Index!");
            System.out.println("Enter index and data --->");
            addAt(scanner.nextInt(), scanner.nextInt());
        }
    }

    public void removeFirst(){
        for (int i=0;i<filledIndex-1;i++){
            array[i] = array[i+1];
        }
        filledIndex--;
    }

    public void removeLast(){
        filledIndex--;
    }

    public void removeAt(int index){
        if (index<=filledIndex) {
            for (int i = index; i < filledIndex; i++) {
                array[i] = array[i + 1];
            }
            filledIndex--;
        }else {
            System.out.println("Enter Valid Index!");
            System.out.println("Enter index --->");
            removeAt(scanner.nextInt());
        }
    }

    public void print(){
        if (filledIndex>-1) {
            System.out.print("[" + array[0]);
            for (int i = 1; i <= filledIndex; i++) {
                System.out.print(" " + array[i]);
            }
            System.out.println("]");
        }
    }

    public void operations(){
        System.out.println("\t\tOPERATIONS TO DO");
        System.out.println("1 -addFirst");
        System.out.println("2 -addLast");
        System.out.println("3 -addAt");
        System.out.println("4 -removeFirst");
        System.out.println("5 -removeLast");
        System.out.println("6 -removeAt");
        System.out.println("7 -Print the array");
        System.out.println("8 -Exit The Program");
        System.out.println();
        System.out.println();
    }

    public void operationsToPerform(){
        if (filledIndex == length-1){
            System.out.println("OPERATIONS CAN ONLY PERFORM");
            System.out.println("4 -removeFirst");
            System.out.println("5 -removeLast");
            System.out.println("6 -removeAt");
            System.out.println("7 -Print the array");
            System.out.println("8 -Exit The Program");
            System.out.println("ENTER YOUR CHOICE");
        }else if(filledIndex == -1){
            System.out.println("OPERATIONS CAN ONLY PERFORM");
            System.out.println("1 -addFirst");
            System.out.println("2 -addLast");
            System.out.println("3 -addAt");
            System.out.println("8 -Exit The Program");
            System.out.println("ENTER YOUR CHOICE");
        }
    }

    public void output(Scanner sc,int n){
        switch (n){
            case 1:
                System.out.print("Enter your data ---> ");
                addFirst(sc.nextInt());
                break;
            case 2:
                System.out.print("Enter your data ---> ");
                addLast(sc.nextInt());
                break;
            case 3:
                System.out.print("Enter index and data ---> ");
                addAt(sc.nextInt(), sc.nextInt());
                break;
            case 4:
                removeFirst();
                break;
            case 5:
                removeLast();
                break;
            case 6:
                System.out.print("Enter index to remove ---> ");
                removeAt(sc.nextInt());
                break;
            case 7:
                print();
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Length of Array ---> ");
        PracticeDSA_01 practiceDSA_01 = new PracticeDSA_01(sc.nextInt());
        practiceDSA_01.operations();

        boolean check;

        practiceDSA_01.operationsToPerform();
        int n = sc.nextInt();
        while (n!=8) {
            if (n >= 1 && n <= 8) {
                check = true;
                while (check) {
                    if (practiceDSA_01.filledIndex == -1) {
                        if (n == 1 || n == 2 || n == 3) {
                            practiceDSA_01.output(sc, n);
                            check = false;
                        } else {
                            System.out.println("Enter Valid Input!");
                            n = sc.nextInt();
                            if (n == 8)
                                break;
                        }
                    } else if (practiceDSA_01.filledIndex == practiceDSA_01.length - 1) {
                        if (n == 4 || n == 5 || n == 6 || n == 7) {
                            practiceDSA_01.output(sc, n);
                            check = false;
                        } else {
                            System.out.println("Enter Valid Input");
                            n = sc.nextInt();
                            if (n == 8)
                                break;
                        }
                    } else {
                        practiceDSA_01.output(sc, n);
                        check = false;
                    }
                }
                if (n == 8)
                    break;
                practiceDSA_01.operationsToPerform();
                if (practiceDSA_01.filledIndex != -1 && practiceDSA_01.filledIndex != practiceDSA_01.length - 1) {
                    System.out.println("All Operations can be performed!");
                    System.out.println();
                }
                n = sc.nextInt();
            }else {
                System.out.println("Enter Valid Input!");
                n= sc.nextInt();
            }
        }
    }
}
