import game.Game;
import lib.gameLoop.GameLoop;

public class Mediator {
    Mediator() {
        this.game = Mediator.createGame();
        this.gameLoop = Mediator.createGameLoop(this.game);
    }

    void startGame() {
        this.showWindow();
        this.startGameLoop();
    }

    private void startGameLoop() {
        this.gameLoop.start();
    }

    private void showWindow() {
        this.game.showWindow();
    }

    private static Game createGame() {
        return new Game();
    }

    private static GameLoop createGameLoop(Game game) {
        return new GameLoop(game);
    }

    private Game game;
    private GameLoop gameLoop;
}
