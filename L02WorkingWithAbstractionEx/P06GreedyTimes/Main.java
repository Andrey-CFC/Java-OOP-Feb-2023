package L02WorkingWithAbstractionEx.P06GreedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long capacity = Long.parseLong(scanner.nextLine());
        String[] pairs = scanner.nextLine().split("\\s+");

        Map<String, Map<String, Long>> bag = new LinkedHashMap<>();
        long gold = 0;
        long gems = 0;
        long money = 0;

        for (int i = 0; i < pairs.length; i += 2) {
            String itemName = pairs[i];
            long amount = Long.parseLong(pairs[i + 1]);

            String item = "";

            if (itemName.length() == 3) {
                item = "Cash";
            } else if (itemName.toLowerCase().endsWith("gem")) {
                item = "Gem";
            } else if (itemName.toLowerCase().equals("gold")) {
                item = "Gold";
            }

            if (item.equals("")) {
                continue;
            } else if (capacity < bag.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + amount) {
                continue;
            }

            switch (item) {
                case "Gem":
                    if (!bag.containsKey(item)) {
                        if (bag.containsKey("Gold")) {
                            if (amount > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(item).values().stream().mapToLong(e -> e).sum() + amount > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!bag.containsKey(item)) {
                        if (bag.containsKey("Gem")) {
                            if (amount > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(item).values().stream().mapToLong(e -> e).sum() + amount > bag.get("Gem").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
            }

            if (!bag.containsKey(item)) {
                bag.put((item), new LinkedHashMap<>());
            }

            if (!bag.get(item).containsKey(itemName)) {
                bag.get(item).put(itemName, 0L);
            }


            bag.get(item).put(itemName, bag.get(item).get(itemName) + amount);
            if (item.equals("Gold")) {
                gold += amount;
            } else if (item.equals("Gem")) {
                gems += amount;
            } else if (item.equals("Cash")) {
                money += amount;
            }
        }

        for (Map.Entry<String, Map<String, Long>> item : bag.entrySet()) {
            Long sumValues = item.getValue().values().stream().mapToLong(l -> l).sum();
            System.out.println(String.format("<%s> $%s", item.getKey(), sumValues));
            item.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));
        }
    }
}
