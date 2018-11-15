package lib.gameLoop;

public class GameLoop {
    public GameLoop(GameMediator gameMediator) {
        this.gameMediator = gameMediator;
    }

    public void start() {
        if (this.isRunning) return;

        this.setParams();
        this.setIsRunning(true);

        while (this.isRunning)
            this.processTick();
    }

    public void stop() {
        this.setIsRunning(false);
    }

    private void processTick() {
        this.updateTicksDurationDeltas();
        this.updateLastTickStartTime();

        while (this.ticksDurationDeltas >= 1) {
            this.updateGameView();

            --this.ticksDurationDeltas;
        }

        this.renderGameView();
    }

    private void updateGameView() {
        this.gameMediator.updateGameView();
    }

    private void renderGameView() {
        this.gameMediator.renderGameView();
    }

    private void updateLastTickStartTime() {
        this.lastTickStartTime = GameLoop.getNanoTime();
    }

    private void updateTicksDurationDeltas() {
        double lastTickDurationDelta = this.getLastTickDurationDelta();

        this.ticksDurationDeltas += lastTickDurationDelta;
    }

    private double getLastTickDurationDelta() {
        double aimTickDuration = GameLoop.getAimTickDuration();
        long lastTickDuration = this.getLastTickDuration();

        return lastTickDuration / aimTickDuration;
    }

    private long getLastTickDuration() {
        long now = GameLoop.getNanoTime();

        return now - this.lastTickStartTime;
    }

    private void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    private void setParams() {
        this.ticksDurationDeltas = 0;
        this.lastTickStartTime = GameLoop.getNanoTime();
    }

    private static double getAimTickDuration() {
        return 1e9 / GameLoop.FPS;
    }

    private static long getNanoTime() {
        return System.nanoTime();
    }

    private GameMediator gameMediator;

    private boolean isRunning = false;

    private long lastTickStartTime = 0;
    private double ticksDurationDeltas = 0;

    private static final double FPS = 60.0;
}
