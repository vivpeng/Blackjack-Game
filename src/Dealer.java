class Dealer extends Player{ //have methods that override player

    public Dealer() {

        super();
    }

    public boolean choseHit(){ //dealer follows rules of casino, < 16 or > 16 to hit or stand
        if(!getDonePlayingTurn())
            return getTotal() < 17;
        return false;
    }
    public void showHands(){
        String returnString = "";
        returnString += Deck.cardToString(getHands()[0]) + " ";
        for(int i = 1; i < getNumOfCards(); i++)
            returnString += "? ";
        System.out.println("dealer's cards: " + returnString);
    }
    public void showAllHands() {
        super.showHands();
    }

}
