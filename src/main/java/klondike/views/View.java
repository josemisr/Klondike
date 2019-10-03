package klondike.views;

import klondike.controllers.MovementController;

public abstract class View {

    protected MovementController movementController;

    public View(MovementController movementController) {
        this.movementController = movementController;
    }

    public void interact() {
        boolean resume;
        do {
            this.start();
            boolean finished;
            do {
                this.move();
                finished = movementController.isGameFinished();
            } while (!finished);
            resume = this.resume();
            if (resume) movementController.resume();
        } while (resume);
    }

    protected abstract void start();

    protected abstract void move();

    protected abstract boolean resume();
}
