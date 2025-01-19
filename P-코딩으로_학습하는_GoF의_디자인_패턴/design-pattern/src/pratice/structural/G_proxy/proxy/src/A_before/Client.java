package A_before;

import B_after.DefaultGameService;
import B_after.GameServiceProxy;
import B_after.GameService;

public class Client {
    public static void main(String[] args) throws InterruptedException {
//        GameService gameService = new GameServiceProxy();
//        gameService.gameStart();
        GameService gameService = new GameServiceProxy(new DefaultGameService());
        gameService.startGame();
    }
}
