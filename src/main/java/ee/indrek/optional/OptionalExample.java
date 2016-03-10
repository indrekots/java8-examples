package ee.indrek.optional;

import ee.indrek.behavior.example.Book;
import ee.indrek.domain.Publisher;

import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {
        Optional<Book> empty = Optional.empty();
        Optional<Book> optional = Optional.of(new Book());

        Optional<Book> bookOptional = findBook("The War of the Worlds");
        Book b1 = bookOptional.get();
        Book b2 = bookOptional.orElse(new Book());
        Book b3 = bookOptional.orElseGet(Book::defaultBook);
        String name = Optional.of(new Book()).map(Book::getName).orElse("Name not provided");
        String publisher = bookOptional.map(Book::getPublisher).map(Publisher::getName).orElse("Unknown publisher");
    }

    private static Optional<Book> findBook(String title) {
        return Optional.empty();
    }
}
