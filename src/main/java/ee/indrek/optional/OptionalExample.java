package ee.indrek.optional;

import ee.indrek.behavior.example.Book;

import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {
        Optional<Book> book = findBook("The War of the Worlds");
        Book b = book.get();
    }

    private static Optional<Book> findBook(String title) {
        return null;
    }
}
