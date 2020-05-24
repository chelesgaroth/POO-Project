package View;

import Model.Catalogos.ICatalogoProds;

public interface IAppView {
    void inicio ();
    void registo ();
    void mode(int x, String nome);
    void printMensagem(String s);
    void login(int x);
    void userMode();
}
