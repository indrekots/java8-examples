package ee.indrek.streams;

import ee.indrek.domain.Book;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Create {
    public static void main(String[] args) throws IOException {
        //create a stream from a list
        List<Book> library = new ArrayList<>();
        library.add(new Book("Alice's Adventures in Wonderland", 300, "Lewis Carrol"));
        library.add(new Book("Through the Looking-Glass, and What Alice Found There", 228, "Lewis Carrol"));
        library.add(new Book("The War of the Worlds", 192, "H.G. Wells"));
        library.add(new Book("1984", 268, "George Orwell"));
        library.add(new Book("Animal Farm", 102, "George Orwell"));
        library.add(new Book("The Neverending Story", 396, "Michael Ende"));
        Stream<Book> bookStream = library.stream();

        //create a stream from an array
        String[] names = {"Lewis Carrol", "H.G. Wells", "Michael Ende"};
        Stream<String> stream = Arrays.stream(names);

        //create a stream from values
        Stream<String> stream2 = Stream.of("Lewis Carrol", "H.G. Wells", "Michael Ende");

        //create a stream from a file
        Stream<String> lines = Files.lines(Paths.get("/tmp/data"), Charset.defaultCharset());

        //create stream with iterate
        Stream<Integer> evenNumbers = Stream.iterate(0, n -> n + 2);

        //create a stream with generate
        Stream<Double> randomNumbers = Stream.generate(Math::random);

    }
}
