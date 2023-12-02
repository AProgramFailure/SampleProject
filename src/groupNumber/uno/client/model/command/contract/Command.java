package groupNumber.uno.client.model.command.contract;

public interface Command<TypeCommand, TypeRecord> {

    TypeCommand getCommand();

    TypeRecord getRecord();
}
