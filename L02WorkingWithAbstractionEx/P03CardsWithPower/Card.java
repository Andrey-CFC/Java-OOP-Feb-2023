package L02WorkingWithAbstractionEx.P03CardsWithPower;

public class Card {
    //боя
    private CardSuits cardSuit;
    //ст-ст
    private CardRanks cardRank;
    //сила = боя + ст-ст
    private int power;

    public Card(CardSuits cardSuit, CardRanks cardRank) {
        this.cardSuit = cardSuit;
        this.cardRank = cardRank;

    }

    public CardSuits getCardSuit() {
        return cardSuit;
    }

    public void setCardSuits(CardSuits cardSuit) {
        this.cardSuit = cardSuit;
    }

    public CardRanks getCardRank() {
        return cardRank;
    }

    public void setCardRank(CardRanks cardRank) {
        this.cardRank = cardRank;
    }

    public int getPower() {

//сбор на боя + ст-ст
        return this.cardSuit.getSuitPower() + this.cardRank.getPowerRank();
    }

    public void setPower(int power) {
        this.power = power;
    }
}
