package org.example.command;

import org.example.exceeption.WrongArgumentException;

public class ExitCommand implements BaseCommand{
    @Override
    public String execute(String[] args) throws Exception {
        if (args.length == 1) {
            System.exit(1);
            return "Завершение работы программы";
        } else{
            throw new WrongArgumentException();
        }
    }

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return "exit_program";
    }
}
