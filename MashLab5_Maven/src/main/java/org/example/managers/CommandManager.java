package org.example.managers;

import org.example.command.*;

import java.util.ArrayDeque;
import java.util.HashMap;

public class CommandManager {
    private static HashMap<String, BaseCommand> commandList = new HashMap<>();
    public static ArrayDeque<BaseCommand> lastSixCommand = new ArrayDeque<>();
    public CommandManager(){
        commandList.put("help", new HelpCommand());
        commandList.put("info", new InfoCommand());
        commandList.put("show", new ShowCommand());
        commandList.put("add", new AddCommand());
        commandList.put("update", new UpdateCommand());
        commandList.put("remove", new RemoveCommand());
        commandList.put("execute_script", new ExecuteScriptCommand());
        commandList.put("save", new SaveCommand());
        commandList.put("clear", new ClearCommand());
    }

    public static void executeCommand(String line){
        String[] sp = line.split(" ");
        BaseCommand command = commandList.get(sp[0]);
        try {
            command.execute(sp);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static HashMap<String, BaseCommand> getCommandList() {
        return commandList;
    }
}
