package View;

import Model.Catalogos.ICatalogoProds;

public interface INavegador {
    void divide(ICatalogoProds cat, String mensagem);
    void proxima(ICatalogoProds cat, String mensagem);
    void anterior(ICatalogoProds cat, String mensagem);
    void total(ICatalogoProds cat);
    void escolha(ICatalogoProds cat, String mensagem, int num);
    void menu ();
}
