package Controller;

import Model.ISistema;
import View.IVoluntarioView;

public interface IVoluntarioController {

    void setSistema(ISistema sistema);
    void setAppView(IVoluntarioView view);
    void setVoluntario();
    void VoluntarioMode();
}
