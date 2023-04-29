package program.model;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface Service {

    void getToy(ArrayList<String> ourToys);

    void showAll();

    ArrayList<String> openDb() throws FileNotFoundException;

    void write();

    void lottery();


//    void test();
}
