package B_after;

public class GameServiceProxy implements GameService{
    private GameService gameService;

    @Override
    public void startGame() {
        if(this.gameService == null) {
            this.gameService = new DefaultGameService();
        }

        long start = System.currentTimeMillis();
        gameService.startGame();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
