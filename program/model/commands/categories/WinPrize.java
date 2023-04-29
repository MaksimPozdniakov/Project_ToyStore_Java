package program.model.commands.categories;

import program.model.commands.mainClass.Command;
import program.view.ConsoleUI2;
import java.io.FileNotFoundException;

public class WinPrize extends Command {
    public WinPrize(ConsoleUI2 console) {
        super(console);
    }

    @Override
    public String description() {
        return "Выиграй приз";
    }

    @Override
    public void callCommand() throws FileNotFoundException {
        getConsole().win();
    }
}
