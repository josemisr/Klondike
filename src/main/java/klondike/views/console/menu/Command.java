package klondike.views.console.menu;

import klondike.controllers.MovementController;
import klondike.models.Error;
import klondike.utils.IO;

public abstract class Command extends klondike.utils.Command {

    protected MovementController movementController;

    protected Command(String title, MovementController movementController) {
        super(title);
        this.movementController = movementController;
    }

    @Override
    protected void execute() {
        Error error = this.move();
        if (error != null) {
            IO.writeError(Message.INVALID_MOVE, error.getMessage());
        }
    }

    protected abstract Error move();
}
