import lib.gameLoop.GameMediator;

public class Mediator implements GameMediator {
    public void update() {
        System.out.println("update");
    }

    public void render() {
        System.out.println("render");
    }
}
