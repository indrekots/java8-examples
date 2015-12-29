package ee.indrek.behavior.example;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static ch.lambdaj.Lambda.*;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.equalTo;

public class BookFilterRunner {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Moby Dick", 250, "Herman Melville"));
        books.add(new Book("Alice's Adventures in Wonderland", 190, "Lewis Carrol"));
        books.add(new Book("Sylvie and Bruno", 400, "Lewis Carrol"));

        System.out.println(findLongNovels(books));
        System.out.println(filterBooksByAuthor(books, "Lewis Carrol"));

        BookPredicate lengthPredicate = new LengthPredicate(200);
        BookPredicate authorPredicate = new AuthorPredicate("Lewis Carrol");
        System.out.println(filterBooks(books, lengthPredicate));
        System.out.println(filterBooks(books, authorPredicate));

        //example using an anonymous inner class
        System.out.println(filterBooks(books, new BookPredicate() {
            @Override
            public boolean test(Book book) {
                return "Lewis Carrol".equals(book.getAuthor());
            }
        }));

        //example using google guava
        System.out.println(Iterables.filter(books, new Predicate<Book>() {
            @Override
            public boolean apply(Book input) {
                return "Lewis Carrol".equals(input.getAuthor());
            }
        }));

        //example using lambdaj
        filter(having(on(Book.class).getAuthor(), equalTo("Lewis Carrol")), books);
    }

    public static List<Book> findLongNovels(List<Book> books) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getPageCount() > 200) {
                result.add(book);
            }
        }
        return result;
    }

    public static List<Book> filterBooksByAuthor(List<Book> books, String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (author.equals(book.getAuthor())) {
                result.add(book);
            }
        }
        return result;
    }

    public static List<Book> filterBooks(List<Book> books, BookPredicate p) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (p.test(book)) {
                result.add(book);
            }
        }
        return result;
    }

}
