package ee.indrek.streams;

import ee.indrek.domain.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class Comparison {
    public static void main(String[] args) {
        //initialize a library of books
        List<Book> library = new ArrayList<>();
        library.add(new Book("Alice's Adventures in Wonderland", 300, "Lewis Carrol"));
        library.add(new Book("Through the Looking-Glass, and What Alice Found There", 228, "Lewis Carrol"));
        library.add(new Book("The War of the Worlds", 192, "H.G. Wells"));
        library.add(new Book("1984", 268, "George Orwell"));
        library.add(new Book("Animal Farm", 102, "George Orwell"));
        library.add(new Book("The Neverending Story", 396, "Michael Ende"));

        //group books by author using Java 7
        Map<String, List<Book>> byAuthor = new HashMap<>();
        for (Book book : library) {
            if (byAuthor.get(book.getAuthor()) == null) {
                List<Book> books = new ArrayList<>();
                books.add(book);
                byAuthor.put(book.getAuthor(), books);
            }
            else {
                List<Book> books = byAuthor.get(book.getAuthor());
                books.add(book);
            }
        }

        System.out.println(byAuthor);

        //group books by author using Java 8 Streams API
        Map<String, List<Book>> byAuthor2 = library.stream().
                collect(groupingBy(Book::getAuthor));

        System.out.println(byAuthor2);
    }
}
