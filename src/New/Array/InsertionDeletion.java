package DSAJAVA.Array;

class InsertionDeletion<T>{
    T[] array;
    int size;
    InsertionDeletion(T[] array,int size){
        this.array=array;
        this.size=size;
    }

    public void insertingElementByOrder(T elementToInsert,int pos){//not working on index, working as user convenient
        for (int i=this.size;i>=pos;i--){
            this.array[i]=this.array[i-1];
        }
        this.array[pos-1]=elementToInsert;
        this.size++;
    }
    public void deletingElementByOrder(int pos){
        for (int i=pos-1;i<this.size;i++){
            this.array[i]=this.array[i+1];
        }
        this.size--;
    }
}
