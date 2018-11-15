import lib.gameLoop.GameMediator;
import window.Window;

public class Mediator implements GameMediator {
    Mediator() {
        this.window = new Window();
    }

    void startGame() {
        this.window.show();
    }

    public void updateGameView() {
        System.out.println("update");
    }

    public void renderGameView() {
        System.out.println("render");
    }

    private Window window;
}
