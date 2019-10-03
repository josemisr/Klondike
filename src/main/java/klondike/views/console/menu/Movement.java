package klondike.views.console.menu;

import klondike.controllers.MoveController;
import klondike.models.Error;
import klondike.models.Suit;
import klondike.utils.ClosedInterval;
import klondike.utils.IO;

public class Movement extends Command{

    CommandTitle command;

    public Movement(MoveController moveController, CommandTitle command )  {
        super(command.getTitle(), moveController);
        this.command=command;
    }

    @Override
    protected Error move() {
        int pileIndex;
        Suit suit;
        switch(this.command) {
            case FOUNDATION2PILE_COMMAND:
                suit = SuitReader.read();
                pileIndex = PileReader.readIndex(Message.DESTINATION);
                return this.moveController.moveFromFoundationToPile(suit, pileIndex);
            case PILE2FOUNDATION_COMMAND:
                pileIndex = PileReader.readIndex(Message.ORIGIN);
                suit = SuitReader.read();
                return this.moveController.moveFromPileToFoundation(pileIndex, suit);
            case PILE2PILE_COMMAND:
                int originIndex = PileReader.readIndex(Message.ORIGIN);
                int destinationIndex = PileReader.readIndex(Message.DESTINATION);
                int numberOfCards = IO.readInt(Message.READ_NUMBER_OF_CARDS, new ClosedInterval(1, 13));
                return this.moveController.moveFromPileToPile(originIndex, destinationIndex, numberOfCards);
            case STOCK2WASTE_COMMAND:
                return this.moveController.moveFromStockToWaste();
            case WASTE2FOUNDATION_COMMAND:
                suit = SuitReader.read();
                return this.moveController.moveFromWasteToFoundation(suit);
            case WASTE2PILE_COMMAND:
                pileIndex = PileReader.readIndex(Message.DESTINATION);
                return this.moveController.moveFromWasteToPile(pileIndex);
            case WASTE2STOCK_COMMAND:
                return this.moveController.moveFromWasteToStock();
            default:
                return null;
        }
    }
}
