package lab.nine;

public class DisjointSetForest implements DisjointSetDataStructure {

    private class Element{
        int rank;
        int parent;
    }

    Element []arr;

    public DisjointSetForest(int size) {
        //TODO
        this.arr = new Element[size];
        for(int i = 0; i < size; i ++)
            makeSet(i);
    }

    @Override
    public void makeSet(int item) {
        //TODO
        arr[item] = new Element();
        arr[item].rank = 0;
        arr[item].parent = item;
    }

    @Override
    public int findSet(int item) {
        //TODO
        Element current = arr[item];
        if(current.parent != item){
            current.parent = findSet(current.parent);
        }
        return current.parent;
    }

    @Override
    public boolean union(int itemA, int itemB) {
        //TODO
        int parentOfA = findSet(itemA);
        int parentOfB = findSet(itemB);
        if(parentOfA == parentOfB) return false;
        if(arr[parentOfA].rank > arr[parentOfB].rank)
            arr[parentOfB].parent = parentOfA;
        else
            arr[parentOfA].parent = parentOfB;
        if(arr[parentOfA].rank == arr[parentOfB].rank)
            arr[parentOfB].rank++;
        return true;
    }


    @Override
    public String toString() {
        //TODO
        String result = "Disjoint sets as forest: \n";
        for(int i = 0; i < arr.length; i++){
            result += i + " -> " + arr[i].parent;
            if(i != arr.length-1) result += "\n";
        }
        return result;
    }
}