package Controller;

import Model.ISistema;
import View.IAppView;

public interface IAppController {
    void setSistema(ISistema sistema);
    void setAppView(IAppView view);
    void runController();
    char signUp ();
    void userMode();
}
