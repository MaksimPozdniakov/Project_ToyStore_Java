package program.model.commands.mainClass;

import program.view.ConsoleUI2;

import java.io.FileNotFoundException;

public abstract class Command {

    protected ConsoleUI2 console;

    public Command(ConsoleUI2 console){
        this.console = console;
    }

    public abstract String description();

    public ConsoleUI2 getConsole(){
        return console;
    }

    public abstract void callCommand() throws FileNotFoundException;

}
