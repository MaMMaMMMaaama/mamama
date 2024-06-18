package org.example.command;

import org.example.exceeption.NoElementException;
import org.example.exceeption.RootException;
import org.example.exceeption.WrongArgumentException;
import org.example.filelogic.WriterJSON;
import org.example.system.Console;

import java.io.IOException;

public class SaveCommand implements BaseCommand{
    @Override
    public String execute(String[] args) throws IOException, RootException {
        WriterJSON.write(Console.path);
        return null;
    }

    @Override
    public String getName() {
        return "save";
    }

    @Override
    public String getDescription() {
        return "save data";
    }
}
