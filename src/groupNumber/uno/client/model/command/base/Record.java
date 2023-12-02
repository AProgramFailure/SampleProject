package groupNumber.uno.client.model.command.base;

import groupNumber.uno.client.model.command.contract.Command;

public abstract class Record<T, V> implements Command<T, V> {

    protected T command;

    protected V value;

    public Record(T command){
        this.command = command;
    }
    public Record(T command, V value){
        this.command = command;
        this.value = value;
    };
}
