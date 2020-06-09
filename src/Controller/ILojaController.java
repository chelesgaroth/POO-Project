package Controller;

import Model.ISistema;
import View.ILojaView;

public interface ILojaController {
    void setSistema(ISistema sistema);
    void setView(ILojaView view);

    void lojaMode();

}
