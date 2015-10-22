package ee.indrek.behavior.example;

import java.util.ArrayList;
import java.util.List;

public class BookFilterRunner {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Moby Dick", 250, "Herman Melville"));
        books.add(new Book("Alice's Adventures in Wonderland", 190, "Lewis Carrol"));
        books.add(new Book("Sylvie and Bruno", 400, "Lewis Carrol"));

        System.out.println(findLongNovels(books));
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
}
