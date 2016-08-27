package ee.indrek.behavior.example;

import ee.indrek.domain.Book;

public class AuthorPredicate implements BookPredicate {
    private String author;

    public AuthorPredicate(String author) {
        this.author = author;
    }

    @Override
    public boolean test(Book book) {
        return author.equals(book.getAuthor());
    }
}
