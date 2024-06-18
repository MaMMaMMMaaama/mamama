package org.example.command;

import org.example.exceeption.WrongArgumentException;
import org.example.system.Reciever;

public class MaxCommand implements BaseCommand {

    @Override
    public String execute(String[] args) throws Exception {
        if (args.length == 1){
            Reciever.maxByPerson();
        }else throw new WrongArgumentException();
        return null;
    }

    @Override
    public String getName() {
        return "max_by_person";
    }

    @Override
    public String getDescription() {
        return "max_by_person_edition";
    }
}
