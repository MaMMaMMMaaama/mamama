package org.example.command;

import org.example.exceeption.NoElementException;
import org.example.exceeption.RootException;
import org.example.exceeption.WrongArgumentException;

import java.io.IOException;

public interface BaseCommand {
    String execute(String[] args) throws Exception;
    String getName();
    String getDescription();
}
