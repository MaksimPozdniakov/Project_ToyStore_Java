package program.model.commands.categories;

import program.model.commands.mainClass.Command;
import program.view.ConsoleUI2;
import java.io.FileNotFoundException;

public class PrintCatalog extends Command {
    public PrintCatalog(ConsoleUI2 console) {
        super(console);
    }

    @Override
    public String description() {
        return "Показать весь каталог";
    }

    @Override
    public void callCommand() throws FileNotFoundException {
        getConsole().showCatalog();
    }
}
