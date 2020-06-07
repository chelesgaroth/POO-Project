package Model.ModosMVC.Loja;

import Model.Encomendas.IEncomenda;
import Model.ISistema;

public interface ILojaController {
    void setSistema(ISistema sistema);
    void setView(ILojaView view);
    void setModel(IAppLoja model);

    void lojaMode();

}
