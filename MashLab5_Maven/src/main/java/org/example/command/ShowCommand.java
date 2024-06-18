package org.example.command;

import org.example.system.Receiver;

public class ShowCommand implements BaseCommand{
    @Override
    public String execute(String[] args) {
        Receiver.showWorkers();
        return null;
    }

    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String getDescription() {
        return "show workers";
    }
}
