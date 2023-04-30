package program.presenter;

import program.model.Service;
import program.model.baseClass.Toy;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Presenter {

    protected View view;
    protected Service service;

    public Presenter(View view, Service service){
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void addNewToy(Toy newEl){
        ArrayList<String> ourToys = new ArrayList<>();
        ourToys.add(newEl.toString());
        service.getToy(ourToys);
    }

    public void open() throws FileNotFoundException {
        service.openDb();
    }

    public void print(){
        service.showAll();
    }

    public void lottery2(){
        service.lottery();
    }

    public void save(){
        service.write();
    }

    public void delToy(int index){
        service.delToy(index);
    }
}
