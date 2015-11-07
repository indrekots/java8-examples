package ee.indrek.behavior.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

public class ComparatorRunner {

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Moby Dick", 250, "Herman Melville"));
        books.add(new Book("Alice's Adventures in Wonderland", 190, "Lewis Carrol"));
        books.add(new Book("Sylvie and Bruno", 400, "Lewis Carrol"));

        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getAuthor().compareTo(o2.getAuthor());
            }
        });

        books.sort((o1, o2) -> o1.getAuthor().compareTo(o2.getAuthor()));
        books.sort(comparing(Book::getAuthor));

        System.out.println(books);
    }

}
