package B_after;

public class Client {
    public static void main(String[] args) {
        Game game = new Game();
        game.setBlueTeamScore(10);
        game.setRedTeamScore(20);

        GameSave gameSave = game.save();
        game.setRedTeamScore(100);
        game.setBlueTeamScore(30329);
        game.restore(gameSave);

        System.out.println("game = " + game.getBlueTeamScore());
        System.out.println("game = " + game.getRedTeamScore());
    }
}
