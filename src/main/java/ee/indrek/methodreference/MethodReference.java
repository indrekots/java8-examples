package ee.indrek.methodreference;

import ee.indrek.domain.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class MethodReference extends ParentReference {

    private List<Book> books;

    public static void main(String[] args) {
        MethodReference methodReference = new MethodReference();
        methodReference.run();
    }

    private void run() {
        //method reference to a static method
        List<String> stringInts = Arrays.asList("1", "2", "3");
        List<Integer> ints = stringInts.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());

        books = new ArrayList<>();
        books.add(new Book("All Quiet on the Western Front", 295, "Erich Maria Remarque"));

        //method reference example
        IntSupplier bookLength = books::size;
        System.out.println(bookLength.getAsInt());

        //constructor reference example
        Supplier<Book> bookSupplier = Book::new;

        //constructor reference to a one argument constructor
        Function<String, Book> b = Book::new;
        Book book = b.apply("Book name");
        System.out.println(book);

        //array constructor reference
        IntFunction<int[]> array = int[]::new;
        int[] apply = array.apply(10);
        System.out.println(apply.length);

        //this keyword in method reference
        new Thread(this::sayHello).start();

        //super keyword in method reference
        new Thread(super::sayHello).start();
    }

    @Override
    public void sayHello() {
        System.out.println("Hello World!");
    }
}
