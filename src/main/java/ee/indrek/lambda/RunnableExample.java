package ee.indrek.lambda;

public class RunnableExample {
    public static void main(String[] args) {
        Runnable r = () -> System.out.println("Hello World");
        Thread t = new Thread(r);
        t.start();
    }
}
