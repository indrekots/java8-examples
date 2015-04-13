package ee.indrek.lambda;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class FunctionalInterfaceExample {

    public static List<String> veggies = asList("Arugula", "Celery", "Dill", "Kale", "Spinach");
    public static List<String> fruits = asList("Apple", "Guava", "Jackfruit", "Orange", "Pear");

    public static void main(String[] args) {
        List<String> uppercaseVeggies = convertList(veggies, str -> str.toUpperCase());
        System.out.println(uppercaseVeggies);

        //in the previous example, it would be even better to use a method reference instead of a
        // lambda expression
        List<String> uppercaseFruits = convertList(fruits, String::toUpperCase);
        System.out.println(uppercaseFruits);
    }

    public static List<String> convertList(List<String> list, Converter<String, String> converter) {
        List<String> newList = new ArrayList<>();
        for (String s : list) {
            newList.add(converter.convert(s));
        }
        return newList;
    }
}
