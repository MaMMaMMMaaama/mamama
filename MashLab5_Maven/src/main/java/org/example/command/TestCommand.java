package org.example.command;

import org.example.system.Receiver;

public class TestCommand implements BaseCommand{
    @Override
    public String execute(String[] args) {
        Receiver.showTest();
        return "";
    }

    @Override
    public String getName() {
        return "test";
    }

    @Override
    public String getDescription() {
        return "print 'Test'";
    }
}
