package ee.indrek.traderstransactions;

import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class Runner {

    public static void main(String[] args) {
        List<Transaction> transactions = createTransactions();

        System.out.println(transactionsOfYear2011(transactions));
        System.out.println(findDistinctCities(transactions));
        System.out.println(findCambridgeTraders(transactions));
        System.out.println(findTradersNames(transactions));
        System.out.println(areAnyTraderBasedInMilan(transactions));
    }

    private static boolean areAnyTraderBasedInMilan(List<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> "Milan".equals(t.getCity()))
                .findAny().isPresent();
    }

    private static List<String> findTradersNames(List<Transaction> transactions) {
        return transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .collect(toList());
    }

    private static List<Trader> findCambridgeTraders(List<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> "Cambridge".equals(t.getCity()))
                .sorted(comparing(Trader::getName))
                .distinct()
                .collect(toList());
    }

    private static List<String> findDistinctCities(List<Transaction> transactions) {
        return transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct().collect(toList());
    }

    private static List<Transaction> transactionsOfYear2011(List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(toList());
    }

    private static List<Transaction> createTransactions() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        return Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }

}
