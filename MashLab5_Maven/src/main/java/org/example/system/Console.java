package org.example.system;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.exceeption.ReadFileException;
import org.example.exceeption.RootException;
import org.example.filelogic.ReaderJSON;
import org.example.managers.CollectionManager;
import org.example.managers.CommandManager;

import java.util.Scanner;

public class Console {
    public static String path;
    CommandManager commandManager;

    public Console() {
        this.commandManager = new CommandManager();
    }

    public void start(){
        try {
            ReaderJSON.read(path);
        } catch (RootException | JsonProcessingException | ReadFileException e) {
            System.out.println("Что-то не так с файлом");
        }

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String line = sc.nextLine();
            String[] sp = line.split(" ");
            if (commandManager.getCommandList().containsKey(sp[0])){
                commandManager.executeCommand(line);
            } else {
                System.out.println("такой команды нет");
            }
        }
    }

    public static String getPath() {
        return path;
    }

    public static void setPath(String line) {
        path = line;
    }
}
