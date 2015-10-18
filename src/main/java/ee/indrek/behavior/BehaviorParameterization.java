package ee.indrek.behavior;

import ee.indrek.domain.Apple;

import java.util.ArrayList;
import java.util.List;

public class BehaviorParameterization {

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple("Green", 140));
        apples.add(new Apple("Red", 80));

        prettyPrintApples(apples, new SimpleApplePrinter());
    }

    public static void prettyPrintApples(List<Apple> inventory, ApplePrinter p) {
        for (Apple a : inventory) {
            System.out.println(p.output(a));
        }
    }

}
