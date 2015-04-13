package ee.indrek.lambda;

@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}
