package ee.indrek.behavior.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class BookLambdaRunner {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Moby Dick", 250, "Herman Melville"));
        books.add(new Book("Alice's Adventures in Wonderland", 190, "Lewis Carrol"));
        books.add(new Book("Sylvie and Bruno", 400, "Lewis Carrol"));

        System.out.println(filterBooks(books, book -> "Lewis Carrol".equals(book.getAuthor())));
        System.out.println(books.stream().filter(b -> "Lewis Carrol".equals(b.getAuthor())).collect(toList()));
        System.out.println(books.stream().filter(b -> b.getPageCount() > 200).collect(toList()));
    }

    public static List<Book> filterBooks(List<Book> books, Predicate<Book> p) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (p.test(book)) {
                result.add(book);
            }
        }
        return result;
    }
}
