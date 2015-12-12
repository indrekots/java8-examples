package ee.indrek.methodreference;

import ee.indrek.behavior.example.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class MethodReference {

    private List<Book> books;

    public static void main(String[] args) {
        MethodReference methodReference = new MethodReference();
        methodReference.run();
    }

    private void run() {
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
    }
}
