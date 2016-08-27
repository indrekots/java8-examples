package ee.indrek.behavior.example;

import ee.indrek.domain.Book;

public interface BookPredicate {
    boolean test(Book book);
}
