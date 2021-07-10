package lab.nine;


import java.util.Arrays;

public class DisjointSetLinkedList implements DisjointSetDataStructure {

    private class Element{
        int representant;
        int next;
        int length;
        int last;
    }

    private static final int NULL=-1;

    Element arr[];

    public DisjointSetLinkedList(int size) {
        //TODO
        this.arr = new Element[size];
        for(int i = 0; i<size;i++)
            makeSet(i);
    }

    @Override
    public void makeSet(int item) {
        //TODO
        this.arr[item] = new Element();    
        this.arr[item].representant = item;
        this.arr[item].next = -1;
        this.arr[item].length = 1;
        this.arr[item].last = item;
    }

    @Override
    public int findSet(int item) {
        //TODO
        return this.arr[item].representant;
    }

    @Override
    public boolean union(int itemA, int itemB) {
        //TODO
        int representativeOfA = findSet(itemA);
        int representativeOfB = findSet(itemB);
        if(representativeOfA == representativeOfB) return false;
        if(arr[representativeOfA].length < arr[representativeOfB].length)
            return append(representativeOfB, representativeOfA);
        else return append(representativeOfA,representativeOfB);
    }

    private boolean append(int a, int b){
        int lastA = arr[a].last;
        this.arr[lastA].next=b;
        int sizeOfB = arr[b].length;
        this.arr[a].length += sizeOfB;
        this.arr[a].last = arr[b].last;
        this.arr[b].length = 1;
        this.arr[b].last = b;
        int current = b;
        for(int i = 0; i < sizeOfB; i++){
            this.arr[current].representant = a;
            current = arr[current].next;
        }
        return  true;
    }

    @Override
    public String toString() {
        //TODO
        String result = "Disjoint sets as linked list: \n";
        int[] reps = new int[arr.length];
        for(int i = 0; i < arr.length; i++)
            reps[i] = findSet(i);
        Arrays.sort(reps);
        int j = 0;
        while (j < arr.length) {
            int current = reps[j];
            j++;
            result += current;
            while (arr[current].next != -1){
                current = arr[current].next;
                result += ", " + current;
                j++;
            }
            if(j < arr.length)
                result += "\n";
        }
        return result;
    }

}