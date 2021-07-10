package aisd.stack;

public class ReverseStack {
    public static void main(String[] args) throws FullStackException, EmptyStackException {
        ArrayStack<Integer> stack = new ArrayStack<>(5);


        for (int i = 0; i<5;i++){
            stack.push(i);
        }


        System.out.println(stack.toString());
        ArrayStack<Integer> reversed = new ArrayStack<>(stack.size());

        for (int i = 0; i < 5; i++) {
            reversed.push(stack.pop());
        }
        stack=reversed;
        System.out.println(stack.toString());
    }
}
