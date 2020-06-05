package Model.ModosMVC.User;

import Model.ISistema;
import View.IAppView;

import java.util.List;

public interface IUserController {
    void setSistema(ISistema sistema);
    void setAppView(IAppView view);
    void userMode();
    void catalogo(int opcao);
    List<String> escolheProdLoja(int opcao);
}
