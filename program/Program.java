package program;

import program.model.Model;
import program.model.Service;
import program.presenter.Presenter;
import program.presenter.View;
import program.view.ConsoleUI2;

import java.io.FileNotFoundException;

public class Program {
    public static void main(String[] args) throws FileNotFoundException {
        View view = new ConsoleUI2();
        Service service = new Model();
        new Presenter(view,service);
        view.start();
    }
}
