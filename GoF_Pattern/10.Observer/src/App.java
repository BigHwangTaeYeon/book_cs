public class App {
    public static void main(String[] args) throws Exception {
        DiceGame diceGame = new FairDiceGame();
        
        Player player1 = new EvenBettingPlayer("짝궁댕이");
        Player player2 = new OddBettingPlayer("홀아비");
        Player player3 = new OddBettingPlayer("헐쯕ㅇ;");

        diceGame.addPlayer(player1);
        diceGame.addPlayer(player2);
        diceGame.addPlayer(player3);

        for (int i = 0; i < 5; i++) {
            diceGame.play();
            System.out.println();
        }
    }
}
