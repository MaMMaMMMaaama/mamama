package org.example.command;

import org.example.system.Receiver;

public class ShuffleCommand implements BaseCommand{
    @Override
    public String execute(String[] args) {
        Receiver.shuffleCollection();
        return null;
    }

    @Override
    public String getName() {
        return "shuffle";
    }

    @Override
    public String getDescription() {
        return "shuffle collection";
    }
}

