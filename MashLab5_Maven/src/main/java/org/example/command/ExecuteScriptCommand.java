package org.example.command;

import org.example.exceeption.NoElementException;
import org.example.exceeption.RootException;
import org.example.exceeption.WrongArgumentException;
import org.example.system.Receiver;

import java.io.IOException;

public class ExecuteScriptCommand implements BaseCommand{
    @Override
    public String execute(String[] args) throws Exception {
        if (args.length == 2){
            Receiver.executeScript(args[1]);
        } else throw new WrongArgumentException();
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }
}
