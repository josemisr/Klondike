package klondike.views.console;

import klondike.controllers.MovementController;
import klondike.utils.YesNoDialog;
import klondike.views.View;
import klondike.views.console.menu.PlayMenu;

public class ConsoleView extends View {

    private PlayMenu playMenu;

    public ConsoleView( MovementController movementController) {
        super( movementController);
        this.playMenu = new PlayMenu(this.movementController);
    }

    @Override
    protected void start() {
        new GameView(this.movementController).writeln();
    }

    @Override
    protected void move() {
        this.playMenu.execute();
        new GameView(this.movementController).writeln();
    }

    @Override
    protected boolean resume() {
        return new YesNoDialog().read(Message.RESUME);
    }
}
