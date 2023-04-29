package program.model.commands.categories;

import program.model.commands.mainClass.Command;
import program.view.ConsoleUI2;
import java.io.FileNotFoundException;

public class SaveCatalog extends Command {
    public SaveCatalog(ConsoleUI2 console) {
        super(console);
    }

    @Override
    public String description() {
        return "Сохранить изменения";
    }

    @Override
    public void callCommand() throws FileNotFoundException {
        getConsole().saveCatalog();
    }
}
