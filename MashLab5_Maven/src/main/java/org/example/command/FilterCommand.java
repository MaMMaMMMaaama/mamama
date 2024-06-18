package org.example.command;

import org.example.exceeption.WrongArgumentException;
import org.example.system.Reciever;

public class FilterCommand implements BaseCommand{
    @Override
    public String execute(String[] args) throws Exception {
        if (args.length == 2){
            Reciever.filterContainsName(args[1]);
        }else throw new WrongArgumentException();
        return null;
    }

    @Override
    public String getName() {
        return "filter_contains_name";
    }

    @Override
    public String getDescription() {
        return "filter_contains_name_edition";
    }
}
