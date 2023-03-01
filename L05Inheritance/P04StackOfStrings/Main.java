package L05Inheritance.P04StackOfStrings;

public class Main {
    public static void main(String[] args) {
        StackOfStrings stack = new StackOfStrings();
        stack.push("dadsa");
        stack.push("dasada");
        stack.push("dasda");
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.peek());

    }
}
