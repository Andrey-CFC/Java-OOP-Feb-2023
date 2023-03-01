package L02WorkingWithAbstractionEx.P01CardSuit;

public class Main {
    public static void main(String[] args) {
        //всички изброени елементи в CardSuit
        //за всеки изброен елемент
        System.out.println("Card Suits:");
        CardSuit[] cardSuits = CardSuit.values();
        for (CardSuit cardSuit : cardSuits) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", cardSuit.ordinal(), cardSuit.toString());
        }
    }
}
