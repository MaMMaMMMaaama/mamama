package org.example.command;

import org.example.exceeption.NoElementException;
import org.example.exceeption.WrongArgumentException;
import org.example.system.Receiver;

public class RemoveCommand implements BaseCommand{
    @Override
    public String execute(String[] args) throws WrongArgumentException, NoElementException {
        if (args.length == 2){
            Receiver.removeById(args[1]);
        } else throw new WrongArgumentException();
        return null;
    }

    @Override
    public String getName() {
        return "remove";
    }

    @Override
    public String getDescription() {
        return "remove collection";
    }
}
