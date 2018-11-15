import lib.gameLoop.GameLoop;

public class Main {
    public static void main(String[] args) {
        Mediator mediator = new Mediator();
        GameLoop gameLoop = new GameLoop(mediator);

        gameLoop.start();
    }
}
