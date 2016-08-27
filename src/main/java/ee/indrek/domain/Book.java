package ee.indrek.domain;

public class Book {
    private String name;
    private int pageCount;
    private String author;
    private Publisher publisher;

    public Book(String name, int pageCount, String author) {
        this.name = name;
        this.pageCount = pageCount;
        this.author = author;
    }

    public Book(String name) {
        this.name = name;
    }

    public Book() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, page count: %d, author: %s", name, pageCount, author);
    }

    public static Book defaultBook() {
        return new Book();
    }
}
