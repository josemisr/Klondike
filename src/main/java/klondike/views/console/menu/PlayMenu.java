package klondike.views.console.menu;

import klondike.controllers.MoveController;
import klondike.utils.Menu;

public class PlayMenu extends Menu {

    public PlayMenu(MoveController moveController) {
        this.addCommand(new Movement(moveController,CommandTitle.STOCK2WASTE_COMMAND));
        this.addCommand(new Movement(moveController,CommandTitle.WASTE2STOCK_COMMAND));
        this.addCommand(new Movement(moveController,CommandTitle.WASTE2FOUNDATION_COMMAND));
        this.addCommand(new Movement(moveController,CommandTitle.WASTE2PILE_COMMAND));
        this.addCommand(new Movement(moveController,CommandTitle.FOUNDATION2PILE_COMMAND));
        this.addCommand(new Movement(moveController,CommandTitle.PILE2FOUNDATION_COMMAND));
        this.addCommand(new Movement(moveController,CommandTitle.PILE2PILE_COMMAND));
    }

}
