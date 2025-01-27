class Casino{

    public static void main(String[] args){
        Bank b = new Bank();
        Spieler s = new Spieler();
        Spiel poker = new Poker();
        Spiel kniffel = new Kniffel();
        Spiel roulette = new Roulette();
        Spiel slots = new WildeWalzen();
        Spiel pferderennen = new Pferderennen();
        Spiel bj = new Blackjack();
        Spiel boxen = new Boxautomat();
        Spiel[] spiele = {null, null, poker,boxen,bj,kniffel,slots,roulette,pferderennen};
        s.spielen(spiele,b);
    }

}
