package ee.indrek.streams;

import ee.indrek.domain.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Operations {
    public static void main(String[] args) {
        List<Book> library = new ArrayList<>();
        library.add(new Book("Alice's Adventures in Wonderland", 300, "Lewis Carrol"));
        library.add(new Book("Through the Looking-Glass, and What Alice Found There", 228, "Lewis Carrol"));
        library.add(new Book("The War of the Worlds", 192, "H.G. Wells"));
        library.add(new Book("1984", 268, "George Orwell"));
        library.add(new Book("Animal Farm", 102, "George Orwell"));
        library.add(new Book("The Neverending Story", 396, "Michael Ende"));

        library.stream().map(Book::getName).forEach(System.out::println);

        String[] books = {"Alice's Adventures in Wonderland", "1984", "The Neverending Story"};
        Optional<String> result = Arrays.stream(books).reduce((a, b) -> a + " " + b);
        result.ifPresent(System.out::println);
    }
}
