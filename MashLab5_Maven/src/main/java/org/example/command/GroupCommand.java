package org.example.command;

import org.example.exceeption.WrongArgumentException;
import org.example.system.Reciever;

public class GroupCommand implements BaseCommand{
    @Override
    public String execute(String[] args) throws Exception {

        if (args.length == 1){
            Reciever.groupCountingByCoordinates();
        } else throw new WrongArgumentException();
        return null;
    }



    @Override
    public String getName() {
        return "group_counting_by_coordinates";
    }

    @Override
    public String getDescription() {
        return "group_counting_by_coordinates";
    }
}
