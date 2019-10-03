package klondike;

import klondike.controllers.MovementController;
import klondike.models.Game;
import klondike.views.View;
import klondike.views.console.ConsoleView;

public class Klondike {

    private final MovementController movementController;

    private View view;
    private Game game;

    private Klondike() {
        this.game = new Game();
        this.movementController = new MovementController(this.game);
        this.movementController.resume();
        this.view = new ConsoleView(movementController);
    }

    public static void main(String[] args) {
        new Klondike().play();
    }

    public void play() {
        view.interact();
    }
}