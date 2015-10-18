package ee.indrek.behavior;

import ee.indrek.domain.Apple;

public class SimpleApplePrinter implements ApplePrinter{

    @Override
    public String output(Apple apple) {
        return "Color: " + apple.getColor() + " Weight: " + apple.getWeight();
    }
}
