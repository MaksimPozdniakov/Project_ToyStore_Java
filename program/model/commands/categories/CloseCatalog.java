package program.model.commands.categories;

import program.model.commands.mainClass.Command;
import program.view.ConsoleUI2;
import java.io.FileNotFoundException;

public class CloseCatalog extends Command {
    public CloseCatalog(ConsoleUI2 console) {
        super(console);
    }

    @Override
    public String description() {
        return "Выйти";
    }

    @Override
    public void callCommand() throws FileNotFoundException {
        getConsole().closeCatalog();
    }
}
