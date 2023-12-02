package groupNumber.uno.client.model.command;

import groupNumber.uno.client.model.card.Card;
import groupNumber.uno.client.model.command.base.Record;

public class CommandRecord extends Record<String,Card> {
    public CommandRecord(String command, Card value) {
        super(command, value);
    }

    public CommandRecord(String command){
        super(command);
    }

    @Override
    public String getCommand() {
        return this.command;
    }

    @Override
    public Card getRecord() {
        return this.value;
    }
}
