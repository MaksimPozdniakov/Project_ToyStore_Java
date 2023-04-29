package program.presenter;

import java.io.FileNotFoundException;

public interface View {

    void start() throws FileNotFoundException;
    void setPresenter(Presenter presenter);

}
