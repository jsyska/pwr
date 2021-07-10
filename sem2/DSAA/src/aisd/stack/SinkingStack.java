package aisd.stack;

public class SinkingStack<T> extends ArrayStack<T> {

    public SinkingStack(int size){
        super(size);
    }
    @Override
    public void push(T elem) {
        if(isFull()){
            deleteAtBottom();
            array[topIndex-1]=elem;
        }
        else {
            array[topIndex++] = elem;
        }
    }

    public void deleteAtBottom(){
        for(int i=this.size(); i>1;i--){
            this.array[this.size()-i] = this.array[this.size()-i+1];
        }
    }

    public static void main(String[] args) {
        SinkingStack stack = new SinkingStack(5);
        for(int i = 0;i<5;i++){
            stack.push(i);
        }
        System.out.println(stack.toString());
        stack.push(6);
        System.out.println(stack.toString());
    }
}
