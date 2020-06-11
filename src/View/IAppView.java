package View;

import Model.Catalogos.ICatalogoProds;

public interface IAppView {
    void preInicio();
    void inicio ();
    void registo ();
    void printMensagem(String s);
    void login(int x);
    void reg (int x);
}
