package org.example.command;

import org.example.exceeption.WrongArgumentException;
import org.example.system.Reciever;

public class RemoveAtIndex implements BaseCommand{
    @Override
    public String execute(String[] args) throws Exception {
        if (args.length == 2){
            Reciever.removeAtIndex(args[1]);
        } else throw new WrongArgumentException();
        return null;
    }

    @Override
    public String getName() {
        return "remove_at_index";
    }

    @Override
    public String getDescription() {
        return "remove_at_index_worker";
    }
}
