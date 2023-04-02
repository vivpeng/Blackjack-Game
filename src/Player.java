import java.util.Scanner;

class Player{ //has cards and takes one by one
    Scanner scanner = new Scanner(System.in);
    private int[] hands = new int[10]; //the sum will 100% be over or equal to 21 at 10 or fewer cards
    private int numOfCards; //keeps track of cards player has
    private boolean donePlayingTurn; //indicates if player is done hitting, so we don't ask them again

    public Player(){
        numOfCards = 0;
        for(int i = 0; i < 10; i++)
            hands[i] = -1;
    }
    public boolean choseHit(){
        //ask user if they want to hit or stand
        if(!donePlayingTurn) {
            System.out.print("hit or stand? (hit/stand): ");
            if (scanner.nextLine().equals("stand")) {
                donePlayingTurn = true;
                return false;
            }
            return true;
        }
        return false;
    }
    public void draw (int c){
        hands[numOfCards] = c;
        numOfCards ++;
    }
    public void showHands(){
        String returnString = "";
        for(int i = 0; i < numOfCards; i++)
            returnString += Deck.cardToString(hands[i]) + " ";
        System.out.println("hand: " + returnString);
    }
    public int getTotal(){
        int total = 0;
        for(int i = 0; i < numOfCards; i++) {
            int remainder = hands[i] % 13;
            int value;
            if (remainder == 0 || remainder == 11 || remainder == 12)
                value = 10;
            else
                value = remainder;

            total += value;
        }
        return total;
    }

    public int getTotalAceAs11() {
        int total = 0;
        for(int i = 0; i < numOfCards; i++) {
            int remainder = hands[i] % 13;
            int value;
            if (remainder == 0 || remainder == 11 || remainder == 12)
                value = 10;
            else if (remainder == 1) //calculates OTHER value if there is an ACE
                value = 11;
            else
                value = remainder;

            total += value;
        }
        return total;
    }

    public void displayTotal(int tA, int t) {
        if(tA <= 21 && t != tA)
            System.out.println("the total of the cards is: " + t + " or " + tA);
        else
            System.out.println("the total of the cards is: " + t);
    }

    public int getNumOfCards() {
        return numOfCards;
    }

    public int[] getHands() {
        return hands;
    }

    public boolean getDonePlayingTurn() {
        return donePlayingTurn;
    }
}

