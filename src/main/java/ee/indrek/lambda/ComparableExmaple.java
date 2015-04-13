package ee.indrek.lambda;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.asList;

public class ComparableExmaple {

    public static List<String> veggies = asList("Arugula", "Celery", "Dill", "Kale", "Spinach");
    public static List<String> fruits = asList("Apple", "Guava", "Jackfruit", "Orange", "Pear");

    public static void main(String[] args) {
        //Instead of an anonymous inner class, lambda expression can be used
        Collections.sort(veggies, (o1, o2) -> ((Integer) o1.length()).compareTo(o2.length()));
        System.out.println(veggies);

        //Java 8 introduces default methods in interfaces.
        // The List interface now has a sort method, so instead of using Collections.sort(),
        //sort can be called directly on the list in question
        fruits.sort(Comparator.reverseOrder());
        System.out.println(fruits);
    }
}
