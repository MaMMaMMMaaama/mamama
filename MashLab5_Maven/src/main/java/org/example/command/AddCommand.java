package org.example.command;

import org.example.system.Receiver;

public class AddCommand implements BaseCommand{

    @Override
    public String execute(String[] args) {
        Receiver.addNewWorker();
        return null;
    }

    @Override
    public String getName() {
        return "add";
    }

    @Override
    public String getDescription() {
        return "add new";
    }
}
