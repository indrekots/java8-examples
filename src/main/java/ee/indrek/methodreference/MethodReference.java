package ee.indrek.methodreference;

import ee.indrek.behavior.example.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntSupplier;

public class MethodReference {

    private List<Book> books;

    public static void main(String[] args) {
        MethodReference methodReference = new MethodReference();
        methodReference.run();
    }

    private void run() {
        books = new ArrayList<>();
        books.add(new Book("All Quiet on the Western Front", 295, "Erich Maria Remarque"));

        IntSupplier bookLength = books::size;
        System.out.println(bookLength.getAsInt());
    }
}
