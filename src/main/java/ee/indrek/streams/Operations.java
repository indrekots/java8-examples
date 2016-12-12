package ee.indrek.streams;

import ee.indrek.domain.Book;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Operations {
    public static void main(String[] args) throws IOException {
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

        String reduce = library.stream().reduce("", (s, b) -> s + " " + b.getName(), (a, b) -> a + " " + b);
        System.out.println(reduce);

        String s = library.stream().map(Book::getName).reduce("", (a, b) -> a + " " + b);
        System.out.println(s);

        library.stream().filter(b -> b.getPageCount() > 300).forEach(System.out::println);

        Arrays.asList(1, 4, 2, 1, 1, 2, 6).stream().distinct().forEach(System.out::println);
        Arrays.asList(1, 2, 3, 4, 5, 6).stream().limit(3).forEach(System.out::println);

        Stream<Path> list = Files.list(Paths.get("/home/indrek"));
        list.forEach(System.out::println);
    }
}
