package aisd.stack;

public class VStack<T> extends ArrayStack<T> {
    int supplementaryPointer = 0;
    public VStack(int initialSize) {
        super(initialSize);
    }
    @Override
    public T pop() throws EmptyStackException {
        T value = super.pop();
        this.resetPointer();
        return value;
    }
    @Override
    public void push(T elem) throws FullStackException {
        super.push(elem);
        this.resetPointer();
    }
    public T getPointer() {
        if (this.supplementaryPointer < 0)
            return null;
        return this.array[supplementaryPointer];
    }
    public void resetPointer() {
        this.supplementaryPointer = this.topIndex - 1;
    }
    public void moveDown() {
        this.supplementaryPointer--;
//        if (this.supplementaryPointer == this.array.length) {
//            this.resetPointer();
//        }
    }
    public static void main(String[] args) throws FullStackException {
        var stack = new VStack<Integer>(10);
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        for (int i = 0; i < 20; i++) {
            System.out.println(stack.getPointer());
            stack.moveDown();
        }
    }
}