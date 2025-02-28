package ch.hslu.ad.sw02;

public class StackMachine {
    private Stack<Integer> stack = new Stack<>(100);

    public void load(int number){
        this.stack.push(number);
    }

    public void add(){
        int number1 = stack.pop();
        int number2 = stack.pop();

        stack.push(number1 + number2);
    }

    public void sub(){
        int number1 = stack.pop();
        int number2 = stack.pop();

        // Nicht sicher ob das so möglich ist??
        stack.push(number2 - number1);
    }

    public void mul(){
        int number1 = stack.pop();
        int number2 = stack.pop();

        stack.push(number1 * number2);
    }

    public void div(){
        int number1 = stack.pop();
        int number2 = stack.pop();

        stack.push(number2 / number1);
    }

    public int print(){
        return stack.pop();
    }
}
