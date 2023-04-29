package program.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {
    protected String path;

    public ReadFile(String path) {
        this.path = path;
    }

    public ArrayList<String> read(ArrayList<String> ourFile) throws FileNotFoundException {
        Scanner s = new Scanner(new File(path));
        while (s.hasNextLine()){
            ourFile.add(s.nextLine());
        }
        s.close();
        return ourFile;
    }
}
