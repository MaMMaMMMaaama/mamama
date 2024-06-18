package org.example.command;

import org.example.exceeption.WrongArgumentException;
import org.example.system.Reciever;

public class InsertCommand implements BaseCommand{

    @Override
    public String execute(String[] args) throws Exception {
        if (args.length == 2){
            Reciever.insertWorker(args[1],null);
        } else throw new WrongArgumentException();
        return null;
    }

    @Override
    public String getName() {
        return "insert";
    }

    @Override
    public String getDescription() {
        return "insertWorker";
    }
}
