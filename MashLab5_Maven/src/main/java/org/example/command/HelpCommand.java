package org.example.command;

import org.example.system.Receiver;

public class HelpCommand implements BaseCommand{
    @Override
    public String execute(String[] args) {
        Receiver.showHelp();
        return null;
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "show all commands";
    }
}
