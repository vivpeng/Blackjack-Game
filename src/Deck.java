class Deck { //about cards, holds cards and gives away
    private int[] cards = new int[52];
    private int numCards; //keeps tracks of number of cards, -1 when a card is drawn from

    public Deck(){
        for(int i = 0; i < 52; i++)
            cards[i] = i;

        numCards = 52;
    }

    public int dealACard(){ //gives card to player, doesn't give deck to player
        numCards --;
        return cards[numCards];
    }
    public void shuffle (){ //shuffles cards
        int placeholder, randomIndex;

        for(int i = 0; i < 52; i++) {
            randomIndex = (int)(Math.random()*52);
            placeholder = cards[i];
            cards[i] = cards[randomIndex];
            cards[randomIndex] = placeholder;
        }
    }
    public String toString(){ //when displaying deck
        String returnString = "" ;
        for (int i = 0; i < numCards; i++)
            returnString += cardToString(cards[i]) + " ";

        return returnString;
    }
    public static String cardToString(int c){
        String suit, value = "";
        int suitNum = c / 13;
        if(suitNum == 0)
            suit = "♥";
        else if(suitNum ==1)
            suit = "♦";
        else if(suitNum ==2)
            suit = "♠";
        else
            suit = "♣";

        int intValue = c % 13;
        if (intValue == 11)
            value = "J";
        else if(intValue == 12)
            value = "Q";
        else if(intValue == 0)
            value = "K";
        else if(intValue == 1)
            value = "A";
        else
            value += intValue;

        return value + suit;
    }
    //public static int cardToValue(int c){...} //gives back value of cards

    public int getLength() {
        return numCards;
    }

    public void resetDeck() {
        numCards = 52;

        for(int i = 0; i < 52; i++)
            cards[i] = i;
    }
}
