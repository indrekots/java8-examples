package ee.indrek.behavior.example;

import ee.indrek.domain.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
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

    public static List<Book> filterLongBooks(List<Book> books) {
        return books.stream().
                filter(b -> b.getPageCount() > 500).
                collect(toList());
    }

    public static Map<String, List<Book>> groupBooksByAuthor(List<Book> books) {
          return books.stream().collect(groupingBy(Book::getAuthor));
    }

    public static Map<Boolean, List<Book>> partitionBooksByLength(List<Book> books) {
        return books.stream().collect(Collectors.partitioningBy(b -> b.getPageCount() > 500));
    }
}
