package ee.indrek.behavior.example;

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
