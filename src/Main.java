import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{ //about game, check amount of money, age, etc
        Scanner scanner = new Scanner(System.in);
        String wantContinuePlaying = "y";

        System.out.print("welcome to blackjack! what is your name? ");
        String name = scanner.nextLine();

        Deck d = new Deck();

        while(wantContinuePlaying.equals("y")) {
            System.out.println("NEW GAME");

            if(d.getLength() < 10) //You should continue playing with the same deck.
                // Introduce a new deck if less than 10 cards are left in a deck of cards.
                d.resetDeck();

            Player player = new Player();
            Dealer dealer = new Dealer();

            int stand = 0; //this variable counts how many times player and dealer stand,
            // if it reaches 2 that means they both chose to stand and the game ends
            int round = 1;

            System.out.println("deck: " + d); //average deck
            d.shuffle();
            System.out.println("shuffled deck: " + d);
            System.out.print("\n");

            player.draw(d.dealACard());
            player.draw(d.dealACard());

            dealer.draw(d.dealACard());
            dealer.draw(d.dealACard());

            while(player.getTotal() <= 21 && dealer.getTotal() <= 21 && stand < 2) {
                System.out.println("ROUND " + round);
                stand = 0;

                player.showHands();
                player.displayTotal(player.getTotalAceAs11(), player.getTotal());

                dealer.showHands();

                System.out.println("current deck: " + d);
                System.out.print("\n");

                //player's turn
                if(player.choseHit())
                    player.draw(d.dealACard());
                else
                    stand ++;

                //dealer's turn
                if(dealer.choseHit()) {
                    dealer.draw(d.dealACard());
                    System.out.println("the dealer is choosing to hit...");
                }
                else {
                    stand++;
                    System.out.println("the dealer is choosing to stand...");
                }

                System.out.print("\n");

                round ++;
            }
            System.out.println("THE GAME IS OVER");

            //showing dealer's & player's cards & cards total
            System.out.println("dealer...");
            dealer.showAllHands();
            dealer.displayTotal(dealer.getTotalAceAs11(), dealer.getTotal());

            System.out.print("\n");

            System.out.println("you...");
            player.showHands();
            player.displayTotal(player.getTotalAceAs11(), player.getTotal());

            System.out.print("\n");

            //deciding winner
            int dT = dealer.getTotal();
            int pT = player.getTotal();
            int dTA = dealer.getTotalAceAs11();
            int pTA = player.getTotalAceAs11();

            if (dT > 21 && pT <= 21 || dT < pT && pT <= 21 || dTA < pTA && pTA <=21 || dTA < pT && pT <=21)
                System.out.println("the winner is you! congrats.");
            else if (pT == dT || pTA == dTA || pTA == dT || pT == dTA)
                System.out.println("it's a tie!");
            else
                System.out.println("the winner is the dealer! better luck next time.");

            Joke.nextJoke();

            //ask if player wants to  play again
            System.out.print("thanks for playing " + name + ", would you like to play again? (y/n): ");
            wantContinuePlaying = scanner.nextLine();
        }
    }
}