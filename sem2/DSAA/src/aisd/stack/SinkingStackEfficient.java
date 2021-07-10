package aisd.stack;

public class SinkingStackEfficient<T> extends ArrayStack<T> {

    int bottomIndex;

    public SinkingStackEfficient(int size){
        super(size);
    }

    public boolean isEmpty(){
        return bottomIndex==topIndex;
    }

    @Override
    public boolean isFull() {
        return bottomIndex == (topIndex+1)% array.length;
    }


    @Override
    public void push(T elem){
        if(isFull()){
            bottomIndex%=array.length;
        }
        array[topIndex++]= elem;
        topIndex%=array.length;
    }


    public static void main(String[] args) throws EmptyStackException {
        SinkingStackEfficient stack = new SinkingStackEfficient(5);
        for(int i =0 ; i<5;i++){
            stack.push(i);
        }
        System.out.println(stack);
        stack.push(8);
        System.out.println(stack);
        stack.push(12);
        System.out.println(stack);
        stack.push(120);
        System.out.println(stack);
        stack.push(5);
        System.out.println(stack);
        stack.push(44);
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }

}
