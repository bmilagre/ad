package ch.hslu.ad.sw01;

public class Ackermann {
    private int counter = 0;

    public static void main(String[] args) {
        //Count how many calls on
        Ackermann ackermann = new Ackermann();
        ackermann.ack(2,2);
        System.out.println("Function was called: " + ackermann.counter + " times");
    }

    public long ack(long n, long m) {
        this.counter++;

        if(n == 0){
            return m + 1;
        }

        if(n > 0 && m == 0){
            return ack(n - 1, 1);
        }

        return ack(n-1, ack(n, m-1));
    }
}
