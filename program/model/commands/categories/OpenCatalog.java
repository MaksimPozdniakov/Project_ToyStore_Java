package program.model.commands.categories;

import program.model.commands.mainClass.Command;
import program.view.ConsoleUI2;
import java.io.FileNotFoundException;

public class OpenCatalog extends Command {
    public OpenCatalog(ConsoleUI2 console) {
        super(console);
    }

    @Override
    public String description() {
        return "Открыть каталог";
    }

    @Override
    public void callCommand() throws FileNotFoundException {
        getConsole().openBook();
    }
}
