package org.example.command;

import org.example.system.Receiver;

public class ClearCommand implements BaseCommand{
    @Override
    public String execute(String[] args) {
        Receiver.clearCollection();
        return null;
    }

    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String getDescription() {
        return "clear collection";
    }
}
