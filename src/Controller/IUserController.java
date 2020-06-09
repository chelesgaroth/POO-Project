package Controller;

import Model.Catalogos.IProduto;
import Model.ISistema;
import View.IUserView;

import java.util.List;

public interface IUserController {
    void setSistema(ISistema sistema);
    void setAppView(IUserView view);
    int userMode();
    void catalogo(int opcao, List<IProduto> prods, List<String> quantidades);
    String escolheProdLoja(int opcao,List<IProduto> prods, List<String> quantidades);
}