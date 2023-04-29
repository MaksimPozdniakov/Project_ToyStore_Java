package program.model.commands.categories;

import program.model.commands.mainClass.Command;
import program.view.ConsoleUI2;
import java.io.FileNotFoundException;

public class AddNewToy extends Command {

    public AddNewToy(ConsoleUI2 console){
        super(console);
    }

    @Override
    public String description() {
        return "Добавить новую игрушку";
    }

    @Override
    public void callCommand() throws FileNotFoundException {
        getConsole().newToy();
    }
}
