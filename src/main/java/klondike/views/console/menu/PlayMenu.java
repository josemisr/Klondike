package klondike.views.console.menu;

import klondike.controllers.MovementController;
import klondike.utils.Menu;

public class PlayMenu extends Menu {

    public PlayMenu(MovementController movementController) {
        this.addCommand(new Movement(movementController,CommandTitle.STOCK2WASTE_COMMAND));
        this.addCommand(new Movement(movementController,CommandTitle.WASTE2STOCK_COMMAND));
        this.addCommand(new Movement(movementController,CommandTitle.WASTE2FOUNDATION_COMMAND));
        this.addCommand(new Movement(movementController,CommandTitle.WASTE2PILE_COMMAND));
        this.addCommand(new Movement(movementController,CommandTitle.FOUNDATION2PILE_COMMAND));
        this.addCommand(new Movement(movementController,CommandTitle.PILE2FOUNDATION_COMMAND));
        this.addCommand(new Movement(movementController,CommandTitle.PILE2PILE_COMMAND));
    }

}
