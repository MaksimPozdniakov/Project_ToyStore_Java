package program.model.commands;

import program.model.commands.categories.*;
import program.model.commands.mainClass.Command;
import program.view.ConsoleUI2;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


public class MainMenu {

    protected List<Command> commandList;

    public MainMenu(ConsoleUI2 console){
        commandList = new ArrayList<>();
        commandList.add(new OpenCatalog(console));
        commandList.add(new PrintCatalog(console));
        commandList.add(new AddNewToy(console));
        commandList.add(new RemoveToy(console));
        commandList.add(new WinPrize(console));
        commandList.add(new Search(console));
        commandList.add(new SaveCatalog(console));
        commandList.add(new CloseCatalog(console));
    }

    public String showMenu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append("\t");
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).description());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public int getSizeMenu(){
        return commandList.size();
    }

    public void execute(int num) throws FileNotFoundException {
        Command func = commandList.get(num);
        func.callCommand();
    }

}
