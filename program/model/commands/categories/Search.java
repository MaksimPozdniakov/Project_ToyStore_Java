package program.model.commands.categories;

import program.model.commands.mainClass.Command;
import program.view.ConsoleUI2;

import java.io.FileNotFoundException;

public class Search extends Command {
    public Search(ConsoleUI2 console) {
        super(console);
    }

    @Override
    public String description() {
        return "Поиск игрушки";
    }

    @Override
    public void callCommand() throws FileNotFoundException {
        getConsole().search();
    }
}
