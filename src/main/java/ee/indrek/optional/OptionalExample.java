package ee.indrek.optional;

import ee.indrek.domain.Book;
import ee.indrek.domain.Publisher;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class OptionalExample {

    public static void main(String[] args) {
        Optional<Book> empty = Optional.empty();
        Optional<Book> optional = Optional.of(bookWithPublisher());

        Optional<Book> bookOptional = findBook("The War of the Worlds");
        //Book b1 = bookOptional.get();
        Book b2 = bookOptional.orElse(new Book());
        Book b3 = bookOptional.orElseGet(Book::defaultBook);
        String name = Optional.of(new Book()).map(Book::getName).orElse("Name not provided");

        String publisher = optional.map(Book::getPublisher).map(Publisher::getName).orElse("Unknown publisher");
        optional.ifPresent(System.out::println);

        Optional<Long> first = first(Optional::empty, () -> Optional.of(5L));
    }

    private static Book bookWithPublisher() {
        Book book = new Book();
        Publisher publisher = new Publisher("My Publisher");
        book.setPublisher(publisher);
        return book;
    }

    //@SafeVarargs
    public static <T> Optional<T> first(Supplier<Optional<T>>... suppliers) {
        return Arrays.asList(suppliers).stream()
                .map(Supplier::get)
                .flatMap(o -> o.map(Stream::of).orElseGet(Stream::empty))
                .findFirst();
    }

    private static Optional<Book> findBook(String title) {
        return Optional.empty();
    }
}
